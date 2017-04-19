/**
 * 
 */
package fr.epita.iam.tests.datamodel;

import fr.epita.iam.datamodel.Identity;

/**
 * @author tbrou
 *
 */
public class TestIdentity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Identity identity = new Identity("Thomas Broussard", "001", "tbr@tbr.com");
		
		System.out.println(identity);

	}

}
