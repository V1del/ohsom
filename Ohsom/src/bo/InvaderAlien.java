package bo;

public class InvaderAlien extends InvaderObject {
	
	private InvaderGame game;

	public InvaderAlien( InvaderGame game ,String fileLoc, int x, int y) {
		super(fileLoc, x, y);

		this.game = game;
		
		speedX = -75;
	}

	@Override
	public void move(long passedTime) {

		if(x < 10 && speedX < 0) {
			game.updateDirection();
		}
		
		else if(x > 750 && speedX > 0)
			game.updateDirection();
		
		super.move(passedTime);
	}
	@Override
	public void confirmCollision(InvaderObject other) {
		// Doing that in Shot-Class
		
	}

	@Override
	public void switchDirection() {
		speedX = -speedX;
		y += 10;
		
		if (y > 750) {
			game.lost();
		}
		
	}
	
	

}
