package db;

import java.sql.*;
import java.util.ArrayList;

import bo.Code;
import bo.Highscore;
import bo.TamagotchiConfig;
import bo.User;

public class DAOUserImpl implements DAOUser {

	private OhsomDBDAOImpl DBDAO = OhsomDBDAOImpl.getInstance();

	/**
	 * Standardkonstruktor
	 */
	public DAOUserImpl() {

	}
	
	/**
	 * Insert Statement zum Hinzufügen einer ConfigData
	 */
	public boolean addConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException {
		boolean isInsertingSuccessfull = false;
		
		PreparedStatement ConfigInsertpstmt = null;
		String ConfigInsertSQL = "INSERT INTO tamagotchiconfig(idUser, Hotkey, Code) VALUES (?,?,?)";
		
		ConfigInsertpstmt = DBDAO.getConnection().prepareStatement(ConfigInsertSQL);
		ConfigInsertpstmt.setInt(1, TamagotchiConfig.getidUser());
		ConfigInsertpstmt.setString(2, String.valueOf(TamagotchiConfig.getHotkey()));
		ConfigInsertpstmt.setString(3, TamagotchiConfig.getCode().name());
		
		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(ConfigInsertpstmt);
		
		return isInsertingSuccessfull;
	}

	/**
	 * Insert Statement zum Hinzufügen eines Highscores
	 */
	public boolean addHighscore(Highscore Highscore) throws SQLException {
		boolean isInsertingSuccessfull = false;

		PreparedStatement HighscoreInsertpstmt = null;
		String HighscoreInsertSQL = "INSERT INTO highscore(Punkte, idUser) VALUES (0, ?)";

		HighscoreInsertpstmt = DBDAO.getConnection().prepareStatement(HighscoreInsertSQL);
		HighscoreInsertpstmt.setInt(1, Highscore.getIdUser());

		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(HighscoreInsertpstmt);

		return isInsertingSuccessfull;
	}

	/**
	 * Insert Statement zum Hinzufügen eines Users
	 */
	public boolean addUser(User User) throws SQLException {
		boolean isInsertingSuccessfull = false;

		PreparedStatement UserInsertpstmt = null;
		String UserInsertSQL = "INSERT INTO user (Nickname, Passwort, Email) VALUES (?, ?, ?)";

		UserInsertpstmt = DBDAO.getConnection().prepareStatement(UserInsertSQL);
		UserInsertpstmt.setString(1, User.getNickname());
		UserInsertpstmt.setString(2, User.getPasswort());
		UserInsertpstmt.setString(3, User.getEmail());

		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(UserInsertpstmt);
		
		return isInsertingSuccessfull;
	}

	/**
	 * Delete eines Config - Datensatzes
	 * @throws SQLException 
	 */
	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException {
		boolean isDeletingSuccessfull = false;
		
		PreparedStatement ConfigDeletepstmt = null;
		String ConfigDeleteSQL = "DELETE FROM tamagotchiconfig WHERE idUser = ? and Code = ?";
		
		ConfigDeletepstmt = DBDAO.getConnection().prepareStatement(ConfigDeleteSQL);
		ConfigDeletepstmt.setInt(1, TamagotchiConfig.getidUser());
		ConfigDeletepstmt.setString(2, String.valueOf(TamagotchiConfig.getHotkey()));
		ConfigDeletepstmt.setString(3, TamagotchiConfig.getCode().name());
		
		isDeletingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(ConfigDeletepstmt);
		
		return isDeletingSuccessfull;
	}

	/**
	 * SQL Statement zum LÃ¶schen eines Users
	 * @param User der gelöscht werden soll
	 * @return User erfolgreich gelöscht
	 */
	public boolean deleteUser(User User) throws SQLException {
		boolean isDeletingSuccessfull = false;

		PreparedStatement UserDeletepstmt = null;
		String UserDeleteSQL = "DELETE FROM user WHERE idUser= ?";

		UserDeletepstmt = DBDAO.getConnection().prepareStatement(UserDeleteSQL);
		UserDeletepstmt.setInt(1, User.getId());

		isDeletingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(UserDeletepstmt);

		return isDeletingSuccessfull;
	}

