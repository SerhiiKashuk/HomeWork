package academy.mate.figure;


public class Circle {
	private String name;
	private String color;
	private double perimeter;
	private double square;

	public Circle(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPerimeter(int radius) {
		perimeter = 2 * 3.14 * radius;
		return perimeter;
	}

	public double getSquare(int radius) {
		square = 3.14 * Math.pow(radius, 2);
		return square;
	}

	public void getInfo() {
		System.out
				.println("Circle [name = " + name + ", color = " + color + ", perimeter = " + perimeter + ", square = " + square + "]");
	}

}
