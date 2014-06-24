package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.mysql.fabric.xmlrpc.base.Array;

import bo.InvaderObject;
import bo.TamagotchiObj;

/**
 * 
 * @author Snatsch
 *
 */
public class TamagotchiGfx extends JPanel {

	private TamagotchiObj tamagotchibg, tamagotchiworld, tamagotchishit, tamagotchi;
	private ArrayList<InvaderObject> tamagotchiobjs = new ArrayList<InvaderObject>();
	// private BufferedImage img = null;


	public TamagotchiGfx() {

		initTamagotchiObjects();

	}

	private void initTamagotchiObjects() {
		tamagotchibg = new TamagotchiObj(this, "Sources/gfx/Tamagotchi.jpg", 0, 0);
		tamagotchiworld = new TamagotchiObj(this, "Sources/gfx/Tamagotchiwelt.png", 99, 135);
		tamagotchishit = null;
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

	/**
	 * Setzen, ob Tamagotchi sein Geschäft verrichtet hat oder nicht
	 * @param setShit
	 */
	public void setShit(boolean setShit)
	{
		if(setShit)
		{
			tamagotchishit = new TamagotchiObj(this, "Sources/gfx/pfui.png", 110, 330);
		}
		else
		{
			tamagotchishit = null;
		}


		this.repaint();
	}

	/**
	 * Setzen ob Tamagotchi im Schlafzustand oder nicht
	 * @param setSleeping (im Schlafzustand?)
	 * @param isIll (ist krank? => nur, wenn nicht schlafend)
	 */
	public void setSleeping(boolean setSleeping, boolean isIll)
	{
		if(setSleeping)
		{
			tamagotchiworld = new TamagotchiObj(this, "Sources/gfx/Tamagotchiwelt_Nacht.jpg", 99, 135);

			tamagotchi = new TamagotchiObj(this, "Sources/gfx/Snatschikus_Schlaf.png", 202, 260);
		}
		else
		{
			tamagotchiworld = new TamagotchiObj(this, "Sources/gfx/Tamagotchiwelt.png", 99, 135);
			String fileLocTemporary = "Snatschikus.png";

			if(isIll)
			{
				fileLocTemporary = "Snatschikus_krank.png";
			}
			tamagotchi = new TamagotchiObj(this, "Sources/gfx/" + fileLocTemporary, 202, 200);
		}

		this.repaint();
	}

	/**
	 * Setzen, ob Tamagotchi tot ist
	 * @param setDead
	 */
	public void setDead(boolean setDead)
	{
		if(setDead)
		{
			tamagotchi = new TamagotchiObj(this, "Sources/gfx/Snatschikus_tot.png", 190, 250);
		}
	}

	/**
	 * Zufälliges Setzen des Tamagotchis auf seinem Bildschirm
	 * @param isIll (ist Tamagotchi krank)
	 */
	public void moveTamagotchi(boolean isIll)
	{
		int[][] CoordinateList = new int[5][5];
		CoordinateList[0][0] = 202;
		CoordinateList[0][1] = 200;

		CoordinateList[1][0] = 120;
		CoordinateList[1][1] = 190;

		CoordinateList[2][0] = 140;
		CoordinateList[2][1] = 210;

		CoordinateList[3][0] = 150;
		CoordinateList[3][1] = 205;

		CoordinateList[4][0] = 175;
		CoordinateList[4][1] = 175;

		int x = (int) ((202 - 120) * Math.random() + 120);
		int y = (int) ((210 - 140) * Math.random() + 140);

		String fileLocTemporary = "Snatschikus.png";

		if(isIll)
		{
			fileLocTemporary = "Snatschikus_krank.png";
		}

		tamagotchi = new TamagotchiObj(this, "Sources/gfx/" + fileLocTemporary, x, y);

		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		//g.drawImage(img, 0, 0, null);

		tamagotchibg.draw(g2d);
		tamagotchiworld.draw(g2d);
		if(tamagotchishit != null)
		{
			tamagotchishit.draw(g2d);
		}
		tamagotchi.draw(g2d);

	}

}