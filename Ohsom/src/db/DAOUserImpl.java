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

	public boolean addHighscore(Highscore Highscore) throws SQLException {
		boolean isInsertingSuccessfull = false;
		
		PreparedStatement Highscorepstmt = null;
		String HighscoreSQL = "SELECT * FROM HIGHSCORE WHERE IDUSER = ?";
		
		Highscorepstmt = DBDAO.getConnection().prepareStatement(HighscoreSQL);
		Highscorepstmt.setInt(1, Highscore.getUser().getId());;
		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(Highscorepstmt);
				
		return isInsertingSuccessfull;
	}

	public boolean addUser(User User) throws SQLException {
		boolean isInsertingSuccessfull = false;
		
		PreparedStatement UserInsertpstmt = null;
		String UserInsertSQL = "INSERT INTO USER (Nickname, Passwort, Email) VALUES (?, ?, ?)";
		
		UserInsertpstmt = DBDAO.getConnection().prepareStatement(UserInsertSQL);
		UserInsertpstmt.setString(1, User.getNickname());
		UserInsertpstmt.setString(2, User.getPasswort());
		UserInsertpstmt.setString(3, User.getEmail());
		
		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(UserInsertpstmt);
		
		return isInsertingSuccessfull;
	}

	public boolean changeConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(User User) throws SQLException {
		boolean isDeletingSuccessfull = false;
		
		PreparedStatement UserDeletepstmt = null;
		String UserDeleteSQL = "DELETE FROM USER WHERE IDUSER = ?";
		
		UserDeletepstmt = DBDAO.getConnection().prepareStatement(UserDeleteSQL);
		UserDeletepstmt.setInt(1, User.getId());
		
		isDeletingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(UserDeletepstmt);
				
		return isDeletingSuccessfull;
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
		boolean isChangingSuccessfull = false;
		
		PreparedStatement UserUpdatepstmt = null;
		String UserUpdateSQL = "UPDATE USER SET EMAIL = ?, PASSWORT = ? WHERE ID = ?";


		try {
			UserUpdatepstmt = DBDAO.getConnection().prepareStatement(UserUpdateSQL);
			UserUpdatepstmt.setString(1, User.getEmail());
			UserUpdatepstmt.setString(2, User.getPasswort());
			UserUpdatepstmt.setInt(3, User.getId());
			
			isChangingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(UserUpdatepstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{}
		
		return isChangingSuccessfull;
	}

	public boolean updateConfig(TamagotchiConfig TamagotchiConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(String Nickname) throws SQLException
	{
		PreparedStatement Userpstmt = null;
		String UserSQL = "SELECT * FROM USER WHERE NICKNAME = ?";
		User UserObject = null;
		
		try 
		{
			Userpstmt = DBDAO.getConnection().prepareStatement(UserSQL);
			Userpstmt.setString(1, Nickname);
			
			ResultSet UserResultSet = DBDAO.SelectStatement(Userpstmt);
			if(!UserResultSet.isBeforeFirst())
			{
				UserObject = new User(UserResultSet);
			}
		}
		catch(NullPointerException e)
		{
			
			
		}
		
		return UserObject;
	}
	
	
	public User getUser(String Nickname, String Passwort) throws SQLException {
		PreparedStatement Userpstmt = null;
		String UserSQL = "SELECT IDUSER, NICKNAME, PASSWORT, EMAIL FROM USER WHERE NICKNAME = ? AND PASSWORT = ?";
		User UserObject = null;
		
		try {
			Userpstmt = DBDAO.getConnection().prepareStatement(UserSQL);
			Userpstmt.setString(1, Nickname);
			Userpstmt.setString(2, Passwort);
			
			ResultSet UserResultSet = DBDAO.SelectStatement(Userpstmt); 
			if(!UserResultSet.isBeforeFirst())
			{
				UserObject = new User(UserResultSet);
			}

		} catch (NullPointerException e)
		{
			
		}
		
		return UserObject;
	}

}
