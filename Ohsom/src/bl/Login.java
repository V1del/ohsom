package bl;

import bo.User;

/**
 * Class that ensures that you have only one instance from an object
 * @author Snatsch
 *
 */
public class Login {
	   private static Login instance = null;
	   private User currentUser = null;
	   
	   protected Login() {
	      // Exists only to defeat instantiation.
	   }
	   
	   public static Login getInstance() {
	      if(instance == null) {
	         instance = new Login();
	      }
	      return instance;
	   }
	   
	   /**
	    * Methode zur Instanziierung des UserObjekts
	    * @param currentUser
	    */
	   public void logInUser(User currentUser)
	   {
		   this.currentUser = currentUser;
	   }
	   
	   /**
	    * Getter des aktuell eingeloggten Users
	    * @return
	    */
	   public User getUserInstance()
	   {
		   return this.currentUser;
	   }
	   
	   
	}