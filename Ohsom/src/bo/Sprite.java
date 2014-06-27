package bo;

import java.awt.Graphics;
import java.awt.Image;

/**
 * Klasse um Bilder fürs Zeichnen auf den Canvas zu erstellen
 *
 * @author darot
 *
 */
public class Sprite {

	private Image image;

	/**
	 * Konstruktor
	 * @param image
	 */
	public Sprite(Image image) {
		this.image = image;
	}

	/**
	 * Getter Width
	 * @return Width
	 */
	public int getWidth() {
		return image.getWidth(null);
	}

	/**
	 * Getter Height
	 * @return Height
	 */
	public int getHeight() {
		return image.getHeight(null);
	}

	/**
	 * Zeichnen des Bilds
	 * @param g
	 * @param x
	 * @param y
	 */
	public void draw(Graphics g, double x, double y) {
		g.drawImage(image, (int) x, (int) y, null);
	}


}