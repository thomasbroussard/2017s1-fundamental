/**
 * 
 */
package fr.epita.iam.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.DaoSaveException;

/**
 * DAO : Data Access Object, here to manage Identities
 * 
 * @author tbrou
 * 
 */
public class FileIdentityDAO implements IdentityDAO {

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
	public void save(Identity identity) throws DaoSaveException {

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
		ArrayList<Identity> results = new ArrayList<Identity>();
		while (this.scanner.hasNext()) {

			this.scanner.nextLine();
			String uid = this.scanner.nextLine();
			String displayName = this.scanner.nextLine();
			String email = this.scanner.nextLine();
			this.scanner.nextLine();

			Identity identity = new Identity(displayName, uid, email);
			if (identity.getDisplayName().startsWith(criteria.getDisplayName())) {
				results.add(identity);
			}

		}
		// FIXME!
		// TODO should be handled by a dedicated service
		this.scanner.close();
		try {
			this.scanner = new Scanner(new File("/temp/tests/identities.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;

	}

	@Deprecated
	public void update(Identity identity) throws IOException {
		ArrayList<Identity> results = new ArrayList<Identity>();
		while (this.scanner.hasNext()) {

			this.scanner.nextLine();
			String uid = this.scanner.nextLine();
			String displayName = this.scanner.nextLine();
			String email = this.scanner.nextLine();
			this.scanner.nextLine();

			Identity currentIdentity = new Identity(displayName, uid, email);
			// identity found
			if (identity.getUid().equals(currentIdentity.getUid())) {
				results.add(identity);
			} else {
				results.add(currentIdentity);
			}
		}

		// 1 . file initialization
		File file = new File("/temp/tests/identities.tmp.txt");
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

		PrintWriter printer = new PrintWriter(writer);
		for (Identity tobeSaved : results) {
			printer.println("--- Identity ---");
			printer.println(tobeSaved.getUid());
			printer.println(tobeSaved.getDisplayName());
			printer.println(tobeSaved.getEmail());
			printer.println("--- Identity ---");

		}
		// commit the buffer in the real file
		printer.flush();

		this.printer.close();
		this.scanner.close();

		File oldFile = new File("/temp/tests/identities.txt");
		Files.delete(oldFile.toPath());
		Files.move(file.toPath(), oldFile.toPath(), null);

		// TODO make the initialization again
		// 1 . file initialization
		oldFile = new File("/temp/tests/identities.txt");
		writer = null;
		reader = null;
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
		this.printer = new PrintWriter(writer);
		this.scanner = new Scanner(reader);

	}

	@Deprecated
	public void delete(Identity identity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.epita.iam.services.IdentityDAO#releaseResources()
	 */
	@Override
	public void releaseResources() {
		this.printer.close();
		this.scanner.close();

	}

}
