package ohsomTest;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.DAOUserImpl;
import bo.User;

/**
 * OhsomTest ist eine JUnit - Testklasse, die dazu dient, die Userfunktionen zu testen
 * @author Snatsch
 *
 */
public class OhsomTest {

	private DAOUserImpl TestDAOU = null;
	private User TestUser = null;
	
	@Before
	public void beforeTest()
	{
		TestDAOU = new DAOUserImpl();
		TestUser = new User("TestUser", "leichtesPasswort", "test@email.ch");
	}
	
	@Test
	public void test() throws SQLException {
	// kann der User eingetragen werden
		assertTrue(TestDAOU.addUser(TestUser));
	}
	
	@After
	public void afterTest()
	{
		TestDAOU = null;
		TestUser = null;
	}

}
