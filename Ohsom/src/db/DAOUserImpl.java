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

	@Override
	public boolean addConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHighscore(Highscore Highscore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Highscore> getAllHighscores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TamagotchiConfig> getConfigData(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateHighscore(Highscore Highscore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateConfig(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String Nickname, String Passwort) {
		User UserObject = new User(DBDAO.SelectStatement("Select * from User where Nickname = ? and Passwort = ?"));
		return UserObject;
	}

}
