package bo;

public enum Code {
	WERTE,
	FUETTERN,
	SCHLAFENLEGEN,
	TRINKEN,
	SPIELEN,
	SHOP,
	WASCHEN,
	MEDIZIN,
	INVENTAR;
	
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
}
