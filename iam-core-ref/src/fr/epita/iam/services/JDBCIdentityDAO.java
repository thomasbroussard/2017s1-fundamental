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
import fr.epita.iam.exceptions.DaoSaveException;
import fr.epita.iam.exceptions.DaoSearchException;

/**
 * 
 * This is a class that contains all the database operations for the class
 * Identity
 * 
 * <pre>
 *  JDBCIdentityDAO dao = new JDBCIdentityDAO();
 *  // save an identity
 *  dao.save(new Identity(...));
 *  
 *  //search with an example criteria (qbe)  
 *  dao.search(new Identity(...);
 * </pre>
 * 
 * <b>warning</b> this class is dealing with database connections, so beware to
 * release it through the {@link #releaseResources()}
 * 
 * @author tbrou
 *
 */
public class JDBCIdentityDAO implements IdentityDAO {

	Connection connection;

	/**
	 * @throws SQLException
	 * 
	 */
	public JDBCIdentityDAO() throws SQLException {
		this.connection = DriverManager.getConnection("");
	}

	public void save(Identity identity) throws DaoSaveException {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT....");
			preparedStatement.setString(1, identity.getDisplayName());
			preparedStatement.execute();
		} catch (SQLException sqle) {
			DaoSaveException exception = new DaoSaveException();
			exception.initCause(sqle);
			exception.setFaultObject(identity);
			throw exception;
		}
	}

	public List<Identity> search(Identity criteria) throws DaoSearchException {
		List<Identity> returnedList = new ArrayList<Identity>();
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("SELECT * from IDENTITIES where ...");

			ResultSet results = preparedStatement.executeQuery();

			while (results.next()) {
				String displayName = results.getString("IDENTITY_DISPLAYNAME");
				String email = results.getString("IDENTITY_EMAIL");
				returnedList.add(new Identity(displayName, null, email));

			}
		} catch (SQLException sqle) {
			DaoSearchException daose = new DaoSearchException();
			daose.initCause(sqle);
			throw daose;
		}

		return returnedList;
	}

	/**
	 * this is releasing the database connection, so you should not use this
	 * instance of DAO anymore
	 */
	public void releaseResources() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.epita.iam.services.IdentityDAO#update(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void update(Identity identity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.epita.iam.services.IdentityDAO#delete(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void delete(Identity identity) {
		// TODO Auto-generated method stub

	}
}
