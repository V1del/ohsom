package bo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import db.DAOShoppartikelImpl;

/**
 * Klasse Item
 * @author vmuser
 *
 */
public class Item {
	private Shopartikel Shopartikel;
	private int idShop;
	private Timestamp Kaufdatum;
	private int idTamagotchi;
	private boolean verwendet = false;
	
	/**
	 * Konstruktor Item - Erstellung eines neuen Items
	 * @param Shopartikel
	 * @param Kaufdatum
	 */
	public Item(Shopartikel Shopartikel, int idTamagotchi)
	{
		this.Shopartikel = Shopartikel;
		this.Kaufdatum = new Timestamp(new java.util.Date().getTime());
		this.idTamagotchi = idTamagotchi;
	}
	
	/**
	 * Konstruktor Item aus der Datenbank
	 * @param ItemResultSet
	 * @throws SQLException
	 */
	public Item(ResultSet ItemResultSet) throws SQLException
	{
		this.idShop = ItemResultSet.getInt("idShop");
		this.Kaufdatum = ItemResultSet.getTimestamp("Kaufdatum");
		this.idTamagotchi = ItemResultSet.getInt("idTamagotchi");
		this.verwendet = ItemResultSet.getBoolean("verwendet");
		
		DAOShoppartikelImpl DAOS = new DAOShoppartikelImpl();
		this.Shopartikel = DAOS.getShopartikel(this.idShop);
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
	public Shopartikel getShopartikel()
	{
		return Shopartikel;
	}
	
	/**
	 * Getter ID Tamagotchi
	 * @return
	 */
	public int getIdTamagotchi()
	{
		return idTamagotchi;
	}

	/** 
	 * Getter Kaufdatum
	 * @return
	 */
	public Timestamp getKaufdatum() {
		return Kaufdatum;
	}

}
