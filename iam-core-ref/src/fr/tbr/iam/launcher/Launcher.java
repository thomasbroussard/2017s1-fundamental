/**
 * 
 */
package fr.tbr.iam.launcher;

import java.util.Scanner;

/**
 * @author tbrou
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


	
		Scanner scanner = new Scanner(System.in);
		
 
		
		if (!authenticate(scanner)) {
			return;
		} else {
			// We are authenticated
			String answer = "";
			while (!"4".equals(answer)) {
				System.out.println("Successfully authenticated");
				System.out.println("1. Create Identity");
				System.out.println("2. Update Identity");
				System.out.println("3. Delete Identity");
				System.out.println("4. Quit");
				System.out.println("your choice : ");


				answer = scanner.nextLine();

				switch (answer) {
				case "1":
					System.out.println("Identity Creation");
					// Create Identity
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

	/**
	 * @param scanner
	 * @return
	 */
	private static boolean authenticate(Scanner scanner) {
		System.out.println("User name :");
		String userName = scanner.nextLine();
		System.out.println("Password :");
		String password = scanner.nextLine();
//		if ("adm".equals(userName) && "pwd".equals(password)){
//			authenticated = true;
//		}else{
//			authenticated = false;
//		}
		return "adm".equals(userName) && "pwd".equals(password);
	}

}
