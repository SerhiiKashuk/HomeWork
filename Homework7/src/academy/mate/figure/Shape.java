package academy.mate.figure;

public class Shape {
	private String name;
	private String color;
	private double perimeter;
	private double square;

	public Shape(String name, String color) {
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
		System.out.println( "Shape [name=" + name + ", color=" + color + ", perimeter=" + perimeter + ", square=" + square + "]");
	}
	
	

}
