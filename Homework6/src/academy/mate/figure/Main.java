package academy.mate.figure;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Triangle triangle = new Triangle("Triangle", "Red");
		Circle circle = new Circle("Circle", "Green");
		Square square = new Square("Square", "Yellow");
		L: do {
			System.out.println("Enter for creating :" + "\n" + "1 - Circle; 2 - Square; 3 - Triangle; 0 - Exit");
			Scanner in = new Scanner(System.in);
			if (in.hasNextInt()) {
				int temp = in.nextInt();
				switch (temp) {
				case 1:
					System.out.println("You selected Circle. Enter radius : ");
					int r = in.nextInt();
					circle.getPerimeter(r);
					circle.getSquare(r);
					circle.getInfo();
					break;

				case 2:
					System.out.println("You selected Square. Enter length of side : ");
					int s = in.nextInt();
					square.getPerimeter(s);
					square.getSquare(s);
					square.getInfo();
					break;

				case 3:
					System.out.println("You selected Triangle. Enter length of side : ");
					int t = in.nextInt();
					triangle.getPerimeter(t);
					triangle.getSquare(t);
					triangle.getInfo();
					break;

				case 0:
					in.close();
					break L;
				}
			} else {
				System.out.println("Error");
				in.next();
			}

		} while (true);

	}

}
