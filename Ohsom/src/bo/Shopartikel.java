package bo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Shopartikel - Klasse
 * @author vmuser
 *
 */
public class Shopartikel {
	public Shopartikel(ResultSet ShopartikelResultSet) throws SQLException {
		super();
		this.idArtikel = ShopartikelResultSet.getInt("idShop");
		this.Artikelname = ShopartikelResultSet.getString("Artikelname");
		this.Preis = ShopartikelResultSet.getInt("Preis");
		this.Kategorie = Kategorie.getKategorieByName(ShopartikelResultSet.getString("Kategorie"));
		this.ArtikelImage = ShopartikelResultSet.getString("ArtikelImage");
	}
	
	int idArtikel;
	String Artikelname;
	int Preis;
	Kategorie Kategorie;
	String ArtikelImage;

	/**
	 * Getter Artikelname
	 * @return
	 */
	public String getArtikelname() {
		return Artikelname;
	}
	
	/**
	 * Getter Preis
	 * @return
	 */
	public int getPreis() {
		return Preis;
	}
	
	/**
	 * Getter Kategorie
	 * @return
	 */
	public Kategorie getKategorie() {
		return Kategorie;
	}
	
	/**
	 * Getter ID
	 * @return
	 */
	public int getId()
	{
		return idArtikel;
	}
	
	/**
	 * Getter ArtikelImage
	 * @return
	 */
	public String getArtikelImage()
	{
		return this.ArtikelImage;
	}
	
}
