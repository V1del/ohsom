package bo;

import java.awt.Graphics2D;

/**
 * Abstract Class handling movement and collision detection for all hitable objects
 * @author videl
 *
 */
public abstract class InvaderObject {

	protected int x;
	protected int y;
	protected Sprite sprite;
	private long speedX;
	private long speedY;
	

	public void move(long passedTime) {
		x += (passedTime * speedX) / 1000;
		y += (passedTime * speedY) / 1000;
		
	}

	public void draw(Graphics2D g) {
		sprite.draw(g, x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public long getSpeedX() {
		return speedX;
	}

	public void setSpeedX(long speedX) {
		this.speedX = speedX;
	}

	public long getSpeedY() {
		return speedY;
	}

	public void setSpeedY(long speedY) {
		this.speedY = speedY;
	}
	
	public abstract void confirmCollision();

}
