package bo;

/**
 * Klasse für ein Invadergame
 * @author Snatsch
 *
 */


public class InvaderGameThread implements Runnable {

	@Override
	public void run() {
		InvaderGame g = new InvaderGame();
		g.gameLoop();
		
	}

}
