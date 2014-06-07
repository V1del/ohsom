package db;

import java.util.ArrayList;

import bo.*;

public interface DAOTamagotchi {

	public boolean addTamagotchi(Tamagotchi Tamagotchi);
	
	public boolean addItem(Item Item);
	
	public boolean changeTamagotchi(Tamagotchi Tamagotchi);
	
	public boolean deleteTamagotchi(Tamagotchi Tamagotchi);
	
	public ArrayList<Item> getInventar(int idTamagotchi);
	
	public Tamagotchi getTamagotchi(int idUser);
	
	public ArrayList<Tamagotchi> getTamagotchis();
	
	
	
}
