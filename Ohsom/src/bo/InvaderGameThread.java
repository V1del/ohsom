package bo;

/**
 * Klasse f�r ein Invadergame
 * @author Snatsch
 *
 */
public class InvaderGameThread extends Thread implements Runnable {

/**
 * Thread starten
 */
@Override
public void run() {
InvaderGame g = new InvaderGame();
g.gameLoop();

}

}