package bl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import db.DAOShopartikel;
import db.DAOTamagotchiImpl;
import db.DAOUserImpl;
import bo.*;
/**
 * Businesslogik für Tamagotchiangelegenheiten
 * @author Snatsch
 *
 */
public class BLTamagotchi {

	private User currentUser = Login.getInstance().getUserInstance();
	private DAOTamagotchiImpl DAOT = new DAOTamagotchiImpl();
	
	/**
	 * Konstruktor
	 * @param currentUser
	 */
	public BLTamagotchi() {
		super();
	}

	/**
	 * Getter User
	 * @return
	 */
	public User getCurrentUser() {
		return currentUser;
	}
	
	/**
	 * Tamagotchi zu Trinken geben
	 * @param DrinkItem
	 * @return
	 * @throws SQLException
	 */
	public boolean giveTamagotchiADrink(Item DrinkItem) throws SQLException
	{
		if(currentUser.getTamagotchi().isThirsty())
		{
			if(DAOT.changeItem(DrinkItem))
			{
				if(DAOT.setToActualDate(currentUser.getTamagotchi(), "letzteTrinkzeit"))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Tamagotchi waschen
	 * @return
	 * @throws SQLException
	 */
	public boolean washTamagotchi() throws SQLException
	{
		// Tamagotchi ist schmutzig?
		if(currentUser.getTamagotchi().isDirty())
		{
			if(DAOT.setToActualDate(currentUser.getTamagotchi(), "letzteWaschzeit"))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Tamagotchi schlafenlegen
	 * @return
	 * @throws SQLException
	 */
	public boolean layTamagotchiToSleep() throws SQLException
	{
		if(currentUser.getTamagotchi().isTired() && !currentUser.getTamagotchi().isStillSleeping())
		{
			if(DAOT.setToActualDate(currentUser.getTamagotchi(), "letzteSchlafenszeit"))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Tamagotchi füttern
	 * @param FoodItem
	 * @return
	 * @throws SQLException
	 */
	public boolean feedTamagotchi(Item FoodItem) throws SQLException
	{
		if(currentUser.getTamagotchi().isHungry())
		{
			if(DAOT.changeItem(FoodItem))
			{
				if(DAOT.setToActualDate(currentUser.getTamagotchi(), "letzteFuetterungszeit"))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Tamagotchi updaten
	 * @param Tamagotchi
	 * @return
	 * @throws SQLException
	 */
	public boolean changeTamagotchi(Tamagotchi Tamagotchi) throws SQLException
	{
		return DAOT.changeTamagotchi(Tamagotchi);
	}
	
	/**
	 * Methode Medizin verwenden
	 * @return War Medizinübergabe erfolgreich?
	 * @throws SQLException
	 */
	public boolean gibMedizin() throws SQLException
	{
		boolean MedizinGebenErfolgreich = false;
		
		if(currentUser.getTamagotchi().verwendeMedizin())
		{
			MedizinGebenErfolgreich = DAOT.changeTamagotchi(currentUser.getTamagotchi());
		}
		
		return MedizinGebenErfolgreich;
	}
	
	/**
	 * 
	 * @param Menge
	 * @param Preis
	 * @return War Kauf erfolgreich?
	 * @throws SQLException
	 */
	public boolean kaufeMedizin(int Menge, int Preis) throws SQLException
	{
		boolean KaufErfolgreich = false;
		
		System.out.println(currentUser.getTamagotchi().GibGeldAus(Menge * Preis));
		System.out.println(currentUser.getTamagotchi().kaufeMedizin(Menge));
		
		if(currentUser.getTamagotchi().GibGeldAus(Menge * Preis) && currentUser.getTamagotchi().kaufeMedizin(Menge))
		{
			KaufErfolgreich = DAOT.changeTamagotchi(currentUser.getTamagotchi());
		}
		
		return KaufErfolgreich;
	}
	
	/**
	 * 
	 * @param Shopartikel
	 * @return
	 * @throws SQLException
	 */
	public boolean kaufeItem(Shopartikel Shopartikel) throws SQLException
	{
		Item ItemToBuy = new Item(Shopartikel, getCurrentUser().getTamagotchi().getId());
		
		boolean KaufErfolgreich = false;
		
		if(currentUser.getTamagotchi().GibGeldAus(Shopartikel.getPreis()) && getInventory(Shopartikel.getKategorie()).size() < 5)
		{
			KaufErfolgreich = DAOT.changeTamagotchi(currentUser.getTamagotchi()) && DAOT.addItem(ItemToBuy);
		}
		return KaufErfolgreich;
	}
	
	/**
	 * Getter Inventory
	 * @param kat
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Item> getInventory(Kategorie kat) throws SQLException
	{
		ArrayList<Item> ItemList = new ArrayList<Item>();
		for(Item Item : DAOT.getInventar(currentUser.getTamagotchi().getId()))
		{
			if(!Item.istVerwendet() && (Item.getShopartikel().getKategorie() == kat || kat == null))
			{
				ItemList.add(Item);
			}
		}
		return ItemList;
	}
	
	/**
	 * Getter Foodinventar
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Item> getFoodItems() throws SQLException
	{
		return getInventory(Kategorie.FUTTER);
	}
	
	/**
	 * Getter Trinkinventar
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Item> getDrinkItems() throws SQLException
	{
		return getInventory(Kategorie.GETRÄNK);
	}
	
	/**
	 * zurücksetzen Tamagotchi
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean resetTamagotchi(String name) throws SQLException
	{
		Tamagotchi resetedTamagotchi = new Tamagotchi(name, currentUser);
		
		if(name.length() < 10 && name.length() != 0)
		{
			if(DAOT.setToActualDate(resetedTamagotchi, "letzteWaschzeit") & DAOT.setToActualDate(resetedTamagotchi, "letzteSchlafenszeit") & DAOT.setToActualDate(resetedTamagotchi, "letzteSpielzeit") & DAOT.setToActualDate(resetedTamagotchi, "letzteFuetterungszeit") & DAOT.setToActualDate(resetedTamagotchi, "letzteTrinkzeit") & changeTamagotchi(resetedTamagotchi))
			{
				return true;
			}
		}
			
		return false;
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean addTamagotchi(String name) throws SQLException
	{
		Tamagotchi newTamagotchi = new Tamagotchi(name, currentUser);
		if(name.length() < 10 && name.length() != 0)
		{
			if(DAOT.addTamagotchi(newTamagotchi))
			{
				return true;
			}
		}
		
		return false;
	}
	
}
