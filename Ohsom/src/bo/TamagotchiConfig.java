package bo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
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
		
		public TamagotchiConfig(ResultSet ConfigResultSet) throws SQLException
		{
			super();
			this.idUser = ConfigResultSet.getInt("idUser");
			this.Code = Code.getCodeByName(ConfigResultSet.getString("Code"));
			this.Hotkey = ConfigResultSet.getString("Hotkey").charAt(0);
		}
		
		public TamagotchiConfig(int idUser, String code) {
			this.idUser = idUser;
			this.Code = Code.getCodeByName(code);
		}

		/**
		 * 
		 * @return
		 */
		public int getidUser() {
			return idUser;
		}

		/**
		 * 
		 * @return
		 */
		public Code getCode() {
			return Code;
		}
		
		/**
		 * 
		 * @param code
		 */
		public void setCode(String code) {
			Code = Code.getCodeByName(code);
		}
		
		/**
		 * 
		 * @return
		 */
		public char getHotkey() {
			return Hotkey;
		}
		
		/**
		 * 
		 * @param hotkey
		 */
		public void setHotkey(char hotkey) {
			Hotkey = hotkey;
		}

}
