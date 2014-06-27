package bo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Businessobjekt für die TamagotchiConfig
 * @author vmuser
 *
 */
public class TamagotchiConfig {

		public TamagotchiConfig(int idUser, String code, char hotkey) {
		super();
		this.idUser = idUser;
		Code = Code.getCodeByName(code);
		Hotkey = hotkey;
	}
		
		private int idUser;
		private Code Code;
		private char Hotkey;
		
		/**
		 * Konstruktor für eine Configdatei aus der Datenbank
		 * @param ConfigResultSet
		 * @throws SQLException
		 */
		public TamagotchiConfig(ResultSet ConfigResultSet) throws SQLException
		{
			super();
			this.idUser = ConfigResultSet.getInt("idUser");
			this.Code = Code.getCodeByName(ConfigResultSet.getString("Code"));
			this.Hotkey = ConfigResultSet.getString("Hotkey").charAt(0);
		}
		
		/**
		 * Konstruktor für eine neue Configdatei
		 * @param idUser
		 * @param code
		 */
		public TamagotchiConfig(int idUser, String code) {
			this.idUser = idUser;
			this.Code = Code.getCodeByName(code);
		}

		/**
		 * Getter idUser
		 * @return idUser
		 */
		public int getidUser() {
			return idUser;
		}

		/**
		 * Getter Code
		 * @return Code
		 */
		public Code getCode() {
			return Code;
		}
		
		/**
		 * Setter Code
		 * @param code
		 */
		public void setCode(String code) {
			Code = Code.getCodeByName(code);
		}
		
		/**
		 * Getter Hotkey
		 * @return Hotkey
		 */
		public char getHotkey() {
			return Hotkey;
		}
		
		/**
		 * Setter Hotkey
		 * @param hotkey
		 */
		public void setHotkey(char hotkey) {
			Hotkey = hotkey;
		}

}
