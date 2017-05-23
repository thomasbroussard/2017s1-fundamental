/**
 * 
 */
package fr.epita.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author tbrou
 *
 */
public class Logger {

	private LogConfiguration configuration;
	private PrintWriter writer;

	public Logger(LogConfiguration configuration) throws FileNotFoundException {
		this.configuration = configuration;
		writer = new PrintWriter(new File(this.configuration.getFilePath()));
	}

	public void log(String message) {
		if (this.writer != null) {
			this.writer.println(message);
			this.writer.flush();
		}
	}

	public void log(String message, String level) {
		this.log(level + " : " + message);

	}
}
