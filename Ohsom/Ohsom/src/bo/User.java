package bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
	private int id;
	private String Email;
	private String Nickname;
	public String Passwort;
	public Highscore Highscore;
	public Tamagotchi Tamagotchi;
	public ArrayList<TamagotchiConfig> Config;
	
	public User(ResultSet UserRS) throws SQLException
	{
			if(UserRS.next()){
				Nickname = UserRS.getString("Nickname");
				Email = UserRS.getString("Email");
				Passwort = UserRS.getString("Passwort");
			}
	}
	
	public User(String Nickname, String Passwort, String Email)
	{
		this.Nickname = Nickname;
		this.Email = Email;
		this.Passwort = Passwort;
	}
	
	public ArrayList<Nachricht> getNachrichten()
	{
		return null;
		
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

	public int getHighscore() {
		return Highscore.getPunkte();
	}

	public void setHighscore(int highscore) {
		Highscore.setPunkte(highscore);
	}

	public Tamagotchi getTamagotchi() {
		return Tamagotchi;
	}

	public ArrayList<TamagotchiConfig> getConfig() {
		return Config;
	}

	public void ConfigAddConfigData(TamagotchiConfig config) {
		this.Config.add(config);
	}
	
}
