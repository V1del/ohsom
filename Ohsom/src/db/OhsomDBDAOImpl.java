package db;

import java.sql.*;

import bl.Login;

public class OhsomDBDAOImpl {

	private Connection con = null;

	private static OhsomDBDAOImpl instance = null;

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/tamagotchi";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	protected OhsomDBDAOImpl() {
		con = createConnection();
	}

	public static OhsomDBDAOImpl getInstance() {
		if(instance == null) {
			instance = new OhsomDBDAOImpl();
		}
		return instance;
	}

	private Connection createConnection()
	{
		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);


		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager
					.getConnection(DB_CONNECTION + "?"
							+ "user=" + DB_USER + "&password=" + DB_PASSWORD);

			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;		
	}

	public Connection getConnection() throws SQLException
	{ 
		if(con == null || con.isClosed())
		{
			con = createConnection();
		}
		return con;
	}

	public ResultSet SelectStatement(PreparedStatement pstmt) throws SQLException
	{
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			
		}
		catch(SQLException ex)
		{

		}
		finally {
			if(pstmt == null) { pstmt.close(); con.close(); }
		}

		return rs;
	}

	public boolean SuccessfullInsertingChangingDeleting(PreparedStatement icdstmt) throws SQLException
	{
		boolean SuccessfullInsertingChangingDeleting = false;

		try {
			SuccessfullInsertingChangingDeleting = !icdstmt.execute();
		}
		catch(SQLException ex)
		{

		}
		finally{
			if(icdstmt == null) { icdstmt.close(); con.close();}
		}

		return SuccessfullInsertingChangingDeleting;
	}

}
