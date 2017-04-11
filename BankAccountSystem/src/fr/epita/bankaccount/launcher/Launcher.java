/**
 * 
 */
package fr.epita.bankaccount.launcher;

import java.util.Scanner;

import fr.epita.bankaccount.datamodel.Customer;

/**
 * @author tbrou
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to the bank account system");

		System.out.println("What would you like to do ?");
		System.out.println("1. Create a customer");
		System.out.println("2. Create an account");
		System.out.println("3. Perform an operation");
		System.out.println("your choice : ");

		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		System.out.println("you have selected :" + line);

		// analyse the answer
//		if ("1".equals(line)) {
//			System.out.println("you have selected customer creation");
//		} else if ("2".equals(line)) {
//
//		} else if ("3".equals(line)) {
//
//		}
		// alternate way to do the same test :
		switch (line) {
		case "1":
			System.out.println("you have selected customer creation");
			System.out.println("Input customer name :");
			String customerName = scanner.nextLine();
			System.out.println("Input customer address :");
			String customerAddress = scanner.nextLine();
			
			Customer customer = new Customer(customerName, customerAddress);
			

			break;
		case "2":
			break;
		case "3":
			break;
		default:

		}

	}

}
