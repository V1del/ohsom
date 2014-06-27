package bo;

import java.sql.SQLException;

/**
 * Schüsse beim InvaderGame
 * @author Snatsch
 *
 */
public class Shot extends InvaderObject {

	private InvaderGame game;

	/**
	 * Konstruktor
	 * @param game
	 * @param fileLoc
	 * @param x
	 * @param y
	 */
	public Shot(InvaderGame game, String fileLoc, int x, int y) {
		super(fileLoc, x, y);

		this.game = game;

		speedY = -300; //Vertical movement
	}

	/**
	 * Bewegen auf dem GUI
	 */
	@Override
	public void move(long passedTime) {
		super.move(passedTime);

		if (y < -50)
		{
			game.removeObject(this);
		}
	}

	/**
	 * Collision mit Invaderobjekt
	 */
	@Override
	public void confirmCollision(InvaderObject other) throws SQLException {

		try {
			game.removeObject(this);

			game.removeObject(other);

			game.AlienKilled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}