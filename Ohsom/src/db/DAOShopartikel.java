package db;

import java.util.ArrayList;
import bo.Shopartikel;

public interface DAOShopartikel {
	
	public ArrayList<Shopartikel> getAllShopartikel();
	
	public Shopartikel getShopartikel(int idShopartikel);
	
}
