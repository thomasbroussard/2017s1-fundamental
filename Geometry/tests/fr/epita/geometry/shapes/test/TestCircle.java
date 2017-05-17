/**
 * 
 */
package fr.epita.geometry.shapes.test;

import fr.epita.geometry.shapes.Circle;

/**
 * @author tbrou
 *
 */
public class TestCircle {
	
	public static void main(String[] args) {
		//given
		Circle circle = new Circle(3);
		
		//when
		double area = circle.calculateArea();
		
		//then
		if (area > 28.27 && area <28.28 ){
			System.out.println("OK, area :" + area);
		}else{
			System.out.println("ERROR, area was expected around 28.28 and is :" + area);
		}
		
		
		
	}

}
