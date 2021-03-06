package bl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JProgressBar;

import bo.*;
import db.*;

/**
 * Businesslogik fÃ¼r die Userangelegenheiten
 * @author Snatsch
 *
 */
public class BLUser {

	private DAOUserImpl DAOU = new DAOUserImpl();
	private User currentUser = Login.getInstance().getUserInstance();

	/**
	 * Überprüfung der Validität der Daten im Bezug auf das Vorhandensein in der Datenbank
	 * @param Nickname
	 * @param Passwort
	 * @return
	 * @throws SQLException
	 */
	public boolean isUserDataValid(String Nickname, String Passwort) throws SQLException
	{
		User currentUser = DAOU.getUser(Nickname, Passwort);
		setCurrentUser(currentUser);
		return !(currentUser == null);
	}
	
	/**
	 * Einloggen des Users
	 * @return Erfolgreiches Einloggen
	 */
	public boolean logUserIn(String Nickname, String Passwort) throws SQLException
	{
		return isUserDataValid(Nickname, Passwort);
	}
	
/**
 * Getter des aktuell eingeloggten Users
 * @return aktueller User
 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * Einloggen des aktuellen Users
	 * @param currentUser
	 */
	public void setCurrentUser(User currentUser) {
		Login.getInstance().logInUser(currentUser);
	}

	/**
	 * Insert eines weiteren Userdatensatzes
	 * @param User
	 * @return
	 * @throws SQLException
	 */
	public String createUser(User User) throws SQLException
	{
		String ResultCreatingUser = "";

		// Das Tamagotchi wird beim ersten Login erstellt
		User newUser = null;
		Highscore newHighscore = null;

		if(getAllUsers().size() < 50)
		{
			if((DAOU.getUser(User.getNickname(), true) == null))
			{
				if((DAOU.getUser(User.getEmail(), false) == null))
				{ 
					newUser = new User(User.getNickname(), User.getPasswort(), User.getEmail());
					if(DAOU.addUser(newUser))
					{
						newUser = DAOU.getUser(User.getNickname(), User.getPasswort());

						newHighscore = new Highscore(0, newUser.getId());
						if(!DAOU.addHighscore(newHighscore))
						{
							ResultCreatingUser = "Das zugehörige Highscorefile konnte nicht erstellt werden.";
						}
					}
					else
					{
						ResultCreatingUser = "Der Account konnte nicht erstellt werden.";
					}
				}
				else
				{
					ResultCreatingUser = "Einen User mit dieser Email gibt es schon!";
				}
			}
			else
			{
				ResultCreatingUser = "Diesen User gibt es bereits (wähle anderen Nickname).";
			}
		}
		else
		{
			ResultCreatingUser = "Es gibt bereits 50 User!";
		}
		
		return ResultCreatingUser;		
	}

	/**
	 * Abgleichung des Passworts mit verschiedenen Patterns
	 * @param strgToCheckForMatch
	 * @param Pattern
	 * @param BeforeAndAfter
	 * @return
	 */
	public boolean isValidToPattern(String strgToCheckForMatch, String Pattern, String BeforeAndAfter)
	{
		return strgToCheckForMatch.matches(BeforeAndAfter + Pattern + BeforeAndAfter) || strgToCheckForMatch.matches(Pattern + BeforeAndAfter) || strgToCheckForMatch.matches(BeforeAndAfter + Pattern);
	}

	/**
	 * Funktion zur Überprüfung der Passwortsicherheit
	 * @param Password
	 * @return Passwortsicherheit
	 */
	public int checkPasswordsStrength(String Password)
	{
		int PWStrength = 0;
		String patternNumeric = "\\d";
		String patternUpperCaseLetter = "[A-Z]";
		String patternSpecial = "\\p{Punct}";
		String BeforeAndAfter = ".*";

		if(Password.length() >= 8){ PWStrength++; }

		if(isValidToPattern(Password, patternNumeric, BeforeAndAfter)) { PWStrength++; }

		if(isValidToPattern(Password, patternUpperCaseLetter, BeforeAndAfter)) {PWStrength++;} 

		if(isValidToPattern(Password, patternSpecial, BeforeAndAfter)) { PWStrength++;}

		return PWStrength;
	}
	
