package bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import db.DAOTamagotchiImpl;
import db.DAOUserImpl;

/**
 * Klasse Tamagotchi
 * @author vmuser
 *
 */
public class Tamagotchi {

	private int id;
	private String Name;
	private boolean Geschlechtw;
	private Date Geburtsdatum;
	private int Geld = 100;
	private int Medizin = 1;
	private Gesundheitszustand Gesundheitszustand;
	private Timestamp letzteFuetterungszeit;
	private Timestamp letzteSchlafenszeit;
	private Timestamp letzteWaschzeit;
	private Timestamp letzteTrinkzeit;
	private Timestamp letzteSpielzeit;
	private int idUser;
//	private User User;
	private ArrayList<Item> Inventar;
	
// Konstruktoren
	
	/**
	 * Konstruktor f�r ein Tamagotchi, das noch nicht in der Datenbank ist
	 * Konstruktor f�r ein Tamagotchi, das schon in der Datenbank ist aber resetet wird
	 * @param name
	 * @param user
	 */
	public Tamagotchi(String name, User user)
	{
		Name = name;
		idUser = user.getId();
		
		// Geschlecht wird zuf�llig ermittelt
		double zufall = Math.random() * 1;
		Geschlechtw = (zufall == 1) ? true : false;
		
		Long Today = new java.util.Date().getTime();
		
		Geburtsdatum = new Date(Today);
		Geld = 100;
		Medizin = 1;
		
		Gesundheitszustand = Gesundheitszustand.GESUND;
		Inventar = new ArrayList<Item>();
	}
	
	/**
	 * Konstruktor für ein Tamagotchi aus der Datenbank
	 * @param tamagotchiResultSet
	 * @throws SQLException
	 */
	public Tamagotchi(ResultSet tamagotchiResultSet) throws SQLException {
		id = tamagotchiResultSet.getInt("idTamagotchi");
		Geld = tamagotchiResultSet.getInt("Geld");
		Geburtsdatum = tamagotchiResultSet.getDate("Geburtsdatum");
		Geschlechtw = tamagotchiResultSet.getBoolean("Geschlechtw");
		Name = tamagotchiResultSet.getString("Name");
		Geburtsdatum = tamagotchiResultSet.getDate("Geburtsdatum");
		letzteFuetterungszeit = tamagotchiResultSet.getTimestamp("letzteFuetterungszeit");
		letzteSchlafenszeit = tamagotchiResultSet.getTimestamp("letzteSchlafenszeit");
		letzteWaschzeit = tamagotchiResultSet.getTimestamp("letzteWaschzeit");
		letzteTrinkzeit = tamagotchiResultSet.getTimestamp("letzteTrinkzeit");
		letzteSpielzeit = tamagotchiResultSet.getTimestamp("letzteSpielzeit");
		Geld = tamagotchiResultSet.getInt("Geld");
		Medizin = tamagotchiResultSet.getInt("Medizin");
		idUser = tamagotchiResultSet.getInt("idUser");
		
		Gesundheitszustand = Gesundheitszustand.getGesundheitszustandByName(tamagotchiResultSet.getString("Gesundheitszustand"));
	
		DAOTamagotchiImpl DAOT = new DAOTamagotchiImpl();
		Inventar = DAOT.getInventar(id);
	}

	/** 
	 * Getter für das Evolutionsstadium
	 * @return
	 */
	public Entwicklungsstadium getEvolutionsstadium()
	{
		if(getAlter() > 1)
		{
			if(getAlter() < 20)
			{
				return Entwicklungsstadium.JUNGES;
			}
			else if(getAlter() < 40)
			{
				return Entwicklungsstadium.ERWACHSENES;
			}
			return Entwicklungsstadium.SENIOR;
		}
		else
		{
			return Entwicklungsstadium.EI;
		}
	}
		
	/**
	 * Getter ID
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter Name
	 * @return
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * Setter Name
	 * @param name
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * getter Geschlecht
	 * @return
	 */
	public String getGeschlecht() {
		return (Geschlechtw == false) ? "m�nnlich" : "weiblich";
	}
	
	/**
	 * Getter Geschlecht as boolean 
	 */
	public boolean isGeschlechtw()
	{
		return Geschlechtw;
	}
	
	
	/**
	 * Getter Alter (beruhend auf Geburtsdatum)
	 * @return
	 */
	public int getAlter() {
		Long Today_Long = new java.util.Date().getTime();
		Date Today_date = new Date(Today_Long);
		return (int) ((int) Today_date.getTime() - Geburtsdatum.getTime());
	}
	
	/**
	 * Getter Geburtsdatum 
	 * @return
	 */
	
	public Date getGeburtsdatum()
	{
		return Geburtsdatum;
	}

	/**
	 * Getter Geld
	 * @return
	 */
	public int getGeld() {
		return Geld;
	}
	
	/**
	 * Setter 1 Geld Tamagotchi zur Senkung des Geldstands
	 * @param geld
	 */
	public boolean GibGeldAus(int geld) {
	boolean AusgabeErfolgreich = false;	
		if(geld <= Geld)
		{
			Geld -= geld;
			AusgabeErfolgreich = true;
		}
		
		return AusgabeErfolgreich;
	}
	
