package db;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.*;

public interface DAOTamagotchi {

	public boolean addTamagotchi(Tamagotchi Tamagotchi) throws SQLException;
	
	public boolean addItem(Item Item) throws SQLException;
	
	public boolean changeTamagotchi(Tamagotchi Tamagotchi) throws SQLException;
	
	public boolean deleteTamagotchi(Tamagotchi Tamagotchi) throws SQLException;
	
	public ArrayList<Item> getInventar(int idTamagotchi) throws SQLException;
	
	public Tamagotchi getTamagotchi(int idUser) throws SQLException;
	
	
}