	/** 
	 * Änderung des Labels für Passwortsicherheit
	 */
	public String getPasswordSecurityPB(int pwStrength)
	{
		switch(pwStrength)
		{
		case 1:
			return "schwach";
		case 2:
			return "mässig";
		case 3:
			return "ausreichend";
		case 4:
			return "stark";
		default:
			return "nicht vorhanden";
		}
	}

	/**
	 * Funktion zur Formatierung der Highscore DatensÃ¤tze 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("null")
	public Object[][] getHighscoreData() throws SQLException
	{
		ArrayList<Highscore> HighscoreList = getAllHighscores();
		Object[][] ObjectList = new String[HighscoreList.size()][3];
		int i = 0;
		for(Highscore h : HighscoreList)
		{
			ObjectList[i][0] = String.valueOf(i + 1);
			ObjectList[i][1] = DAOU.getUser(h.getIdUser()).getNickname();
			ObjectList[i][2] = String.valueOf(h.getPunkte()); 
			i++;
		};

		return ObjectList;
	}

	/**
	 * Insert der Config DatensÃ¤tze
	 * @param TamagotchiConfig
	 * @return
	 * @throws SQLException
	 */
	public boolean addConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException
	{
		return DAOU.addConfigData(TamagotchiConfig);
	}

	/**
	 * Update der Config DatensÃ¤tze
	 * @param TamagotchiConfig
	 * @return
	 * @throws SQLException
	 */
	public boolean updateConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException
	{
		return DAOU.updateConfigData(TamagotchiConfig);
	}

	/**
	 * Delete der Config Datensätze
	 * @param TamagotchiConfig
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException
	{
		return DAOU.deleteConfigData(TamagotchiConfig);
	}

	/**
	 * Editieren der Config Datensätze, die dem User zugehÃ¶rig sind
	 * @param TamagotchiConfig
	 * @return
	 * @throws SQLException
	 */
	public boolean editConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException
	{
		boolean isAlreadyInDataBase = false;

		for(TamagotchiConfig TamagotchiConfigDataBase : getTamagotchiConfig())
		{
			if(TamagotchiConfigDataBase.getCode() == TamagotchiConfig.getCode())
			{
				isAlreadyInDataBase = true;
			}
		}

		if(!isAlreadyInDataBase && String.valueOf(TamagotchiConfig.getHotkey()).equals("") == false)
		{
			return addConfigData(TamagotchiConfig);
		}
		else if(!isAlreadyInDataBase && TamagotchiConfig.getHotkey() == '\0')
		{
			return true;
		}
		else if(isAlreadyInDataBase && String.valueOf(TamagotchiConfig.getHotkey()).equals(""))
		{
			return deleteConfigData(TamagotchiConfig);
		}
		else
		{
			return updateConfigData(TamagotchiConfig);
		}
	}

	/**
	 * Select aller Highscores
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Highscore> getAllHighscores() throws SQLException
	{
		return DAOU.getAllHighscores();
	}

	/**
	 * Select aller User
	 * @return alle User
	 * @throws SQLException
	 */
	public ArrayList<User> getAllUsers() throws SQLException
	{
		return DAOU.getAllUsers();
	}

	/**
	 * Update Methode für den Highscore
	 * @param Punkte
	 * @return Wurde Highscore erfolgreich geupdatet
	 */
	public boolean updateHighscore(int Punkte) throws SQLException
	{
		Highscore editedHighscore = new Highscore(Punkte, currentUser.getId());
		return DAOU.updateHighscore(editedHighscore);
	}
	
	/**
	 * Getter alle TamagotchiConfig - Dateien
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<TamagotchiConfig> getTamagotchiConfig() throws SQLException
	{
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getConfigData(currentUser.getId());
	}
	
	/**
	 * Update Methode für den User
	 * @return Wurde User erfolgreich geupdatet
	 * @throws SQLException
	 */
	public boolean changeUser() throws SQLException
	{
		return DAOU.updateUser(currentUser);
		
	}

}
