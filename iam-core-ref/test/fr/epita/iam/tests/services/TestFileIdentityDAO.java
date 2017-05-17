/**
 * 
 */
package fr.epita.iam.tests.services;

import java.util.List;

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
		// given the following service and that identity
		FileIdentityDAO dao = new FileIdentityDAO();
		Identity identity = new Identity("Thomas Broussard", "123", "tbr@tbr.com");
		
		
		// when you call the save method
		List<Identity> identityList = dao.search(null);
		int initialSize = identityList.size();
	
		dao.save(identity);
		
		identityList = dao.search(null);
		int finalSize = identityList.size();
		
		
		// then
		// TODO check that the file is getting created
		if (finalSize - initialSize != 1){
			System.out.println("error!");
		}
		
		System.out.println(identityList);
		

	}

}
