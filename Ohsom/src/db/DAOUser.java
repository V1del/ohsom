package db;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.*;

/**
 * Interface DAOUser
 * @author vmuser
 *
 */
public interface DAOUser {

	public boolean addConfigData(TamagotchiConfig TamagotchiConfig);
	
	public  boolean addHighscore(Highscore Highscore) throws SQLException;
	
	public boolean addUser(User User) throws SQLException;
	
	public boolean changeConfigData(TamagotchiConfig TamagotchiConfig);
		
	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig);
	
	public boolean deleteUser(User User) throws SQLException;
	
	public ArrayList<Highscore> getAllHighscores();
	
	public ArrayList<TamagotchiConfig> getConfigData(int idUser);
	
	public ArrayList<User> getAllUsers();
	
	public boolean updateHighscore(Highscore Highscore);
	
	public boolean updateUser(User User);
	
	public boolean updateConfig(TamagotchiConfig TamagotchiConfig);
	
}
