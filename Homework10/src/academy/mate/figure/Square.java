package academy.mate.figure;

public class Square extends Shape {
	private String name;
	private String color;
	private double perimeter;
	private double square;

	public Square(String name) {
		this.name = name;

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

	@Override
	public void setColor() {
		String[] colors = { "Red", "Yellow", "Green", "Blue", "Brown", "White", "Black", "Pink", "Purple", "Grey" };
		int i = (int) (Math.random() * colors.length);
		color = colors[i];
	}

	public double getPerimeter(int side) {
		return perimeter;
	}

	public double getSquare(int side) {
		return square;
	}

	@Override
	public void setPerimeter(int side) throws IllegalArgumentException {
		this.perimeter = 4 * side;
	}

	@Override
	public void setSquare(int side) throws IllegalArgumentException {
		this.square = Math.pow(side, 2);
	}

	@Override
	public void getInfo() {
		System.out.println("Square [name = " + name + ", color = " + color + ", perimeter = " + perimeter + ", square = "
		    + square + "]" + "\n");
	}
}
