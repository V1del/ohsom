package bo;

public class InvaderGameThread implements Runnable {

	@Override
	public void run() {
		InvaderGame g = new InvaderGame();
		g.gameLoop();
		
	}

}
