package gui;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import bl.BLTamagotchi;
import bo.User;
import bo.Tamagotchi;

public class TamagotchiThread implements Runnable {
	
	BLTamagotchi blT = null;
	TamagotchiGUI tGui = null;
	
	public TamagotchiThread() //User currentUser, TamagotchiGUI tGui
	{
		/*blT = new BLTamagotchi(currentUser);
		this.tGui = tGui;
		*///run();
	}
	
	public void run()
	{
		run(new Date(), 10*60*120);
	}
	
	public void run(Date StartTime, int During)
	{
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  TamagotchiGUI.refreshTamagotchiArea();
				  System.out.println("You're so shitty and you know it");
			  }
			}, StartTime, During);
	}
}
