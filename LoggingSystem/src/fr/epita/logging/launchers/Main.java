/**
 * 
 */
package fr.epita.logging.launchers;

import java.io.FileNotFoundException;
import java.util.Date;

import fr.epita.logging.LogConfiguration;
import fr.epita.logging.Logger;

/**
 * @author tbrou
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		LogConfiguration conf = new LogConfiguration("/tmp/application.log");
		Logger logger = new Logger(conf);
		
		logger.log("First log message");
		logger.log("Second log message", "INFO");
		
		Date date = new Date(); 
		System.out.println(date);

	}

}
