package academy.mate.figure;

public class Square {
	private String name;
	private String color;
	private double perimeter;
	private double square;

	public Square(String name, String color) {
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

	public double getPerimeter(int side) {
		perimeter = 4 * side;
		return perimeter;
	}

	public double getSquare(int side) {
		square = Math.pow(side, 2);
		return square;
	}

	public void getInfo() {
		System.out.println("Square [name = " + name + ", color = " + color + ", perimeter = " + perimeter + ", square = "
				+ square + "]" + "\n");
	}
}
