package db;

import java.sql.*;
import java.util.ArrayList;

import bo.Highscore;
import bo.TamagotchiConfig;
import bo.User;

public class DAOUserImpl implements DAOUser {

	private OhsomDBDAOImpl DBDAO;
	
	public DAOUserImpl() {
		DBDAO = new OhsomDBDAOImpl();
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
		String sql = "insert into User (Nickname, Passwort, Email) values (?, ?, ?)";
		return false;
	}

	public boolean changeConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeUser(User User) {
		String sql = "update User set Email = ? where idUser = ?";
		return false;
	}

	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(User User) {
		String sql = "delete from user where idUser = ?";
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

	public User getUser(String Nickname, String Passwort) throws SQLException {
		PreparedStatement Userpstmt = null;
		String UserSQL = "SELECT NICKNAME, PASSWORT, EMAIL FROM USER WHERE NICKNAME = ? AND PASSWORT = ?";
		User UserObject = null;
		
		try {
			Userpstmt = DBDAO.getConnection().prepareStatement(UserSQL);
			Userpstmt.setString(1, Nickname);
			Userpstmt.setString(2, Passwort);
			
			UserObject = new User(DBDAO.SelectStatement(Userpstmt));

		} catch (NullPointerException e)
		{
			
		}
		
		return UserObject;
	}

}
