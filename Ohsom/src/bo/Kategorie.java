package bo;
/**
 * Enumeration Shopartikelkategorie
 * @author Snatsch
 *
 */
public enum Kategorie {
	FUTTER("Essen"), 
	GETRAENK("Getraenk"),
	SONSTIGES("Sonstiges");
	
	private String btnName;
	
	/**
	 * Konstruktor für Kategorie Enumeration
	 * @param btnName
	 */
	Kategorie(String btnName)
	{
		this.btnName = btnName;
	}
	
	/**
	 * Getter einer Kategorie mittels KategorieName
	 * @param KategorieName
	 * @return
	 */
	public static Kategorie getKategorieByName(String KategorieName)
	{
		for(Kategorie kat : Kategorie.values())
		{
			if(kat.name().equalsIgnoreCase(KategorieName))
			{
				return kat;
			}
		}
		return null;
	}
	
	/**
	 * Benennung der Buttonnamen im Shopgui
	 * @return
	 */
	public String getBtnName()
	{
		return this.btnName;
	}
}
