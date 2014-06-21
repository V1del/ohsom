package bo;

/**
 * Klasse Highscore
 * @author vmuser
 *
 */
public class Highscore {
	
	/**
	 * Konstruktor Highscore
	 * @param punkte
	 * @param user
	 */
	public Highscore(int punkte, int iduser) {
		super();
		Punkte = punkte;
		idUser = iduser;
	}
	int Punkte;
	int idUser;
	
	/**
	 * Getter Punkte
	 * @return
	 */
	public int getPunkte() {
		return Punkte;
	}
	
	/**
	 * Setter Punkte
	 * @param punkte
	 */
	public void setPunkte(int punkte) {
		Punkte = punkte;
	}

	/**
	 * Getter User (Nickname)
	 * @return
	 */
	public int getIdUser() {
		return idUser;
	}
}
