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
	public Highscore(int punkte, bo.User user) {
		super();
		Punkte = punkte;
		User = user;
	}
	int Punkte;
	User User;
	
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
	public String getUser() {
		return User.getNickname();
	}
}
