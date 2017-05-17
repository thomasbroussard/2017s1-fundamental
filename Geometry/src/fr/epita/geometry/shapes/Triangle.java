/**
 * 
 */
package fr.epita.geometry.shapes;

/**
 * @author tbrou
 *
 */
public class Triangle implements Shape{
	private double sideA;
	private double sideB;
	private double sideC;
	private double heightC;

	

	/**
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 * @param heightC
	 */
	public Triangle(double sideA, double sideB, double sideC, double heightC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.heightC = heightC;
	}

	public double calculatePerimeter(){
		return sideA + sideB + sideC;
	}
	
	public double calculateArea(){
		return sideC * heightC / 2;
	}

	/**
	 * @return the sideA
	 */
	public double getSideA() {
		return sideA;
	}

	/**
	 * @param sideA the sideA to set
	 */
	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	/**
	 * @return the sideB
	 */
	public double getSideB() {
		return sideB;
	}

	/**
	 * @param sideB the sideB to set
	 */
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	/**
	 * @return the sideC
	 */
	public double getSideC() {
		return sideC;
	}

	/**
	 * @param sideC the sideC to set
	 */
	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	/**
	 * @return the heightC
	 */
	public double getHeightC() {
		return heightC;
	}

	/**
	 * @param heightC the heightC to set
	 */
	public void setHeightC(double heightC) {
		this.heightC = heightC;
	}

}
