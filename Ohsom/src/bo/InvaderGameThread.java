package bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Thread für Invader Game
 * @author videl
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
