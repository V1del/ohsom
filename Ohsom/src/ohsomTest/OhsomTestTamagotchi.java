package ohsomTest;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.DAOTamagotchiImpl;
import db.DAOUserImpl;
import bl.BLTamagotchi;
import bo.Tamagotchi;
import bo.User;

/**
 * OhsomTest ist eine JUnit - Testklasse, die dazu dient, die Tamagotchifunktionen zu testen
 * @author Snatsch
 *
 */
public class OhsomTestTamagotchi {

	private BLTamagotchi blT = null;
	private DAOTamagotchiImpl TestDAOT = null;
	private DAOUserImpl TestDAOU = null;
	
	private User TestUser = null;
	private Tamagotchi TestTamagotchi = null;
	
	/**
	 * Wir instanziieren unsere Objekte und holen unsere Testobjekte, die wir für den Test brauchen
	 * @throws SQLException
	 */
	@Before
	public void beforeTest() throws SQLException
	{
		blT = new BLTamagotchi();
		TestDAOT = new DAOTamagotchiImpl();
		TestDAOU = new DAOUserImpl();
		
		// Wir holen unseren erstellten Testuser
		TestUser = TestDAOU.getUser("OhsomTestUnitUser", true); // der beim OhsomTest erstellte User wird erfragt
		
		// Wir erstellen ein neues Tamagotchi für unseren Testuser
		TestTamagotchi = new Tamagotchi("OhsomTestUnitTamagotchi", TestUser);
		TestDAOT.addTamagotchi(TestTamagotchi);
	}
	
	/**
	 * Wir testen unsere BLTamagotchi (kann Tamagotchi schlafengelegt werden? sollte nicht möglich sein, da wir es neu erstellt haben)
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
	// Der User 
		assertTrue(blT.layTamagotchiToSleep() == false);
	}
	
	/**
	 * Wir dereferenzieren unsere Objekte
	 * @throws SQLException
	 */
	@After
	public void afterTest()
	{
		TestDAOT = null;
		TestTamagotchi = null;
	}

}
