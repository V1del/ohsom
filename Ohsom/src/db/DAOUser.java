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

	public boolean addConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException;
	
	public  boolean addHighscore(Highscore Highscore) throws SQLException;
	
	public boolean addUser(User User) throws SQLException;
	
		
	public boolean deleteConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException;
	
	public boolean deleteUser(User User) throws SQLException;
	
	public ArrayList<Highscore> getAllHighscores() throws SQLException;
	
	public ArrayList<TamagotchiConfig> getConfigData(int idUser) throws SQLException;
	
	public boolean updateHighscore(Highscore Highscore) throws SQLException;
	
	public boolean updateUser(User User) throws SQLException;
	
	public boolean updateConfigData(TamagotchiConfig TamagotchiConfig) throws SQLException;
	
	public ArrayList<User> getAllUsers() throws SQLException;
	
}
