package bo;

import java.util.Date;
import java.util.ArrayList;

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
	private Date letzteFuetterungszeit;
	private Date letzteSchlafenszeit;
	private Date letzteWaschzeit;
	private Date letzteTrinkzeit;
	private Date letzteSpielzeit;
	private Date letzteZustandsaenderung;
	private User User;
	private ArrayList<Item> Inventar;
	
// Konstruktoren
	
	/**
	 * Konstruktor für ein Tamagotchi, das bereits in der Datenbank ist
	 * @param id
	 * @param name
	 * @param geschlechtw
	 * @param geburtsdatum
	 * @param geld
	 * @param medizin
	 * @param gesundheitszustand
	 * @param letzteFuetterungszeit
	 * @param letzteSchlafenszeit
	 * @param letzteWaschzeit
	 * @param letzteTrinkzeit
	 * @param letzteSpielzeit
	 * @param letzteZustandsaenderung
	 * @param user
	 * @param inventar
	 */
	public Tamagotchi(int id, String name, boolean geschlechtw,
			Date geburtsdatum, int geld, int medizin,
			bo.Gesundheitszustand gesundheitszustand,
			Date letzteFuetterungszeit, Date letzteSchlafenszeit,
			Date letzteWaschzeit, Date letzteTrinkzeit, Date letzteSpielzeit,
			Date letzteZustandsaenderung, bo.User user, ArrayList<Item> inventar) {
		super();
		this.id = id;
		Name = name;
		Geschlechtw = geschlechtw;
		Geburtsdatum = geburtsdatum;
		Geld = geld;
		Medizin = medizin;
		Gesundheitszustand = gesundheitszustand;
		this.letzteFuetterungszeit = letzteFuetterungszeit;
		this.letzteSchlafenszeit = letzteSchlafenszeit;
		this.letzteWaschzeit = letzteWaschzeit;
		this.letzteTrinkzeit = letzteTrinkzeit;
		this.letzteSpielzeit = letzteSpielzeit;
		this.letzteZustandsaenderung = letzteZustandsaenderung;
		User = user;
		Inventar = inventar;
	}
	
	/**
	 * Konstruktor für ein Tamagotchi, das noch nicht in der Datenbank ist
	 * Konstruktor für ein Tamagotchi, das schon in der Datenbank ist aber resetet wird
	 * @param name
	 * @param user
	 */
	Tamagotchi(String name, User user)
	{
		Name = name;
		User = user;
		
		// Geschlecht wird zufällig ermittelt
		double zufall = Math.random() * 1;
		Geschlechtw = (zufall == 1) ? true : false;
		
		Geburtsdatum = new Date();
		letzteFuetterungszeit = new Date();
		letzteSchlafenszeit = new Date();
		letzteWaschzeit = new Date();
		letzteTrinkzeit = new Date();
		letzteSpielzeit = new Date();
		letzteZustandsaenderung = new Date();
		
		Gesundheitszustand = Gesundheitszustand.GESUND;
		Inventar = new ArrayList<Item>();
	}
	

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
	 * 
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
	 * Getter Alter (beruhend auf Geburtsdatum)
	 * @return
	 */
	public int getAlter() {
		Date today = new Date();
		return (int) ((int) today.getTime() - Geburtsdatum.getTime());
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
	 * Setter 2 Geld Tamagotchi zur Erhöhung des Geldstands
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
	 * Setter Medizin (erhöhen der Medizin um angegebene Menge)
	 * @param medizin
	 */
	public boolean kaufeMedizin(int medizin) {
		boolean KaufErfolgreich = false;
		
		if(Medizin + medizin <= 50)
		{
			Medizin += medizin;
			KaufErfolgreich = true;
		}
		
		return KaufErfolgreich;
		
	}
	
	public boolean verwendeMedizin()
	{
		boolean VerwendungErfolgreich = false;
		
		if(Medizin >= 1)
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
	public Date getLetzteFuetterungszeit() {
		return letzteFuetterungszeit;
	}
	
	/**
	 * Setter Fuetterungszeit
	 * @param letzteFuetterungszeit
	 */
	public void setLetzteFuetterungszeit(Date letzteFuetterungszeit) {
		this.letzteFuetterungszeit = letzteFuetterungszeit;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getLetzteSchlafenszeit() {
		return letzteSchlafenszeit;
	}
	
	/**
	 * 
	 * @param letzteSchlafenszeit
	 */
	public void setLetzteSchlafenszeit(Date letzteSchlafenszeit) {
		this.letzteSchlafenszeit = letzteSchlafenszeit;
	}
	
	/**
	 * Getter letzteWaschzeit
	 * @return
	 */
	public Date getLetzteWaschzeit() {
		return letzteWaschzeit;
	}
	
	/**
	 * Setter LetzteWaschzeit
	 * @param letzteWaschzeit
	 */
	public void setLetzteWaschzeit(Date letzteWaschzeit) {
		this.letzteWaschzeit = letzteWaschzeit;
	}

	/**
	 * 
	 * @return
	 */
	public Date getLetzteTrinkzeit() {
		return letzteTrinkzeit;
	}
	
	/**
	 * 
	 * @param letzteTrinkzeit
	 */
	public void setLetzteTrinkzeit(Date letzteTrinkzeit) {
		this.letzteTrinkzeit = letzteTrinkzeit;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getLetzteSpielzeit() {
		return letzteSpielzeit;
	}
	
	/**
	 * 
	 * @param letzteSpielzeit
	 */
	public void setLetzteSpielzeit(Date letzteSpielzeit) {
		this.letzteSpielzeit = letzteSpielzeit;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getLetzteZustandsaenderung() {
		return letzteZustandsaenderung;
	}
	
	/**
	 * 
	 * @param letzteZustandsaenderung
	 */
	public void setLetzteZustandsaenderung(Date letzteZustandsaenderung) {
		this.letzteZustandsaenderung = letzteZustandsaenderung;
	}
	
	/**
	 * Getter User (Nickname)
	 * @return
	 */
	public String getUser() {
		return User.getNickname();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Item> getInventar() {
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
