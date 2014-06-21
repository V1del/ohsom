package bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DAONachrichtenImpl;
import db.DAOTamagotchiImpl;
import db.DAOUserImpl;

public class User {
	private int id;
	private String Email;
	private String Nickname;
	public String Passwort;
	public Tamagotchi Tamagotchi;
	
	public User(ResultSet UserRS) throws SQLException
	{
		id = UserRS.getInt("idUser");
		Nickname = UserRS.getString("Nickname");
		Email = UserRS.getString("Email");
		Passwort = UserRS.getString("Passwort");
		
		DAOTamagotchiImpl DAOT = new DAOTamagotchiImpl();
		Tamagotchi = DAOT.getTamagotchi(id);
		
		
	}
	
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

	public int getId()
	{
		return id;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}

	public String getPasswort() {
		return Passwort;
	}

	public void setPasswort(String passwort) {
		Passwort = passwort;
	}

	public Highscore getHighscore() throws SQLException {
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getHighscore(id);
	}

	public Tamagotchi getTamagotchi() throws SQLException {
		return Tamagotchi;
	}
	public void setTamagotchi(Tamagotchi Tamagotchi) throws SQLException {
		this.Tamagotchi = Tamagotchi;
	}

	public boolean hasTamagotchi() throws SQLException
	{
		return !(Tamagotchi == null);
	}

	public ArrayList<TamagotchiConfig> getConfig() throws SQLException {
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getConfigData(id);
	}
	
}
