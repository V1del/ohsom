package bl;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.*;
import db.*;

public class BLUser {

	private DAOUserImpl DAOU = new DAOUserImpl();
	private User currentUser = null;
	
	public boolean isUserDataValid(String Nickname, String Passwort) throws SQLException
	{
		User currentUser = DAOU.getUser(Nickname, Passwort); 
	
		setCurrentUser(currentUser);
		return !(currentUser == null);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public boolean createUser(User newUser)
	{
		return DAOU.addUser(newUser);		
	}
	
	public ArrayList<Highscore> getAllHighscores()
	{
		return DAOU.getAllHighscores();
	}
	
}
