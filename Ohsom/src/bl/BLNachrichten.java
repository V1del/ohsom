package bl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import db.DAONachrichtenImpl;
import db.DAOUserImpl;
import bo.Highscore;
import bo.Nachricht;
import bo.User;

/**
 * Businlesslogik fÃ¼r die Nachrichten
 * @author Snatsch
 *
 */
public class BLNachrichten {

	private DAONachrichtenImpl DAON = new DAONachrichtenImpl();
	private DAOUserImpl DAOU = new DAOUserImpl();
	private User currentUser = Login.getInstance().getUserInstance();
	
	/**
	 * Standardkonstruktor
	 */
	public BLNachrichten()
	{
	}
	
	/**
	 * Getter fÃ¼r die Nachrichten eines Users
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Nachricht> getNachrichten() throws SQLException
	{
		return DAON.getNachrichten(currentUser.getId());
	}
	
	/**
	 * Getter Nachrichten eines Users in Tabellenformat
	 * @return
	 * @throws SQLException
	 */
	public Object[][] getNachrichtenData() throws SQLException
	{
		ArrayList<Nachricht> NachrichtenList = getNachrichten();
		Object[][] ObjectList = new String[NachrichtenList.size()][5];
		
		int i = 0;
		for(Nachricht n : NachrichtenList)
		{
			ObjectList[i][0] = String.valueOf(n.getId());
			ObjectList[i][1] = n.getSender().getNickname();
			ObjectList[i][2] = String.valueOf((n.isGelesen()) ? "ja" : "nein"); //new JCheckBox("", n.isGelesen());
			ObjectList[i][3] = n.getTitel();
			ObjectList[i][4] = String.valueOf(n.getZeitpunkt());
			i++;
		};
		
		return ObjectList;
	}
	
	/**
	 * Ungelesene Nachrichten zÃ¤hlen
	 * @return Anzahl ungelesene Nachrichten
	 * @throws SQLException
	 */
	public int getCountOfUnreadNachrichten() throws SQLException
	{
		ArrayList<Nachricht> unreadMessages = new ArrayList<Nachricht>();
		
		for(Nachricht Nachricht : getNachrichten())
		{
			if(!Nachricht.isGelesen())
			{
				unreadMessages.add(Nachricht);
			}
		}
		
		return unreadMessages.size();
	}
	
	/**
	 * Get Anzahl aller Nachrichten
	 * @return Anzahl alle Nachrichten
	 * @throws SQLException
	 */
	public int getCountOfAllNachrichten() throws SQLException
	{
		ArrayList<Nachricht> Messages = new ArrayList<Nachricht>();
		
		for(Nachricht Nachricht : getNachrichten())
		{
			Messages.add(Nachricht);
		}
		
		return Messages.size();
	}
	
	/**
	 * Methode zur Versendung von Nachrichten (Insert in der Datenbank)
	 * @param Nachricht
	 * @return Konnte die Nachricht erfolgreich versendet werden?
	 * @throws SQLException
	 */
	public boolean sendNachricht(Nachricht Nachricht) throws SQLException
	{
		return DAON.addNachricht(Nachricht);
	}
	
	/**
	 * Methode zur Veränderung von Nachrichten (Update in der Datenbank)
	 * @param Nachricht
	 * @return Konnte die Nachricht erfolgreich verändert werden?
	 * @throws SQLException
	 */
	public boolean changeNachricht(Nachricht Nachricht) throws SQLException
	{
		return DAON.changeNachricht(Nachricht);
	}
	
	/**
	 * Methode zur Löschung von Nachrichten (Delete in der Datenbank)
	 * @param Nachricht
	 * @return Konnte die Nachricht erfolgreich gelöscht werden?
	 * @throws SQLException
	 */
	public boolean deleteNachricht(Nachricht Nachricht) throws SQLException
	{
		return DAON.deleteNachricht(Nachricht);
	}
	
	/**
	 * Getter Nachricht nach Index
	 * @param idNachricht
	 * @return Nachricht
	 * @throws SQLException
	 */
	public Nachricht getNachricht(int idNachricht) throws SQLException
	{
		return DAON.getNachricht(idNachricht);
	}

	/**
	 * Getter das aktuellen Users
	 * @return
	 */
	public User getCurrentUser() {
		return currentUser;
	}
	
}
