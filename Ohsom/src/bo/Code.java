package bo;

/**
 * Code Enumeration für die verschiedenen Pflegecodes
 * @author Snatsch
 *
 */
public enum Code {
	WERTE("Werte"),
	FUETTERN("Füttern"),
	SCHLAFENLEGEN("Schlafen"),
	TRINKEN("Trinken"),
	SPIELEN("Spielen"),
	SHOP("Shop"),
	WASCHEN("Waschen"),
	MEDIZIN("Medizin"),
	INVENTAR("Inventar");
	
	private String CodeName;
	
	/**
	 * Konstruktor für Codes
	 * @param CodeName
	 */
	Code(String CodeName)
	{
		this.CodeName = CodeName;
	}
	
	/**
	 * Methode um einen Code mittels seines Namens zu erhalten
	 * @param codeName
	 * @return
	 */
	public static Code getCodeByName(String codeName)
	{
		for(Code code : Code.values())
		{
			if(code.toString().equalsIgnoreCase(codeName))
			{
				return code;
			}
		}
		return null;
	}
	
	/**
	 * Getter CodeName
	 * @return
	 */
	public String getCodeName()
	{
		return this.CodeName;
	}
	
}
