package bl;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.*;
import db.*;

public class BLUser {

	private DAOUserImpl DAOU = new DAOUserImpl();
	private User currentUser = null;
	
	public boolean isUserDataValid(String Nickname, String Passwort) throws SQLException
	{
		User currentUser = DAOU.getUser(Nickname, Passwort); 
		setCurrentUser(currentUser);
		return !(currentUser == null);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public boolean createUser(User User) throws SQLException
	{
		boolean isUserSuccessfullyCreated = false;
		
		// Das Tamagotchi wird beim ersten Login erstellt
		User newUser = null;
		Highscore newHighscore = null;
		
		
		if(DAOU.getUser(User.getNickname()) == null)
		{
			newUser = new User(User.getNickname(), User.getPasswort(), User.getEmail());
			newHighscore = new Highscore(0, newUser);
			
			isUserSuccessfullyCreated = DAOU.addUser(newUser) && DAOU.addHighscore(newHighscore);
		}
		
		return isUserSuccessfullyCreated;		
	}
	
	public int checkPasswordsStrength(String Password)
	{
		int PWStrength = 0;
		String patternNumeric = ".*\\d*.*";
		String patternUpperCaseLetter = ".*[A-Z]*.*";
		String patternSpecial = ".*\\p{Punct}*.*";
		
		if(Password.length() >= 8){ PWStrength++; }
		
		if(Password.matches(patternNumeric)) { PWStrength++; }

		if(Password.matches(patternUpperCaseLetter)) {PWStrength++;} 
		
		if(Password.matches(patternSpecial)) { PWStrength++;}
		
		return PWStrength;
	}
	
	public ArrayList<Highscore> getAllHighscores()
	{
		return DAOU.getAllHighscores();
	}
	
}
