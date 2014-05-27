package bl;

import db.DAOTamagotchiImpl;
import db.DAOUserImpl;
import bo.*;

public class BLTamagotchi {

	private Tamagotchi currentTamagotchi;
	private DAOTamagotchiImpl DAOT = new DAOTamagotchiImpl();
	
	public BLTamagotchi(User currentUser) {
		super();
		this.setCurrentTamagotchi(currentUser.getTamagotchi());
	}

	public Tamagotchi getCurrentTamagotchi() {
		return currentTamagotchi;
	}

	public void setCurrentTamagotchi(Tamagotchi currentTamagotchi) {
		this.currentTamagotchi = currentTamagotchi;
	}
	
	public boolean kaufeMedizin(int Menge)
	{
		boolean KaufErfolgreich = false;
		
		if(currentTamagotchi.GibGeldAus(Menge * 10) & currentTamagotchi.kaufeMedizin(Menge))
		{
			KaufErfolgreich = DAOT.changeTamagotchi(currentTamagotchi);
		}
		
		return KaufErfolgreich;
	}

}
