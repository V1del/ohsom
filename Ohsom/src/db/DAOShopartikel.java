package db;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.Kategorie;
import bo.Shopartikel;

public interface DAOShopartikel {
	
	public ArrayList<Shopartikel> getFilteredShopartikel(Kategorie kat) throws SQLException;
	
	public Shopartikel getShopartikel(int idShopartikel) throws SQLException;
	
}
