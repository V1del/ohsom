package db;

import java.sql.*;

public class OhsomDBDAOImpl {
	
	public OhsomDBDAOImpl UniqueInstanceOhsomDBDAOImpl;
	private Connection con;
	private ResultSet result;

	OhsomDBDAOImpl() throws ClassNotFoundException, SQLException
	{
		Class.forName("jdbc.odbc.JdbcOdbcDriver");
		DriverManager.getConnection("jdbc:odbc:Ohsom", "root", "");
		
	}
	
	public OhsomDBDAO getUniqueInstanceOhsomDBDAO()
	{
		return null;
	}
}
