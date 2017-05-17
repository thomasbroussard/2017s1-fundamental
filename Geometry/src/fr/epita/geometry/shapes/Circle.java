/**
 * 
 */
package fr.epita.geometry.shapes;

/**
 * @author tbrou
 *
 */
public class Circle implements Shape{

	private double radius;

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @param radius
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	public double calculateArea(){
		return this.radius * this.radius * Math.PI;
	}
	
	public double calculatePerimeter(){
		return this.radius * 2 * Math.PI;
	}
	

	
	
}