	/**
	 * Statement zum Erfragen der Highscores
	 */
	public ArrayList<Highscore> getAllHighscores() throws SQLException {
		ArrayList<Highscore> HighscoreList = new ArrayList<Highscore>();
		PreparedStatement HighscorePstmt = null;
		String HighscoreSQL = "SELECT * FROM highscore ORDER BY punkte DESC";

		HighscorePstmt = DBDAO.getConnection().prepareStatement(HighscoreSQL);

		ResultSet HighscoreResultSet = DBDAO.SelectStatement(HighscorePstmt);

		while(HighscoreResultSet.next())
		{
			Highscore HighscoreObject = new Highscore(HighscoreResultSet.getInt("Punkte"), HighscoreResultSet.getInt("idUser"));
			HighscoreList.add(HighscoreObject);
		}

		return HighscoreList;
	}
	
	public Highscore getHighscore(int idUser) throws SQLException {
		for(Highscore Highscore : getAllHighscores()) {
			if(Highscore.getIdUser() == idUser)
			{
				return Highscore;
			}
		}
		return null;
	}

	/**
	 * Select Statement fÃ¼r TamagotchiConfig - DatensÃ¤tze
	 */
	public ArrayList<TamagotchiConfig> getConfigData(int idUser) throws SQLException {
		ArrayList<TamagotchiConfig> TamagotchiConfigList = new ArrayList<TamagotchiConfig>();
		PreparedStatement TamagotchiConfigPstmt = null;
		String TamagotchiConfigSQL = "SELECT * FROM tamagotchiconfig WHERE IDUSER = ?";

		TamagotchiConfigPstmt = DBDAO.getConnection().prepareStatement(TamagotchiConfigSQL);
		TamagotchiConfigPstmt.setInt(1, idUser);

		ResultSet TamagotchiConfigResultSet = DBDAO.SelectStatement(TamagotchiConfigPstmt);

		while(TamagotchiConfigResultSet.next())
		{
			TamagotchiConfig TamagotchiConfigObject = new TamagotchiConfig(TamagotchiConfigResultSet);
			TamagotchiConfigList.add(TamagotchiConfigObject);
		}

		return TamagotchiConfigList;
	}

	/**
	 * Update Statement fÃ¼r den Highscore - Datensatz
	 */
	public boolean updateHighscore(Highscore Highscore) throws SQLException {
		boolean isChangingSuccessfull = false;

		PreparedStatement HighscoreUpdatepstmt = null;
		String HighscoreUpdateSQL = "UPDATE highscore SET PUNKTE = ? WHERE IDUSER = ?";

		HighscoreUpdatepstmt = DBDAO.getConnection().prepareStatement(HighscoreUpdateSQL);
		HighscoreUpdatepstmt.setInt(1, Highscore.getPunkte());
		HighscoreUpdatepstmt.setInt(2, Highscore.getIdUser());

		isChangingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(HighscoreUpdatepstmt);

		return isChangingSuccessfull;
	}

	/**
	 * Update Statement fÃ¼r einen User - Datensatz
	 */
	public boolean updateUser(User User) throws SQLException {
		boolean isChangingSuccessfull = false;

		PreparedStatement UserUpdatepstmt = null;
		String UserUpdateSQL = "UPDATE user SET PASSWORT = ? WHERE IDUSER = ?";

		UserUpdatepstmt = DBDAO.getConnection().prepareStatement(UserUpdateSQL);
		UserUpdatepstmt.setString(1, User.getPasswort());
		UserUpdatepstmt.setInt(2, User.getId());

		isChangingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(UserUpdatepstmt);

		return isChangingSuccessfull;
	}

