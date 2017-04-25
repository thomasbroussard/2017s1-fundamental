/**
 * 
 */
package fr.epita.iam.tests.services;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.FileIdentityDAO;

/**
 * @author tbrou
 *
 */
public class TestFileIdentityDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// given the following service
		
		FileIdentityDAO dao = new FileIdentityDAO();
		
		// when you call the save method
		dao.save(new Identity("Thomas Broussard", "123", "tbr@tbr.com"));
		
		// then what?
		// TODO check that the file is getting created
		

	}

}
