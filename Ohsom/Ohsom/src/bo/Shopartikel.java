package bo;
/**
 * Shopartikel - Klasse
 * @author vmuser
 *
 */
public class Shopartikel {
	public Shopartikel(int idArtikel, String artikelname, double preis,
			bo.Kategorie kategorie) {
		super();
		this.idArtikel = idArtikel;
		Artikelname = artikelname;
		Preis = preis;
		Kategorie = kategorie;
	}
	
	int idArtikel;
	String Artikelname;
	double Preis;
	Kategorie Kategorie;

	/**
	 * Getter Artikelname
	 * @return
	 */
	public String getArtikelname() {
		return Artikelname;
	}
	
	/**
	 * Getter Preis
	 * @return
	 */
	public double getPreis() {
		return Preis;
	}
	
	/**
	 * Getter Kategorie
	 * @return
	 */
	public Kategorie getKategorie() {
		return Kategorie;
	}
	
}
