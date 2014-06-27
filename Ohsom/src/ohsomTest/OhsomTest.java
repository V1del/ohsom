package ohsomTest;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.DAOUserImpl;
import bl.BLUser;
import bo.User;

/**
 * OhsomTest ist eine JUnit - Testklasse, die dazu dient, die Userfunktionen zu testen
 * @author Snatsch
 *
 */
public class OhsomTest {

	private BLUser blU = null;
	private User TestUser = null;
	
	@Before
	public void beforeTest()
	{
		blU = new BLUser();
		TestUser = new User("OhsomTestUnitUser", "leichtesPasswort", "testNeu@email.ch"); // Dieser User wird neu angelegt
	}
	
	@Test
	public void test() throws SQLException {
	// kann der User eingetragen werden
		assertTrue((blU.isUserDataValid(TestUser.getNickname(), TestUser.getPasswort())));
	}
	
	@After
	public void afterTest()
	{
		blU = null;
		TestUser = null;
	}

}
