/**
 * 
 */
package fr.epita.iam.services;

/**
 * Main authenticator service
 * @author tbrou
 *
 */
public class Authenticator {
	
	/**
	 * This method is checking authentication
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean authenticate(String userName, String password){
		
		return "adm".equals(userName) && "pwd".equals(password);
		
	}

}
