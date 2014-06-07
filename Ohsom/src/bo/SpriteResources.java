package bo;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class SpriteResources {
	private static SpriteResources resources = new SpriteResources();
	
	private HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();
	
	public static SpriteResources get() {
		return resources;
	}
	
	public Sprite getSprite(String fileLoc) {
		
		if(sprites.get(fileLoc) != null)
			return (Sprite) sprites.get(fileLoc);
		
		BufferedImage img = null;
		
		File f = new File(fileLoc);
		
		if(!f.exists()) {
			System.err.println("File \"" + fileLoc + "\" not found, please give a valid File");
			System.exit(0);
		}
		
		try {
			
			img = ImageIO.read(f);
			
		} catch (IOException e) {
			System.err.println("Couldn't load File \"" + fileLoc + "\"");
			System.exit(0);
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image image = gc.createCompatibleImage(img.getWidth(), img.getHeight(),Transparency.BITMASK);
		
		image.getGraphics().drawImage(img, 0, 0, null);
		
		Sprite sprite = new Sprite(image);
		sprites.put(fileLoc, sprite);
		
		return sprite;
		
		
	}

}
