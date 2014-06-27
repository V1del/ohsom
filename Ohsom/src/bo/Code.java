package bo;

/**
 * Enumeration Pflegecodes
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
	 * Konstruktor
	 * @param CodeName
	 */
	Code(String CodeName)
	{
		this.CodeName = CodeName;
	}
	
	/**
	 * Getter Code abhängig vom Namen
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
	 * Getter des CodeNamens
	 * @return
	 */
	public String getCodeName()
	{
		return this.CodeName;
	}
	
}