package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import bo.Highscore;
import bo.Item;
import bo.Tamagotchi;
import bo.User;

public class DAOTamagotchiImpl implements DAOTamagotchi{

	private OhsomDBDAOImpl DBDAO = OhsomDBDAOImpl.getInstance();
	
	public boolean setToActualDate(Tamagotchi Tamagotchi, String Eigenschaft) throws SQLException
	{
		PreparedStatement TamagotchiTimepstmt = null;
		String TamagotchiTimeSQL = "UPDATE tamagotchi SET " + Eigenschaft + " = sysdate() WHERE idUser = ?";
				
		TamagotchiTimepstmt = DBDAO.getConnection().prepareStatement(TamagotchiTimeSQL);
		
		TamagotchiTimepstmt.setInt(1, Tamagotchi.getUserId());
		
		return DBDAO.SuccessfullInsertingChangingDeleting(TamagotchiTimepstmt);
	}
	/**
	 * Function to insert a Tamagotchi into the DB
	 */
	public boolean addTamagotchi(Tamagotchi Tamagotchi) throws SQLException {
		boolean isInsertingSuccessfull = false;

		PreparedStatement TamagotchiInsertpstmt = null;
		String TamagotchiInsertSQL = "INSERT INTO tamagotchi (Name, Geschlechtw, " 
				+ "Geburtsdatum, Geld, Medizin, Gesundheitszustand, letzteFuetterungszeit, "
				+ "letzteSchlafenszeit, letzteWaschzeit, letzteSpielzeit, letzteTrinkzeit, "
				+ "idUser) "
				+ "VALUES (?, ?, ?, ?, ?, ?, sysdate(), sysdate(), sysdate(), sysdate(), sysdate(), ?)";

		TamagotchiInsertpstmt = DBDAO.getConnection().prepareStatement(TamagotchiInsertSQL);
		TamagotchiInsertpstmt.setString(1, Tamagotchi.getName());
		TamagotchiInsertpstmt.setBoolean(2, (Tamagotchi.getGeschlecht().equals("männlich"))?false:true);
		TamagotchiInsertpstmt.setDate(3, Tamagotchi.getGeburtsdatum());
		TamagotchiInsertpstmt.setInt(4, Tamagotchi.getGeld());
		TamagotchiInsertpstmt.setInt(5, Tamagotchi.getMedizin());
		TamagotchiInsertpstmt.setString(6, Tamagotchi.getGesundheitszustand().name());
		TamagotchiInsertpstmt.setInt(7, Tamagotchi.getUserId());
		
		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(TamagotchiInsertpstmt);

		return isInsertingSuccessfull;
	}

	/**
	 * Function to update the Tamagotchi 
	 * @throws SQLException 
	 */
	public boolean changeTamagotchi(Tamagotchi Tamagotchi) throws SQLException {
		boolean isChangingSuccessfull = false;
		PreparedStatement TamagotchiUpdatepstmt = null;
		String TamagotchiUpdateSQL = "UPDATE tamagotchi SET NAME = ?, GESCHLECHTW = ?, GEBURTSDATUM = ?, "
				+ "MEDIZIN = ?, GELD = ?, "
				+ "GESUNDHEITSZUSTAND = ? "
				+ "WHERE IDUSER= ?";
		TamagotchiUpdatepstmt = DBDAO.getConnection().prepareStatement(TamagotchiUpdateSQL);
		
		TamagotchiUpdatepstmt.setString(1, Tamagotchi.getName());
		TamagotchiUpdatepstmt.setBoolean(2, Tamagotchi.isGeschlechtw());
		TamagotchiUpdatepstmt.setDate(3, Tamagotchi.getGeburtsdatum());
		TamagotchiUpdatepstmt.setInt(4, Tamagotchi.getMedizin());
		TamagotchiUpdatepstmt.setInt(5, Tamagotchi.getGeld());
		TamagotchiUpdatepstmt.setString(6, Tamagotchi.getGesundheitszustand().name());
		TamagotchiUpdatepstmt.setInt(7, Tamagotchi.getUserId());
		
		isChangingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(TamagotchiUpdatepstmt);

		return isChangingSuccessfull;
	}

