package academy.mate.figure;

abstract class Shape {
	private String name;
	private String color;
	private double perimeter;
	private double square;

	abstract void setSquare(int side) throws IllegalArgumentException;

	abstract void getInfo();

	abstract void setPerimeter(int side) throws IllegalArgumentException;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	abstract void setColor();

	public double getPerimeter() {
		return perimeter;
	}

	public double getSquare() {
		return square;
	}
}
