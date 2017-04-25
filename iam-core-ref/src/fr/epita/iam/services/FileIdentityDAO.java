/**
 * 
 */
package fr.epita.iam.services;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;

/**
 * DAO : Data Access Object, here to manage Identities
 * 
 * @author tbrou
 * 
 */
public class FileIdentityDAO {

	private PrintWriter printer;
	private Scanner scanner;

	/**
	 * 
	 */
	public FileIdentityDAO() {
		// 1 . file initialization
		File file = new File("/temp/tests/identities.txt");
		FileWriter writer = null;
		FileReader reader = null;
		if (!file.exists()) {
			// create the directory structure
			file.getParentFile().mkdirs();
			// create the file itself
			try {
				// "risky" operation
				file.createNewFile();
			} catch (IOException e) {
				// if something bad happens we go in the catch block.
				e.printStackTrace();
			}
		}
		try {
			writer = new FileWriter(file);
			reader = new FileReader(file);
		} catch (IOException e) {
			// TODO : improve so that the code is more readable (avoid a second
			// try-catch)
			e.printStackTrace();
		}
		if (writer == null || reader == null) {
			// we were not able to open the file in write mode.
			// TODO be sure to notify the user
			return;
		}
		// 3. writer & reader "augmentation"
		this.scanner = new Scanner(reader);
		this.printer = new PrintWriter(writer);
	}

	/**
	 * This is a save method, it will record the identity in the file using that
	 * format :
	 * 
	 * <pre>
	 * --- Identity ---
	 * uid
	 * displayName
	 * email
	 * --- Identity ---
	 * </pre>
	 * 
	 * @param identity
	 *            the identity to record
	 */
	public void save(Identity identity) {

		
		this.printer.println("--- Identity ---");
		this.printer.println(identity.getUid());
		this.printer.println(identity.getDisplayName());
		this.printer.println(identity.getEmail());
		this.printer.println("--- Identity ---");

		// commit the buffer in the real file
		this.printer.flush();
	}


	public List<Identity> search(Identity criteria) {

		
		// TODO : complete with a real search
		return new ArrayList<Identity>();

	}

	@Deprecated
	public void update(Identity identity) {

	}

	@Deprecated
	public void delete(Identity identity) {

	}

}
