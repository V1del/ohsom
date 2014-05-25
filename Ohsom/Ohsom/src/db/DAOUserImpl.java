package db;

import java.util.ArrayList;

import bo.Highscore;
import bo.TamagotchiConfig;
import bo.User;

public class DAOUserImpl implements DAOUser {

	private OhsomDBDAO DBDAO;
	
	public DAOUserImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean addConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addHighscore(Highscore Highscore) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Highscore> getAllHighscores() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TamagotchiConfig> getConfigData(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateHighscore(Highscore Highscore) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateConfig(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(String Nickname, String Passwort) {
		User UserObject = new User(DBDAO.SelectStatement("Select * from User where Nickname = ? and Passwort = ?"));
		return UserObject;
	}

}