	/**
	 * Function to delete the Tamagotchi of a specific person
	 */
	public boolean deleteTamagotchi(Tamagotchi Tamagotchi) throws SQLException{
		boolean isDeletingSuccessfull = false;
		
		PreparedStatement TamagotchiDeletepstmt = null;
		String TamagotchiDeleteSQL = "DELETE FROM tamagotchi WHERE IDTAMAGOTCHI = ?";
		
		TamagotchiDeletepstmt = DBDAO.getConnection().prepareStatement(TamagotchiDeleteSQL);
		TamagotchiDeletepstmt.setInt(1, Tamagotchi.getId());
		
		isDeletingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(TamagotchiDeletepstmt);
		
		return isDeletingSuccessfull;
	}

	/** 
	 * Adding Item into the Database
	 */
	public boolean addItem(Item Item) throws SQLException {
		boolean isInsertingSuccessfull = false;

		PreparedStatement InventarInsertpstmt = null;
		String InventarInsertSQL = "INSERT INTO inventar (IDSHOP, IDTAMAGOTCHI, KAUFDATUM, VERWENDET) VALUES (?, ?, SYSDATE(), 0)";

		InventarInsertpstmt = DBDAO.getConnection().prepareStatement(InventarInsertSQL);
		InventarInsertpstmt.setInt(1, Item.getShopartikel().getId());
		InventarInsertpstmt.setInt(2, Item.getIdTamagotchi());
		
		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(InventarInsertpstmt);
				
		return isInsertingSuccessfull;
	}

	/**
	 * Changing the Item
	 * @param Item
	 * @return
	 * @throws SQLException 
	 */
	public boolean changeItem(Item Item) throws SQLException
	{
		boolean isChangingSuccessfull = false;
		
		PreparedStatement ItemUpdatepstmt = null;
		String ItemUpdateSQL = "UPDATE inventar SET VERWENDET = 1 WHERE IDTAMAGOTCHI = ? AND IDSHOP = ? AND KAUFDATUM = ?";
		ItemUpdatepstmt = DBDAO.getConnection().prepareStatement(ItemUpdateSQL);
		ItemUpdatepstmt.setInt(1, Item.getIdTamagotchi());
		System.out.println(Item.getIdTamagotchi());
		ItemUpdatepstmt.setInt(2, Item.getShopartikel().getId());
		System.out.println(Item.getShopartikel().getId());
		ItemUpdatepstmt.setTimestamp(3, Item.getKaufdatum());
		System.out.println(Item.getKaufdatum());
		
		isChangingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(ItemUpdatepstmt);
		
		return isChangingSuccessfull;
	}

	/**
	 * Function to get te Inventar of one specific Tamagotchi
	 * @throws SQLException 
	 */
	public ArrayList<Item> getInventar(int idTamagotchi) throws SQLException {
		ArrayList<Item> ItemList = new ArrayList<Item>();
		PreparedStatement InventarPstmt = null;
		String InventarSQL = "SELECT * FROM inventar WHERE IDTAMAGOTCHI = ?";

		InventarPstmt = DBDAO.getConnection().prepareStatement(InventarSQL);
		InventarPstmt.setInt(1, idTamagotchi);
		
		ResultSet InventarResultSet = DBDAO.SelectStatement(InventarPstmt);

		while(InventarResultSet.next())
		{
			Item InventarObject = new Item(InventarResultSet);
			ItemList.add(InventarObject);
		}

		return ItemList;
	}

	/**
	 * Function to Get the Tamagotchi of one specific user
	 * @throws SQLException 
	 */
	public Tamagotchi getTamagotchi(int idUser) throws SQLException 
	{
		PreparedStatement Tamagotchipstmt = null;
		String TamagotchiSQL = "SELECT * FROM tamagotchi WHERE idUser = ?";
		Tamagotchi TamagotchiObject = null;

		Tamagotchipstmt = DBDAO.getConnection().prepareStatement(TamagotchiSQL);
		Tamagotchipstmt.setInt(1, idUser);

		ResultSet TamagotchiResultSet = DBDAO.SelectStatement(Tamagotchipstmt);
		if(TamagotchiResultSet.next())
		{
			TamagotchiObject = new Tamagotchi(TamagotchiResultSet);
		}


		return TamagotchiObject;
	}

}
