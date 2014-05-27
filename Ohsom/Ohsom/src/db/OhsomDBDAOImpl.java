package db;

import java.sql.*;

public class OhsomDBDAOImpl {
	
	private Connection con = null;
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	//private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:TAMAGOTCHI";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	

	OhsomDBDAOImpl()
	{
		con = createConnection();
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
			          .getConnection("jdbc:mysql://localhost/tamagotchi?"
			              + "user=" + DB_USER + "&password=" + DB_PASSWORD);
			
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;		
	}
	
	public Connection getConnection()
	{ 
		if(con == null)
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
			if(pstmt == null) { pstmt.close(); }
		}
		
		return rs;
	}
	
	public boolean SuccessfullInsertingChangingDeleting(String Statement)
	{
		return false;
	}

}
