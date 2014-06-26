package bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import db.DAOUserImpl;

/**
 * Nachricht - Klasse
 * @author vmuser
 */
public class Nachricht 
{
	private int idNachricht;
	private String Titel;
	private String Nachricht;
	private Date Zeitpunkt;
	private boolean gelesen;
	private int idSender;
	private int idEmpfaenger;

	/**
	 * Dieser Konstruktor wird verwendet wenn die Nachricht bereits in der Datenbank ist
	 * @param titel
	 * @param nachricht
	 * @param zeitpunkt
	 * @param gelesen
	 * @param sender
	 * @param empfaenger
	 * @throws SQLException 
	 */
	public Nachricht(ResultSet NachrichtResultSet) throws SQLException {
		super();
		idNachricht = NachrichtResultSet.getInt("idNachricht");
		Titel = NachrichtResultSet.getString("Titel");
		Nachricht = NachrichtResultSet.getString("Nachricht");
		Zeitpunkt = NachrichtResultSet.getDate("Zeitpunkt");
		this.gelesen = NachrichtResultSet.getBoolean("gelesen");
		idSender = NachrichtResultSet.getInt("idUser_Sender");
		idEmpfaenger = NachrichtResultSet.getInt("idUser_Empfaenger");
	}
	
	
	/**
	 * Der Konstruktor, der notwendig ist, wenn die Nachricht erst noch erstellt wird (Datum muss bei diesem Schritt generiert werden)
	 * Auch muss der Status gelesen direkt auf false gesetzt werden.
	 * @param titel
	 * @param nachricht
	 * @param empfaenger
	 * @param sender
	 */
	public Nachricht(String titel, String nachricht, int idEmpfaenger, int idSender)
	{
		super();
		Titel = titel;
		Nachricht = nachricht;
		Zeitpunkt = new Date();
		gelesen = false;
		this.idEmpfaenger = idEmpfaenger;
		this.idSender = idSender;
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
	
	public int getId()
	{
		return idNachricht;
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
	 * Getter des Senders
	 * @return
	 * @throws SQLException 
	 */
	public User getSender() throws SQLException {
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getUser(idSender);
	}
	
	/**
	 * Getter des Empfaengers
	 * @return
	 * @throws SQLException 
	 */
	public User getEmpfaenger() throws SQLException {
		DAOUserImpl DAOU = new DAOUserImpl();
		return DAOU.getUser(idEmpfaenger);
	}

}
