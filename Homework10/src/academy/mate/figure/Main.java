package academy.mate.figure;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Shape[] figures = new Shape[2];

		L: for (int i = 0; i < figures.length; i++) {
			System.out.println("Enter for creating :" + "\n" + "1 - Circle; 2 - Square; 3 - Triangle; 0 - Exit");
			System.out.println("Shape # " + (i + 1));
			Scanner in = new Scanner(System.in);
			if (in.hasNextInt()) {
				int temp = in.nextInt();
				switch (temp) {
				case 1:
					System.out.println("You selected Circle. Enter radius : ");
					Shape circle = new Circle("Circle");
					circle.setColor();

					try {
						int r = in.nextInt();
						circle.setPerimeter(r);
						circle.setSquare(r);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Illegal argument " + e.getMessage());
					}

					figures[i] = circle;
					break;

				case 2:
					Shape square = new Square("Square");
					square.setColor();
					System.out.println("You selected Square. Enter length of side : ");
					try {
						int r = in.nextInt();
						square.setPerimeter(r);
						square.setSquare(r);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Illegal argument " + e.getMessage());
					}
					figures[i] = square;
					break;

				case 3:
					Shape triangle = new Triangle("Triangle");
					triangle.setColor();
					System.out.println("You selected Triangle. Enter length of side : ");
					try {
						int r = in.nextInt();
						triangle.setPerimeter(r);
						triangle.setSquare(r);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Illegal argument " + e.getMessage());
					}
					figures[i] = triangle;
					break;

				case 0:
					System.out.println("End");
					in.close();
					break L;
				}
			} else {
				System.out.println("Error");
				in.next();
			}

		}
		for (Shape shape : figures) {
			shape.getInfo();
		}
	}
}