	/**
	 * Update der einzelnen Config Dateien
	 * @throws SQLException 
	 */
	public boolean updateConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException {
	boolean isUpdatingSuccessfull = false;
		
		PreparedStatement ConfigUpdatepstmt = null;
		String ConfigUpdateSQL = "UPDATE tamagotchiconfig SET Hotkey = ? WHERE idUser = ? and Code = ?";
		
		ConfigUpdatepstmt = DBDAO.getConnection().prepareStatement(ConfigUpdateSQL);
		ConfigUpdatepstmt.setString(1, String.valueOf(TamagotchiConfig.getHotkey()));
		ConfigUpdatepstmt.setInt(2, TamagotchiConfig.getidUser());
		ConfigUpdatepstmt.setString(3, TamagotchiConfig.getCode().name());
		
		isUpdatingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(ConfigUpdatepstmt);
		
		return isUpdatingSuccessfull;
	}

	/**
	 * Select um einen einzelnen User mithilfe seiner Email oder seines Nicknames zu erhalten
	 * @param SearchValue
	 * @param searchingForNickname
	 * @return User
	 * @throws SQLException
	 */
	public User getUser(String SearchValue, boolean searchingForNickname) throws SQLException
	{
		PreparedStatement Userpstmt = null;
		String UserNicknameSQL = "SELECT * FROM user WHERE NICKNAME = ?";
		String UserEmailSQL = "SELECT * FROM user WHERE EMAIL = ?";
		User UserObject = null;

		Userpstmt = DBDAO.getConnection().prepareStatement((searchingForNickname == true)?UserNicknameSQL:UserEmailSQL);
		Userpstmt.setString(1, SearchValue);

		ResultSet UserResultSet = DBDAO.SelectStatement(Userpstmt);
		if(UserResultSet.next())
		{
			UserObject = new User(UserResultSet);
		}


		return UserObject;
	}

	/**
	 * Select Statement fÃ¼r einen User mittels der ID
	 * @param idUser
	 * @return
	 * @throws SQLException
	 */
	public User getUser(int idUser) throws SQLException
	{
		PreparedStatement Userpstmt = null;
		String UserSQL = "SELECT * FROM user WHERE IDUSER = ?";
		User UserObject = null;

		Userpstmt = DBDAO.getConnection().prepareStatement(UserSQL);
		Userpstmt.setInt(1, idUser);

		ResultSet UserResultSet = DBDAO.SelectStatement(Userpstmt);

		if(UserResultSet.next())
		{
			UserObject = new User(UserResultSet);
		}

		return UserObject;

	}

	/**
	 * Select Statement nach einem bestimmten User mit Parameter User und Parameter Passwort
	 * @param Nickname
	 * @param Passwort
	 * @return
	 * @throws SQLException
	 */
	public User getUser(String Nickname, String Passwort) throws SQLException {
		PreparedStatement Userpstmt = null;
		String UserSQL = "SELECT * FROM user WHERE NICKNAME = ? AND PASSWORT = ?";
		User UserObject = null;

		Userpstmt = DBDAO.getConnection().prepareStatement(UserSQL);
		Userpstmt.setString(1, Nickname);
		Userpstmt.setString(2, Passwort);

		ResultSet UserResultSet = DBDAO.SelectStatement(Userpstmt); 
		if(UserResultSet.next())
		{
			UserObject = new User(UserResultSet);
		}


		return UserObject;
	}

	/**
	 * Select Statement fÃ¼r alle UserdatensÃ¤tze
	 */
	public ArrayList<User> getAllUsers() throws SQLException {
		ArrayList<User> UserList = new ArrayList<User>();
		PreparedStatement UserPstmt = null;
		String UserSQL = "SELECT * FROM user";

		UserPstmt = DBDAO.getConnection().prepareStatement(UserSQL);

		ResultSet UserResultSet = DBDAO.SelectStatement(UserPstmt);

		while(UserResultSet.next())
		{
			User UserObject = new User(UserResultSet);
			UserList.add(UserObject);
		}

		return UserList;
	}

}
