package gui;

import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MessageThread extends Thread implements Runnable{
	
	MessagesGUI mGui = null;
	
	/**
	 * Konstruktor
	 * @param mGui 
	 * @param tGui
	 */
	public MessageThread(MessagesGUI mGui) 
	{
		this.mGui = mGui;
	}
	
	public void run()
	{
		run(new Date(), 1*60);
	}
	
	public void run(Date StartTime, int During)
	{
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  
				  try {
					  System.out.println("Whyyyy :(");
					mGui.refreshDialog();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			}, StartTime, During);
	}
}
