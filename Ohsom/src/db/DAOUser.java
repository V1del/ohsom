package db;

import java.util.ArrayList;

import bo.*;

/**
 * Interface DAOUser
 * @author vmuser
 *
 */
public interface DAOUser {

	public boolean addConfigData(TamagotchiConfig TamagotchiConfig);
	
	public  boolean addHighscore(Highscore Highscore);
	
	public boolean addUser(User User);
	
	public boolean changeConfigData(TamagotchiConfig TamagotchiConfig);
	
	public boolean changeUser(User User);
	
	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig);
	
	public boolean deleteUser(User User);
	
	public ArrayList<Highscore> getAllHighscores();
	
	public ArrayList<TamagotchiConfig> getConfigData(int idUser);
	
	public ArrayList<User> getAllUsers();
	
	public boolean updateHighscore(Highscore Highscore);
	
	public boolean updateUser(User User);
	
	public boolean updateConfig(TamagotchiConfig TamagotchiConfig);
	
}
