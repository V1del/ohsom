package gui;

import java.awt.Dimension;
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

	private TamagotchiObj tamagotchibg, tamagotchiworld, tamagotchi;
	private ArrayList<InvaderObject> tamagotchiobjs = new ArrayList<InvaderObject>();
	// private BufferedImage img = null;


	public TamagotchiGfx() {

		initTamagotchiObjects();

	}

	private void initTamagotchiObjects() {
		tamagotchibg = new TamagotchiObj(this, "Sources/gfx/Tamagotchi.jpg", 0, 0);
		tamagotchiworld = new TamagotchiObj(this, "Sources/gfx/Tamagotchiwelt.png", 99, 135);
		tamagotchi = new TamagotchiObj(this, "Sources/gfx/Snatschikus.png", 202, 200);

		//tamagotchiobjs.add(tamagotchi);
		// try {
		// img = new ImageIO.read(new File("gfx/Tamagotchi.jpg"));
		// } catch (IOException e) {
		// // TODO: handle exception
		// }


	}

	public Dimension getPreferredSize() {
		return new Dimension(580,475);
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		//g.drawImage(img, 0, 0, null);

		tamagotchibg.draw(g2d);
		tamagotchiworld.draw(g2d);
		tamagotchi.draw(g2d);








	}







}