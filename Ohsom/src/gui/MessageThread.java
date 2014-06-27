package gui;

import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

/**
 * 
 * @author Snatsch
 *
 */
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
		run(new Date(), 1000*30); // eine Minute, um zu überprüfen
	}
	
	public void run(final Date StartTime, final int During)
	{
		//SwingUtilities.invokeLater(
				//new Runnable() {

				    //@Override
				  //  public void run() {
				    	Timer timer = new Timer();
				    	timer.scheduleAtFixedRate(new TimerTask() {
							  @Override
							  public void run() {
								  
								  try {
									mGui.refreshDialog();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  }
							}, StartTime, During);
				  //  }
				//});
				
			
	}
}
