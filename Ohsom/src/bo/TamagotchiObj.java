package bo;

import gui.TamagotchiGfx;

public class TamagotchiObj extends InvaderObject {

	private TamagotchiGfx tamagotchi;

	public TamagotchiObj(TamagotchiGfx tamagotchi,String fileLoc, int x, int y) {
		super(fileLoc, x, y);
		this.tamagotchi = tamagotchi;
	}

	@Override
	public void confirmCollision(InvaderObject other) {
		// TODO Auto-generated method stub

	}

}