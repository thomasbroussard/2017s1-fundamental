/**
 * 
 */
package fr.epita.geometry.shapes;

/**
 * @author tbrou
 *
 */
public class Square implements Shape {
	
	private double side;

	/**
	 * @return the side
	 */
	public double getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(double side) {
		this.side = side;
	}

	/**
	 * @param side
	 */
	public Square(double side) {
		this.side = side;
	}

	/* (non-Javadoc)
	 * @see fr.epita.geometry.shapes.Shape#calculateArea()
	 */
	@Override
	public double calculateArea() {
		return this.side * this.side;
	}
	
	

	/* (non-Javadoc)
	 * @see fr.epita.geometry.shapes.Shape#calculatePerimeter()
	 */
	@Override
	public double calculatePerimeter() {
		return this.side * 4;
	}
	
	
	
	
	

}
