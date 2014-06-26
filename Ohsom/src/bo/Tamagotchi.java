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
		return (Geschlechtw == false) ? "männlich" : "weiblich";
	}
	
	/**
	 * Getter Geschlechtw as boolean 
	 * @return is Geschlecht weiblich
	 */
	public boolean isGeschlechtw()
	{
		return Geschlechtw;
	}
	
	/**
	 * Getter Alter (abhängig vom Geburtsdatum)
	 * @return
	 */
	public int getAlter() {
		return (int) TimeUnit.MILLISECONDS.toDays(new Date(new java.util.Date().getTime()).getTime() - Geburtsdatum.getTime());
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
		
		if(Medizin >= 1 && getGesundheitszustand() == Gesundheitszustand.KRANK)
 		{
			Medizin--;
			aktualisiereGesundheitszustand(Gesundheitszustand.GESUND);
			VerwendungErfolgreich = true;
		}
		return VerwendungErfolgreich;
	}

	/**
	 * Getter Gesundheitszustand
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
	 * Erfragen ob das Tamagotchi krank ist oder nicht
	 * @return
	 */
	public boolean isKrank()
	{
		aktualisiereCondition();
		
		return (Gesundheitszustand == Gesundheitszustand.KRANK);
	}
	
	/**
	 * Erfragen, ob das Tamagotchi tot ist oder nicht
	 * @return
	 */
	public boolean isDead()
	{
		aktualisiereCondition();
		
		return (Gesundheitszustand == Gesundheitszustand.TOT);
	}
	
	/**
	 * Checker der aktuellen Kondition des Tamagotchis (wie gesund ist es)
	 */
	public void aktualisiereCondition()
	{
		int survivingChance = 10;
		
		if(getBoringState() > 2)
		{
			survivingChance--;
		}
		
		if(getThirst() > 4)
		{
			survivingChance -= 2;
		}
		
		if(getHunger() > 4)
		{
			survivingChance -= 2;
		}
		
		if(isTired())
		{
			survivingChance--;
		}
		
		if(isDirty())
		{
			survivingChance--;
		}
				
		if(Gesundheitszustand == Gesundheitszustand.KRANK)
		{
			survivingChance--;
		}
		
		if(survivingChance < 4 || Gesundheitszustand == Gesundheitszustand.TOT || getAlter() > 70)
		{
			aktualisiereGesundheitszustand(Gesundheitszustand.TOT);
		}
		else if(survivingChance >= 4 && survivingChance <= 6 || Gesundheitszustand == Gesundheitszustand.KRANK)
		{
			aktualisiereGesundheitszustand(Gesundheitszustand.KRANK);
		}
		else
		{
			if(Gesundheitszustand != Gesundheitszustand.KRANK && Gesundheitszustand != Gesundheitszustand.TOT)
			{
				aktualisiereGesundheitszustand(Gesundheitszustand.GESUND);
			}
		}
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
	 * Getter BoringState
	 * @return
	 */
	public int getBoringState()
	{		
		long hours = TimeUnit.MILLISECONDS.toHours(new Date(new java.util.Date().getTime()).getTime() - letzteSpielzeit.getTime());

		int BoringState = 0;
		
		if(hours < 3)
		{
			BoringState =(int) hours;
		}
		else
		{
			BoringState = 3;
		}
		
		return BoringState;
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
	 * Ist Tamagotchi gelangweilt
	 * @return
	 */
	public boolean isBored()
	{
		return (getBoringState() > 0);
	}
	
	/**
	 * Ist Tamagotchi müde?
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public boolean isTired()
	{
		long pastHoursSinceLastSleep = TimeUnit.MILLISECONDS.toHours(new Date(new java.util.Date().getTime()).getTime() - letzteSchlafenszeit.getTime());
		
		if(pastHoursSinceLastSleep > 8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Ist Tamagotchi schmutzig?
	 * @return
	 */
	public boolean isDirty()
	{
		long pastHoursSinceLastWashingTime = TimeUnit.MILLISECONDS.toHours(new Date(new java.util.Date().getTime()).getTime() - letzteWaschzeit.getTime());
		
		if(pastHoursSinceLastWashingTime > 12)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * ist Tamagotchi noch am Schlafen?
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public boolean isStillSleeping()
	{
		long pastHoursSinceLastSleep = TimeUnit.MILLISECONDS.toHours(new Date(new java.util.Date().getTime()).getTime() - letzteSchlafenszeit.getTime());

		if(pastHoursSinceLastSleep < 2)
		{
			return true;
		}
		else
		{
			return false;
		}
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
	
	/**
	 * Getter Userid
	 * @return
	 * @throws SQLException
	 */
	public int getUserId() throws SQLException
	{
		return getUser().getId();
	}
	
	/**
	 * Getter User
	 * @return
	 * @throws SQLException 
	 */
	public User getUser() throws SQLException
	{
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getUser(idUser);
	}
	
	/**
	 * Getter Inventar
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
