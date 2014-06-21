package bo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InvaderGame extends Canvas implements KeyListener{


	private BufferStrategy strategy;
	private boolean gameRunning;
	private ArrayList<InvaderObject> invobjects = new ArrayList<InvaderObject>();
	private ArrayList<InvaderObject> removeList = new ArrayList<InvaderObject>();
	private String message;
	private boolean isTimeForSwitch;
	private Ship ship;
	private int moveSpeed = 300;
	private int alienCount;
	private boolean keyLeft = false;
	private boolean keyRight = false;
	private boolean shoot;
	private long shotDelay = 500;
	private long lastFired;

	public static void main(String[] args) {
		InvaderGame g = new InvaderGame();

		g.gameLoop();

	}

	public InvaderGame() {
		JFrame gameTest = new JFrame("Space invaders test");
		gameTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = (JPanel) gameTest.getContentPane();

		panel.setPreferredSize(new Dimension(800, 600));
		panel.setLayout(null);

		setBounds(0, 0, 800, 600);
		panel.add(this);

		addKeyListener(this);

		setIgnoreRepaint(true);

		gameTest.pack();
		gameTest.setResizable(false);
		gameTest.setVisible(true);

		createBufferStrategy(2);
		strategy = getBufferStrategy();

		initInvaderObjects();


		gameRunning = true;
	}

	public void gameLoop() {
		long lastLoopTime = System.currentTimeMillis();

		while (gameRunning) {
			long passedTime = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();	//Update last loop time

			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);


			for(InvaderObject invobj : invobjects)
			{
				invobj.move(passedTime);
			}

			for(InvaderObject invobj : invobjects)
			{
				invobj.draw(g);
			}

			//Check for collision
			for(int i=0; i < invobjects.size(); i++ )
			{
				for(int j=i+1; j < invobjects.size(); j++) {
					InvaderObject obj1 = invobjects.get(i);
					InvaderObject obj2 = invobjects.get(j);

					if (obj1.checkCollision(obj2)) {
						obj1.confirmCollision(obj2);
						obj2.confirmCollision(obj1);
					}

				}
			}

			//Cleanup dead aliens
			invobjects.removeAll(removeList);
			removeList.clear();

			if(isTimeForSwitch) {
				for (InvaderObject invobj : invobjects)
					invobj.switchDirection();
				isTimeForSwitch = false;
			}


			g.dispose();
			strategy.show();

			ship.setSpeedX(0);

			if(keyLeft && !keyRight)
				ship.setSpeedX(-moveSpeed);
			else if(keyRight && !keyLeft)
				ship.setSpeedX(moveSpeed);

			if(shoot)
				shooting();

			try
			{
				Thread.sleep(10);
			}
			catch (Exception e) {

			}

		}
	}

	private void initInvaderObjects() {
		ship = new Ship(this, "gfx/Raumschiff.png", 370, 550);
		invobjects.add(ship);

		alienCount = 0;

		for (int row = 0; row < 5; row++) {
			for (int x = 0; x < 12; x++) {
				InvaderObject alien = new InvaderAlien(this, "gfx/Raumschiff.png", 100+(x*50), 50+row*30);
				invobjects.add(alien);
				alienCount++;
			}
		}

	}

	public void shooting() {
		if(System.currentTimeMillis() - lastFired < shotDelay)
			return;

		lastFired = System.currentTimeMillis();
		Shot shot = new Shot(this, "gfx/Laser.png", (int) ship.getX()+10, (int) (ship.getY()-30));
		invobjects.add(shot);
	}

	public void removeObject(InvaderObject obj) {
		removeList.add(obj);
	}

	public void lost() {
		message = "You lost what a bummer";

	}

	public void updateDirection() {
		isTimeForSwitch = true;
	}

	public void AlienKilled() {
		alienCount--;

		if (alienCount == 0)
			win();

		for (InvaderObject obj : invobjects) {
			if (obj instanceof InvaderAlien)
				obj.setSpeedX(obj.getSpeedX() * 1.02);
		}

	}

	private void win() {
		message = "Hey you win";

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT )
			keyLeft = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			keyRight = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			shoot = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT )
			keyLeft = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			keyRight = false;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			shoot = false;

	}

}