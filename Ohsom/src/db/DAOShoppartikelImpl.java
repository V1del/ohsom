package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bo.Highscore;
import bo.Kategorie;
import bo.Shopartikel;

public class DAOShoppartikelImpl implements DAOShopartikel{

	OhsomDBDAOImpl DBDAO = new OhsomDBDAOImpl();
	
	public ArrayList<Shopartikel> getFilteredShopartikel(Kategorie kat) throws SQLException {
		ArrayList<Shopartikel> ShopartikelList = new ArrayList<Shopartikel>();
		PreparedStatement ShopartikelPstmt = null;
		String ShopartikelSQL = "SELECT * FROM shopartikel WHERE KATEGORIE = ? ORDER BY RAND() LIMIT 5";
		
		ShopartikelPstmt = DBDAO.getConnection().prepareStatement(ShopartikelSQL);
		if(kat != null)
		{
			ShopartikelPstmt.setString(1, kat.name());
		}
		
		ResultSet ShopartikelResultSet = DBDAO.SelectStatement(ShopartikelPstmt);

		while(ShopartikelResultSet.next())	
		{
			Shopartikel ShopartikelObject = new Shopartikel(ShopartikelResultSet);
			ShopartikelList.add(ShopartikelObject);
		}

		return ShopartikelList;
	}

	public Shopartikel getShopartikel(int idShopartikel) throws SQLException {
		PreparedStatement ShopartikelPstmt = null;
		String ShopartikelSQL = "SELECT * FROM shopartikel WHERE IDSHOP = ?";

		ShopartikelPstmt = DBDAO.getConnection().prepareStatement(ShopartikelSQL);
		ShopartikelPstmt.setInt(1, idShopartikel);

		ResultSet ShopartikelResultSet = DBDAO.SelectStatement(ShopartikelPstmt);

		if(ShopartikelResultSet.next())	
		{
			return new Shopartikel(ShopartikelResultSet);
		}

		return null;
	}
	
}
