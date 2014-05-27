package bo;

import java.sql.Date;

/**
 * Klasse Item
 * @author vmuser
 *
 */
public class Item {
	private Shopartikel Shopartikel;
	private Date Kaufdatum;
	private boolean verwendet = false;
	
	/**
	 * Konstruktor Item
	 * @param Shopartikel
	 * @param Kaufdatum
	 */
	Item(Shopartikel Shopartikel, Date Kaufdatum)
	{
		this.Shopartikel = Shopartikel;
		this.Kaufdatum = Kaufdatum;
	}
	
	/**
	 * Setter Verwendet - State
	 */
	public void setVerwendet()
	{
		this.verwendet = true;
	}
	
	/**
	 * Getter Verwendet - State
	 * @return
	 */
	public boolean istVerwendet()
	{
		return this.verwendet;
	}
	
	/**
	 * Getter Shopartikel (Artikelname)
	 * @return
	 */
	public String getShopartikel()
	{
		return Shopartikel.getArtikelname();
	}
}
