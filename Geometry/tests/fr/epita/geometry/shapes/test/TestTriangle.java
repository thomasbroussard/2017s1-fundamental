/**
 * 
 */
package fr.epita.geometry.shapes.test;

import fr.epita.geometry.shapes.Triangle;

/**
 * @author tbrou
 *
 */
public class TestTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testTrianglePerimeter();
		
		testTriangleArea();
		
		
	}

	/**
	 * 
	 */
	private static void testTriangleArea() {
		//given
		Triangle triangle = new Triangle(3, 4, 1, 3);
		
		//when
		double area = triangle.calculateArea();
		
		//then
		if (area != 1.5){
			System.out.println("ERROR, area not correct");
		} else {
			System.out.println("OK, area is " + area);
		}
	}

	/**
	 * 
	 */
	private static void testTrianglePerimeter() {
		//given the following triangle
		Triangle triangle = new Triangle(1,4,3,2);
		
		//when we call the calculatePerimeter
		double perimeter = triangle.calculatePerimeter();
		
		
		//Then we should find 1 + 4 + 3 = 8
		if (perimeter != 8){
			System.out.println("ERROR : the perimeter is not correct");
		}else{
			System.out.println("OK, perimeter is : " + perimeter);
		}
	}

}
