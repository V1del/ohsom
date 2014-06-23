package bo;

/**
 * 
 * @author Snatsch
 *
 */
public enum Code {
	WERTE("Werte"),
	FUETTERN("Füttern"),
	SCHLAFENLEGEN("Schlafenlegen"),
	TRINKEN("Trinken geben"),
	SPIELEN("Spielen"),
	SHOP("Shop"),
	WASCHEN("Waschen"),
	MEDIZIN("Medizin geben"),
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
