package db;

import java.sql.SQLException;
import java.util.ArrayList;

import bo.*;

public interface DAONachrichten {

	public boolean addNachricht(Nachricht n) throws SQLException;
	
	public boolean changeNachricht(Nachricht n) throws SQLException;
	
	public boolean deleteNachricht(Nachricht n) throws SQLException;
	
	public ArrayList<Nachricht> getNachrichten(int idUser) throws SQLException;
	
	public Nachricht getNachricht(int idNachricht) throws SQLException;
}
