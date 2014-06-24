package bo;

/**
 * 
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
	
	Code(String CodeName)
	{
		this.CodeName = CodeName;
	}
	
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
	
	public String getCodeName()
	{
		return this.CodeName;
	}
	
}
