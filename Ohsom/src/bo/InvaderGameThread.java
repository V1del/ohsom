package bo;

import java.sql.SQLException;

/**
 * Klasse für ein Invadergame
 * @author Snatsch
 *
 */


public class InvaderGameThread implements Runnable {

	@Override
	public void run() {
		InvaderGame g = new InvaderGame();
		try {
			g.gameLoop();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
