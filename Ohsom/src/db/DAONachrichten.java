package db;

import java.util.ArrayList;
import bo.*;

public interface DAONachrichten {

	public boolean addNachricht(Nachricht n);
	
	public boolean changeNachricht(Nachricht n);
	
	public boolean deleteNachricht(Nachricht n);
	
	public ArrayList<Nachricht> getNachrichten(int idUser);
}
