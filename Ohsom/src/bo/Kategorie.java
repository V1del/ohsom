package bo;
/**
 * Enumeration Shopartikelkategorie
 * @author Snatsch
 *
 */
public enum Kategorie {
	FUTTER("Essen"), 
	GETRÄNK("Getraenk"),
	SONSTIGES("Sonstiges");
	
	private String btnName;
	
	Kategorie(String btnName)
	{
		this.btnName = btnName;
	}
	
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
	
	public String getBtnName()
	{
		return this.btnName;
	}
}
