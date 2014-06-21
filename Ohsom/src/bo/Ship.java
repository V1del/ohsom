package bo;

public class Ship extends InvaderObject {

	private InvaderGame game;

	public Ship(InvaderGame game, String fileLoc, int x, int y) {
		super(fileLoc, x, y);

		this.game = game;
	}

	@Override
	public void move(long passedTime) {

		if((speedX < 0) && (x < 10)) {
			return;
		}

		if((speedX > 0) && (x > 750)) {
			return;
		}

		super.move(passedTime);
	}

	@Override
	public void confirmCollision(InvaderObject other) {
		if (other instanceof InvaderAlien) {
			game.lost();
		}

	}

}