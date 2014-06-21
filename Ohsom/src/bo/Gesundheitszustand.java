package bo;

/**
 * Enumeration Gesundheitszustand
 * @author vmuser
 *
 */
public enum Gesundheitszustand {
	GESUND,
	KRANK,
	TOT;
	
	public static Gesundheitszustand getGesundheitszustandByName(String GesundheitszustandName)
	{
		for(Gesundheitszustand GZ : Gesundheitszustand.values())
		{
			if(GZ.name().equalsIgnoreCase(GesundheitszustandName))
			{
				return GZ;
			}
		}
		return null;
	}
}
