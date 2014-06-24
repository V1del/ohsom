package bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DAONachrichtenImpl;
import db.DAOTamagotchiImpl;
import db.DAOUserImpl;

/**
 * Klasse User
 * @author Snatsch
 *
 */
public class User {
	private int id;
	private String Email;
	private String Nickname;
	public String Passwort;
	public Tamagotchi Tamagotchi;
	
	/**
	 * Konstruktor User, wenn Userdaten aus der Datenbank kommen
	 * @param UserRS
	 * @throws SQLException
	 */
	public User(ResultSet UserRS) throws SQLException
	{
		id = UserRS.getInt("idUser");
		Nickname = UserRS.getString("Nickname");
		Email = UserRS.getString("Email");
		Passwort = UserRS.getString("Passwort");
		
		DAOTamagotchiImpl DAOT = new DAOTamagotchiImpl();
		this.Tamagotchi = DAOT.getTamagotchi(id);
	}
	
	/**
	 * Konstruktor für neuen User
	 * @param Nickname
	 * @param Passwort
	 * @param Email
	 */
	public User(String Nickname, String Passwort, String Email)
	{
		this.Nickname = Nickname;
		this.Email = Email;
		this.Passwort = Passwort;
	}
	
	
	public ArrayList<Nachricht> getNachrichten() throws SQLException
	{
		DAONachrichtenImpl DAON = new DAONachrichtenImpl();
		return DAON.getNachrichten(id);
	}

	/**
	 * 
	 * @return
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getNickname() {
		return Nickname;
	}

	/**
	 * 
	 * @return
	 */
	public String getPasswort() {
		return Passwort;
	}

	/**
	 * 
	 */
	public Highscore getHighscore() throws SQLException {
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getHighscore(id);
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Tamagotchi getTamagotchi() throws SQLException {
		return Tamagotchi;
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean hasTamagotchi() throws SQLException
	{
		return !(getTamagotchi() == null);
	}

	/**
	 * get Config-Data
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<TamagotchiConfig> getConfig() throws SQLException {
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getConfigData(id);
	}
	
}
