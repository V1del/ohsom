package bo;

/**
 * 
 * @author vmuser
 *
 */
public class TamagotchiConfig {

		public TamagotchiConfig(int idUser, String code, String hotkey) {
		super();
		this.idUser = idUser;
		Code = code;
		Hotkey = hotkey;
	}
		private int idUser;
		private String Code;
		private String Hotkey;
		
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
		public String getCode() {
			return Code;
		}
		
		/**
		 * 
		 * @param code
		 */
		public void setCode(String code) {
			Code = code;
		}
		
		/**
		 * 
		 * @return
		 */
		public String getHotkey() {
			return Hotkey;
		}
		
		/**
		 * 
		 * @param hotkey
		 */
		public void setHotkey(String hotkey) {
			Hotkey = hotkey;
		}

}
