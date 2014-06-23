package gui;

import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import bl.BLTamagotchi;
import bo.User;
import bo.Tamagotchi;

/**
 * TamagotchiThread - Klasse, die das TamagotchiGUI regelm�ssig repainten l�sst
 * @author Snatsch
 *
 */
public class TamagotchiThread implements Runnable {

	TamagotchiGUI tGui = null;
	
	/**
	 * Konstruktor
	 * @param tGui
	 */
	public TamagotchiThread(TamagotchiGUI tGui) 
	{
		this.tGui = tGui;
	}
	
	/**
	 * Starten mit der RunMethode, f�r den Fall, dass keine Parameter �bergeben wurden
	 */
	public void run()
	{
		run(new Date(), 10*60);
	}
	
	/**
	 * Run Methode => wird ausgef�hrt, w�hrend der Thread l�uft
	 * @param StartTime Wann hat der Thread gestartet
	 * @param During In welchen Zeitintervallen l�uft er
	 */
	public void run(Date StartTime, int During)
	{
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  
				  try {
					tGui.refreshTamagotchiPanel();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			}, StartTime, During);
	}
}
