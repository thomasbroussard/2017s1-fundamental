/**
 * 
 */
package fr.epita.iam.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;

/**
 * @author tbrou
 *
 */
public class JDBCIdentityDAO {
	
	Connection connection;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public JDBCIdentityDAO() throws SQLException {
		this.connection = DriverManager.getConnection("");
	}

	
	public void save(Identity identity) throws SQLException{
		PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT....");
		preparedStatement.setString(1, identity.getDisplayName());
		preparedStatement.execute();
	}
	
	public List<Identity> search(Identity criteria) throws SQLException{
		PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * from IDENTITIES where ...");
		ResultSet results = preparedStatement.executeQuery();
		
		List<Identity> returnedList = new ArrayList<Identity>();

		while (results.next()){
			String displayName = results.getString("IDENTITY_DISPLAYNAME");
			String email = results.getString("IDENTITY_EMAIL");
			
			returnedList.add(new Identity(displayName, null, email));
			
		}
		
		return returnedList;
	}
}
