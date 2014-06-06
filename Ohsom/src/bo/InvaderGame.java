package bo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InvaderGame extends Canvas {
	
	
	private BufferStrategy strategy;
	private boolean gameRunning;
	private ArrayList<InvaderObject> invobjects;
	
	public static void main(String[] args) {
		new InvaderGame();
	}

	public InvaderGame() {
		JFrame gameTest = new JFrame("Space invaders test");
		
		JPanel panel = (JPanel) gameTest.getContentPane();
		
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setLayout(null);
		
		setBounds(0, 0, 800, 600);
		panel.add(this);
		
		setIgnoreRepaint(true);
		
		gameTest.pack();
		gameTest.setResizable(false);
		gameTest.setVisible(true);
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		
		
		gameRunning = true;
		
		gameLoop();
	}
	
	public void gameLoop() {
		long lastLoopTime = System.currentTimeMillis();
		
		while (gameRunning) {
			long passedTime = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();		//Update last loop time
			
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			
			g.dispose();
			strategy.show();
			
			for(InvaderObject invobj : invobjects)
			{
					invobj.move(passedTime);
			}
			
			for(InvaderObject invobj : invobjects)
			{
					invobj.draw(g);
			}
			
			try 
			{
				Thread.sleep(10);
			}
			catch (Exception e) {
				
			}
				
		}
	}

}
