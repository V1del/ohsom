package bl;

import bo.*;

public class BLTamagotchi {

	private Tamagotchi currentTamagotchi;
	
	public BLTamagotchi(User currentUser) {
		super();
		this.currentTamagotchi = currentUser.getTamagotchi();
	}

}
