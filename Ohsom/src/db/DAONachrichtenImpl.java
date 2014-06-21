package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bo.Highscore;
import bo.Nachricht;

public class DAONachrichtenImpl implements DAONachrichten{

	OhsomDBDAOImpl DBDAO = new OhsomDBDAOImpl();
	
	public boolean addNachricht(Nachricht n) throws SQLException {
		boolean isInsertingSuccessfull = false;

		PreparedStatement Nachrichtpstmt = null;
		String NachrichtSQL = "INSERT INTO nachrichten(titel, nachricht, zeitpunkt, userid_empfaenger, userid_sender) VALUES (?, ?, SYSDATE(), ?, ?)";

		Nachrichtpstmt = DBDAO.getConnection().prepareStatement(NachrichtSQL);
		Nachrichtpstmt.setString(1, n.getTitel());
		Nachrichtpstmt.setString(2, n.getNachricht());
		Nachrichtpstmt.setInt(3, n.getEmpfaenger());
		Nachrichtpstmt.setInt(4, n.getSender());
		
		isInsertingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(Nachrichtpstmt);

		return isInsertingSuccessfull;
	}

	public boolean changeNachricht(Nachricht n) throws SQLException {
		boolean isChangingSuccessfull = false;

		PreparedStatement NachrichtUpdatepstmt = null;
		String NachrichtUpdateSQL = "UPDATE nachrichten SET GELESEN = 'Y' WHERE IDNACHRICHT = ?	";

		NachrichtUpdatepstmt = DBDAO.getConnection().prepareStatement(NachrichtUpdateSQL);
		NachrichtUpdatepstmt.setInt(1, n.getId());
		
		isChangingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(NachrichtUpdatepstmt);

		return isChangingSuccessfull;
	}

	public boolean deleteNachricht(Nachricht n) throws SQLException {
		boolean isDeletingSuccessfull = false;

		PreparedStatement NachrichtDeletepstmt = null;
		String NachrichtUpdateSQL = "DELETE FROM nachrichten WHERE IDNACHRICHT = ?	";

		NachrichtDeletepstmt = DBDAO.getConnection().prepareStatement(NachrichtUpdateSQL);
		NachrichtDeletepstmt.setInt(1, n.getId());
		
		isDeletingSuccessfull = DBDAO.SuccessfullInsertingChangingDeleting(NachrichtDeletepstmt);

		return isDeletingSuccessfull;
	}

	public ArrayList<Nachricht> getNachrichten(int idUser) throws SQLException{
		ArrayList<Nachricht> NachrichtenList = new ArrayList<Nachricht>();
		PreparedStatement NachrichtPstmt = null;
		String NachrichtSQL = "SELECT * FROM nachrichten ORDER BY ZEITPUNKT DESC";

		NachrichtPstmt = DBDAO.getConnection().prepareStatement(NachrichtSQL);

		ResultSet NachrichtResultSet = DBDAO.SelectStatement(NachrichtPstmt);

		while(NachrichtResultSet.next())
		{
			Nachricht NachrichtObject = new Nachricht(NachrichtResultSet);
			NachrichtenList.add(NachrichtObject);
		}

		return NachrichtenList;
	}

}
