package bl;

import java.sql.SQLException;
import java.util.ArrayList;

import db.DAOShoppartikelImpl;
import bo.Kategorie;
import bo.Shopartikel;
/**
 * Businesslogik für die Shopartikel
 * @author Snatsch
 *
 */
public class BLShopartikel {
	
	private DAOShoppartikelImpl DAOS = new DAOShoppartikelImpl();
	
	/**
	 * Getter alle Shopartikel für den aktuellen Shopaufruf
	 * @param filterKat
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Shopartikel> getFilteredShopartikel(Kategorie filterKat) throws SQLException
	{
		return DAOS.getFilteredShopartikel(filterKat);
	}
	
	/**
	 *  Getter Medizinpreis mit Menge Medizin
	 * @param Amount
	 * @return
	 * @throws SQLException
	 */
	public int getMedicinePrice(int Amount) throws SQLException
	{
		// id 2 ist Medizin
		return DAOS.getShopartikel(2).getPreis() * Amount;
	}
	
	/**
	 * Getter Article mit IDArticle
	 * @param idArticle
	 * @return Shopartikel
	 * @throws SQLException
	 */
	public Shopartikel getArticle(int idArticle) throws SQLException
	{
		return DAOS.getShopartikel(idArticle);
	}
	
}
