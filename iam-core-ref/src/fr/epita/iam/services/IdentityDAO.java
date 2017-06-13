/**
 * 
 */
package fr.epita.iam.services;

import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.DaoSaveException;

/**
 * @author tbrou
 *
 */
public interface IdentityDAO {

	public void save(Identity identity) throws DaoSaveException;
	
	public void update(Identity identity);
	public void delete(Identity identity);
	public List<Identity> search(Identity criteria);
	
	public void releaseResources();
	
	
	
}
