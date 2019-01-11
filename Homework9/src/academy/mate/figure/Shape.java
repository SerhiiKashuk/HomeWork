package academy.mate.figure;

public class Shape {
	private String name;
	public static String color;
	private double perimeter;
	private double square;

	public Shape(String name) {
		this.name = name;

	}

	static class Nested {

		static void setColor() {
			String[] colors = { "Red", "Yellow", "Green", "Blue", "Brown", "White", "Black", "Pink", "Purple", "Grey" };
			int i = (int) (Math.random() * colors.length);
			color = colors[i];
		}

		static String getColor() {
			return color;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(int side) {
		this.perimeter = side;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(int side) {
		this.square = side;
	}

	public void getInfo() {
		System.out.println(
				"Shape [name=" + name + ", color=" + color + ", perimeter=" + perimeter + ", square=" + square + "]");
	}

}
