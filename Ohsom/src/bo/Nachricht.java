package bo;

import java.util.Date;

/**
 * Nachricht - Klasse
 * @author vmuser
 */
public class Nachricht 
{
	private String Titel;
	private String Nachricht;
	private Date Zeitpunkt;
	private boolean gelesen;
	private User Sender;
	private User Empfaenger;

	/**
	 * Der Konstruktor, der notwendig ist, wenn das Tamagotchi bereits in der Datenbank vorhanden ist.
	 * @param titel
	 * @param nachricht
	 * @param zeitpunkt
	 * @param gelesen
	 * @param sender
	 * @param empfaenger
	 */
	public Nachricht(String titel, String nachricht, Date zeitpunkt,
			boolean gelesen, User sender, User empfaenger) {
		super();
		Titel = titel;
		Nachricht = nachricht;
		Zeitpunkt = zeitpunkt;
		this.gelesen = gelesen;
		Sender = sender;
		Empfaenger = empfaenger;
	}
	
	/**
	 * Der Konstruktor, der notwendig ist, wenn die Nachricht erst noch erstellt wird (Datum muss bei diesem Schritt generiert werden)
	 * Auch muss der Status gelesen direkt auf false gesetzt werden.
	 * @param titel
	 * @param nachricht
	 * @param empfaenger
	 * @param sender
	 */
	public Nachricht(String titel, String nachricht, User empfaenger, User sender)
	{
		super();
		Titel = titel;
		Nachricht = nachricht;
		Zeitpunkt = new Date();
		gelesen = false;
		Empfaenger = empfaenger;
		Sender = sender;
	}	
	
	/**
	 * Getter des Titels
	 * @return
	 */
	public String getTitel() {
		return Titel;
	}
	
	/**
	 * Setter des Titels
	 * @param titel
	 */
	public void setTitel(String titel) {
		Titel = titel;
	}
	
	/**
	 * Getter der Nachricht
	 * @return
	 */
	public String getNachricht() {
		return Nachricht;
	}
	
	/**
	 * Getter des Zeitpunkts
	 * @return
	 */
	public Date getZeitpunkt() {
		return Zeitpunkt;
	}
	
	/**
	 * Getter des Gelesen - States
	 * @return
	 */
	public boolean isGelesen() {
		return gelesen;
	}
	
	/**
	 * Setter des Gelesen - States
	 * @param gelesen
	 */
	public void setGelesen(boolean gelesen) {
		this.gelesen = gelesen;
	}
	
	/**
	 * Getter des Senders
	 * @return
	 */
	public String getSender() {
		return Sender.getNickname();
	}
	
	/**
	 * Getter des Empfaengers
	 * @return
	 */
	public String getEmpfaenger() {
		return Empfaenger.getNickname();
	}

}
