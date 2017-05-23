/**
 * 
 */
package fr.epita.logging;

/**
 * @author tbrou
 *
 */
public class LogConfiguration {
	private String filePath;

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @param filePath
	 */
	public LogConfiguration(String filePath) {
		this.filePath = filePath;
	}
	
	

}