	/**
	 * Setter 2 Geld Tamagotchi zur Erh�hung des Geldstands
	 * @param geld
	 */
	public void VerdienGeld(int geld)
	{
		Geld += geld;
	}
	
	/**
	 * Getter Medizinvorrat
	 * @return
	 */
	public int getMedizin() {
		return Medizin;
	}
	
	/**
	 * Setter Medizin (erh�hen der Medizin um angegebene Menge)
	 * @param medizin
	 */
	public boolean kaufeMedizin(int medizin) {
		boolean KaufErfolgreich = false;
		
		if(Medizin + medizin <= 100)
		{
			Medizin += medizin;
			KaufErfolgreich = true;
		}
		
		return KaufErfolgreich;
		
	}
	
	/**
	 * Setter Medizin (- 1) sofern krank
	 * @return
	 */
	public boolean verwendeMedizin()
	{
		boolean VerwendungErfolgreich = false;
		
		if(Medizin >= 1 & getGesundheitszustand() == Gesundheitszustand.KRANK)
		{
			Medizin--;
			VerwendungErfolgreich = true;
		}
		return VerwendungErfolgreich;
	}

	/**
	 * 
	 * @return
	 */
	public Gesundheitszustand getGesundheitszustand() {
		return Gesundheitszustand;
	}
	
	/**
	 * Aktualisieren des Gesundheitszustandes
	 * @param gesundheitszustand
	 */
	public void aktualisiereGesundheitszustand(Gesundheitszustand gesundheitszustand) {
		Gesundheitszustand = gesundheitszustand;
	}
	
	/**
	 * Getter Fuetterungszeit
	 * @return
	 */
	public int getHunger() {
		long hours = TimeUnit.MILLISECONDS.toHours(new Date(new java.util.Date().getTime()).getTime() - letzteFuetterungszeit.getTime());
		int Hunger = 0;
		if(hours <= 5)
		{
			Hunger = (int) hours;
		}
		else
		{
			Hunger = 5;
		}
		
		return Hunger;
	}
	
	/**
	 * Getter Thirst
	 * @return
	 */
	public int getThirst()
	{
		long hours = TimeUnit.MILLISECONDS.toHours(new Date(new java.util.Date().getTime()).getTime() - letzteTrinkzeit.getTime());
		
		int Durst = 0;
		
		if(hours <= 5)
		{
			Durst = (int) hours;
		}
		else
		{
			Durst = 5;
		}
		
		return Durst;
	}
	
	/**
	 * Ist Tamagotchi hungrig?
	 * @return
	 */
	public boolean isHungry()
	{
		return (getHunger() > 0);
	}
	
	/**
	 * Ist Tamagotchi durstig?
	 * @return
	 */
	public boolean isThirsty()
	{
		return(getThirst() > 0);
	}
	
	/**
	 * Setter Fuetterungszeit
	 * @param letzteFuetterungszeit
	 */
	public void setLetzteFuetterungszeit(Timestamp letzteFuetterungszeit) {
		this.letzteFuetterungszeit = letzteFuetterungszeit;
	}
	
	/**
	 * Getter Fuetterungszeit
	 * @return Fuetterungszeit
	 */
	public Timestamp getLetzteFuetterungszeit()
	{
		return this.letzteFuetterungszeit;
	}
	
	/**
	 * ist Tamagotchi noch am Schlafen?
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public boolean isStillSleeping()
	{
		if(getLetzteSchlafenszeit().getHours() < 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Ist Tamagotchi müde?
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public boolean isTired()
	{
		if(getLetzteSchlafenszeit().getHours() > 8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * Getter letzteSchlafenszeit
	 * @return
	 */
	public Timestamp getLetzteSchlafenszeit() {
		return letzteSchlafenszeit;
	}
	
	/**
	 * Getter letzteWaschzeit
	 * @return
	 */
	public Timestamp getLetzteWaschzeit() {
		return letzteWaschzeit;
	}
	
	/**
	 * Getter letzteTrinkzeit
	 * @return
	 */
	public Timestamp getLetzteTrinkzeit() {
		return letzteTrinkzeit;
	}
	
	/**
	 * Getter letzteSpielzeit
	 * @return
	 */
	public Timestamp getLetzteSpielzeit() {
		return letzteSpielzeit;
	}
	
	/**
	 * Getter User (Nickname)
	 * @return
	 * @throws SQLException 
	 */
	public String getUserNickname() throws SQLException {
		return getUser().getNickname();
	}
	
	public int getUserId() throws SQLException
	{
		return getUser().getId();
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public User getUser() throws SQLException
	{
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getUser(idUser);
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Item> getInventar() throws SQLException {
		return Inventar;
	}
	
	/**
	 * Add Item Methode
	 * @param newItem
	 */
	public void InventarAddItem(Item newItem) {
		Inventar.add(newItem);
	}
}
