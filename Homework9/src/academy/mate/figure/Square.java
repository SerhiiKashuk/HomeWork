package academy.mate.figure;

import static academy.mate.figure.Shape.color;

public class Square extends Shape {
	private String name;

	private double perimeter;
	private double square;

	public Square(String name) {
		super(name);
		this.name = name;
		;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public String getColor() { return color; }
	 * 
	 * public void setColor(String color) { this.color = color; }
	 */

	public double getPerimeter(int side) {
		return perimeter;
	}

	public double getSquare(int side) {
		return square;
	}

	@Override
	public void setPerimeter(int side) {
		this.perimeter = 4 * side;
	}

	@Override
	public void setSquare(int side) {
		this.square = Math.pow(side, 2);
	}

	@Override
	public void getInfo() {
		System.out.println("Square [name = " + name + ", color = " + color + ", perimeter = " + perimeter
				+ ", square = " + square + "]" + "\n");
	}
}
