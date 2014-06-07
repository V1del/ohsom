package bo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Abstract Class handling movement and collision detection for all hitable objects
 * @author videl
 *
 */
public abstract class InvaderObject {

	protected double x;			
	protected double y;
	protected Sprite sprite;
	protected double speedX;	//Need to be double for proper speed increase in aliens, we loose floating point precision otherwise  which can lead to all sorts
	protected double speedY;	//of weird stuff happening (aliens accelerating way to fast or suddenly slowing to a crawl
	Rectangle obj1 = new Rectangle();
	Rectangle obj2 = new Rectangle();
	
	public InvaderObject(String fileLoc, int x, int y) {
		this.sprite = SpriteResources.get().getSprite(fileLoc);
		
		this.x = x;
		this.y = y;
		
	}

	public void move(long passedTime) {
		x += (passedTime * speedX) / 1000;
		y += (passedTime * speedY) / 1000;
		
	}

	public void draw(Graphics2D g) {
		sprite.draw(g, x, y);
	}

	public int getX() {
		return (int) x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return (int) y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	
	public boolean checkCollision(InvaderObject other) {
		obj1.setBounds((int) x,(int) y, sprite.getWidth(), sprite.getHeight());
		obj2.setBounds((int) other.x, (int) other.y, other.sprite.getWidth(), other.sprite.getHeight());
		
		return obj1.intersects(obj2);
	}
	
	public abstract void confirmCollision(InvaderObject other);
	
	/**
	 * Only relevant for Alien movement, but defining here because we're going to use this as base class for our list
	 */
	public void switchDirection() {
	}

}
