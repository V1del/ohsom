package bo;

public class Shot extends InvaderObject {

	private InvaderGame game;

	public Shot(InvaderGame game, String fileLoc, int x, int y) {
		super(fileLoc, x, y);

		this.game = game;

		speedY = -300; //Vertical movement
	}

	@Override
	public void move(long passedTime) {
		super.move(passedTime);

		if (y < -50)
		{
			game.removeObject(this);
		}
	}

	@Override
	public void confirmCollision(InvaderObject other) {

		game.removeObject(this);
		game.removeObject(other);

		game.AlienKilled();





	}

}