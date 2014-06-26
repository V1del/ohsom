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
	
	
	/**
	 * Getter Nachrichten
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Nachricht> getNachrichten() throws SQLException
	{
		DAONachrichtenImpl DAON = new DAONachrichtenImpl();
		return DAON.getNachrichten(id);
	}

	/**
	 * Getter ID
	 * @return idUser
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Getter Email 
	 * @return
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * Setter Email
	 * @param email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * Getter Nickname
	 * @return Nickname
	 */
	public String getNickname() {
		return Nickname;
	}

	/**
	 * Getter Passwort 
	 * @return Passwort
	 */
	public String getPasswort() {
		return Passwort;
	}

	/**
	 * Getter Highscorefile
	 */
	public Highscore getHighscore() throws SQLException {
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getHighscore(id);
	}

	/**
	 * Getter Tamagotchi
	 * @return Tamagotchi
	 * @throws SQLException
	 */
	public Tamagotchi getTamagotchi() throws SQLException {
		return Tamagotchi;
	}
	
	/**
	 * Setter Tamagotchi
	 * @param Tamagotchi
	 * @throws SQLException
	 */
	public void setTamagotchi(Tamagotchi Tamagotchi) throws SQLException
	{
		this.Tamagotchi = Tamagotchi;
	}

	/**
	 * Hat User bereits ein Tamagotchi
	 * @return hat User Tamagotchi
	 * @throws SQLException
	 */
	public boolean hasTamagotchi() throws SQLException
	{
		return !(getTamagotchi() == null);
	}
	
}
