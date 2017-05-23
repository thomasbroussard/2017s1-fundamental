/**
 * 
 */
package fr.epita.geometry.launcher;

import java.util.ArrayList;
import java.util.List;

import fr.epita.geometry.shapes.Circle;
import fr.epita.geometry.shapes.Shape;
import fr.epita.geometry.shapes.Square;
import fr.epita.geometry.shapes.Triangle;

/**
 * @author tbrou
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Shape> shapesList = new ArrayList<>();
		
		Shape triangle1 = new Triangle(10, 20, 30, 40); 
		Shape triangle2 = new Triangle(20, 10, 20, 30); 
		Shape triangle3 = new Triangle(100, 20, 50, 40); 
		
		
		Shape square1 = new Square(10);
		Shape square2 = new Square(20);
		Shape square3 = new Square(30);
		
		Shape circle1 = new Circle(10);
		Shape circle2 = new Circle(15);
		Shape circle3 = new Circle(25);
		
		shapesList.add(triangle1);
		shapesList.add(triangle2);
		shapesList.add(triangle3);
		shapesList.add(square1);
		shapesList.add(square2);
		shapesList.add(square3);
		shapesList.add(circle1);
		shapesList.add(circle2);
		shapesList.add(circle3);

		double globalAreaFromList = 0;
		double globalPerimeterFromList = 0;
		for (Shape shape : shapesList) {
			globalAreaFromList += shape.calculateArea();
			globalPerimeterFromList += shape.calculatePerimeter();
		}
		
		System.out.println(globalAreaFromList);
		System.out.println(globalPerimeterFromList);
//		
//		double globalArea = triangle1.calculateArea();
//		globalArea = triangle2.calculateArea() + globalArea;
//		globalArea += triangle3.calculateArea();
//		globalArea += square1.calculateArea();
//		globalArea += square2.calculateArea();
//		globalArea += square3.calculateArea(); 
//		globalArea += circle1.calculateArea();
//		globalArea += circle2.calculateArea();
//		globalArea += circle3.calculateArea();
		
		

	}

}
