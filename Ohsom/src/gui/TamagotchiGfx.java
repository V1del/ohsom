package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import bo.InvaderObject;
import bo.TamagotchiObj;

public class TamagotchiGfx extends JPanel {
	
	private TamagotchiObj tamagotchi;
	//private ArrayList<InvaderObject> tamagotchiobjs = new ArrayList<InvaderObject>();
	private BufferedImage img = null;
	

	public TamagotchiGfx() {

		initTamagotchiObjects();
		
		
		
		
	}
	
	private void initTamagotchiObjects() {
		//tamagotchi = new TamagotchiObj(this, "gfx/Tamagotchi.jpg", 0, 0);
		//tamagotchiobjs.add(tamagotchi);
		try {
			img = new ImageIO.read(new File("gfx/Tamagotchi.jpg"));
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, 0, 0, null);
		
		//tamagotchi.draw((Graphics2D) g);
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
