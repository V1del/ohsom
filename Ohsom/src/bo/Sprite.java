package bo;

import java.awt.Graphics;
import java.awt.Image;

/**
 * Class to load images/objects to be used in the context of a rendering canvas
 *
 * @author darot
 *
 */
public class Sprite {

	private Image image;

	public Sprite(Image image) {
		this.image = image;
	}

	public int getWidth() {
		return image.getWidth(null);
	}

	public int getHeight() {
		return image.getHeight(null);
	}

	public void draw(Graphics g, double x, double y) {
		g.drawImage(image, (int) x, (int) y, null);
	}


}