package bo;

import java.sql.SQLException;

/**
 * Schiffklasse aus InvaderGame
 * @author Snatsch
 *
 */
public class Ship extends InvaderObject {

	private InvaderGame game;

	/**
	 * Konstruktor Schiff
	 * @param game
	 * @param fileLoc
	 * @param x
	 * @param y
	 */
	public Ship(InvaderGame game, String fileLoc, int x, int y) {
		super(fileLoc, x, y);

		this.game = game;
	}

	/**
	 * Bewegen des Schiffs auf dem GUI
	 */
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

	/**
	 * Kollission Schiff mit InvaderObject
	 */
	@Override
	public void confirmCollision(InvaderObject other) throws SQLException {
		if (other instanceof InvaderAlien) {
			game.lost();
		}

	}

}