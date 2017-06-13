/**
 * 
 */
package fr.epita.iam.launcher;

import java.io.FileNotFoundException;
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.DaoSaveException;
import fr.epita.iam.services.Authenticator;
import fr.epita.iam.services.FileIdentityDAO;
import fr.epita.iam.services.IdentityDAO;
import fr.epita.logging.LogConfiguration;
import fr.epita.logging.Logger;

/**
 * @author tbrou
 *
 */
public class Launcher {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		IdentityDAO dao = new FileIdentityDAO();
		
		
		LogConfiguration conf = new LogConfiguration("/tmp/application.log");
		Logger logger = new Logger(conf);
		
	    logger.log("beginning of the program");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("User name :");
		String userName = scanner.nextLine();
		System.out.println("Password :");
		String password = scanner.nextLine();
		
		if (!Authenticator.authenticate(userName, password)) {
			logger.log("unable to authenticate "  + userName);
			return;
		} else {
			System.out.println("Successfully authenticated");
			// We are authenticated
			String answer = "";
			while (!"4".equals(answer)) {
			
				System.out.println("1. Create Identity");
				System.out.println("2. Update Identity");
				System.out.println("3. Delete Identity");
				System.out.println("4. Quit");
				System.out.println("your choice : ");
				
				logger.log("User chose the " + answer + " choice");

				answer = scanner.nextLine();

				switch (answer) {
				case "1":
					System.out.println("Identity Creation");
					logger.log("selected the identity creation");
					System.out.println("please input the identity display name :");
					String displayName  = scanner.nextLine();
					System.out.println("identity email :");
					String email = scanner.nextLine();
					Identity identity = new Identity(displayName, null, email);
					try {
						dao.save(identity);
						System.out.println("the save operation completed successfully");
					} catch (DaoSaveException e) {
						System.out.println("the save operation is not able to complete, details :" + e.getMessage());
					}
					
					break;
				case "2":

					// Update Identity
					System.out.println("Identity Update");
					break;
				case "3":

					// Delete Identity
					System.out.println("Identity Deletion");
					break;

				case "4":

					System.out.println("you decided to quit, bye!");
					break;
				default:

					System.out.println("unrecognized option : type 1,2,3 or 4 to quit");
					break;
				}

			}

		}

	}


}
