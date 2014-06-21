package db;

import java.sql.ResultSet;

public interface OhsomDBDAO {

	public ResultSet SelectStatement(String SelectStatement);
	
	public boolean SuccessfullInsertingChangingDeleting(String Statement);
	
}
