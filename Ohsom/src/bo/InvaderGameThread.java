package bo;

/**
 * Klasse f�r ein Invadergame
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
