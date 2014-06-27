package bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasse für ein Invadergame
 * @author Snatsch
 *
 */


public class InvaderGameThread implements Runnable {

	@Override
	public void run() {
		try {
			final InvaderGame g = new InvaderGame();

			g.gameLoop();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
