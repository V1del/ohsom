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
 * Businlesslogik für die Nachrichten
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
	 * Getter für die Nachrichten eines Users
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Nachricht> getNachrichten() throws SQLException
	{
		return DAON.getNachrichten(currentUser.getId());
	}
	
	public Object[][] getNachrichtenData() throws SQLException
	{
		ArrayList<Nachricht> NachrichtenList = getNachrichten();
		Object[][] ObjectList = new String[NachrichtenList.size()][6];
		
		int i = 0;
		for(Nachricht n : NachrichtenList)
		{
			ObjectList[i][0] = DAOU.getUser(n.getSender()).getNickname();
			ObjectList[i][1] = String.valueOf(n.isGelesen()); //new JCheckBox("", n.isGelesen());
			ObjectList[i][2] = n.getTitel();
			ObjectList[i][3] = String.valueOf(n.getZeitpunkt());
			ObjectList[i][4] = "lesen"; //new JButton("Test");
			ObjectList[i][5] = "löschen"; //new JButton("Test 2");
			i++;
		};
		
		return ObjectList;
	}
	
	/**
	 * Ungelesene Nachrichten zählen
	 * @return
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
	 * Methode zur Versendung von Nachrichten (Insert in der Datenbank)
	 * @param Nachricht
	 * @return
	 * @throws SQLException
	 */
	public boolean sendNachricht(Nachricht Nachricht) throws SQLException
	{
		return DAON.addNachricht(Nachricht);
	}
	
	/**
	 * Methode zur Löschung von Nachrichten (Delete in der Datenbank)
	 * @param Nachricht
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteNachricht(Nachricht Nachricht) throws SQLException
	{
		return DAON.deleteNachricht(Nachricht);
	}

	/**
	 * Getter das aktuellen Users
	 * @return
	 */
	public User getCurrentUser() {
		return currentUser;
	}
	
}
