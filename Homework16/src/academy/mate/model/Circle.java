package academy.mate.model;

public class Circle extends Shape {
	private String name;
	private String color;
	private double perimeter;
	private double area;
	private String user;

	public Circle(String name) {
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
	public void setColor(String color) {
		
		this.color = color;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public double getArea() {
		return area;
	}

	@Override
	public void setPerimeter(int radius) throws IllegalArgumentException {
		this.perimeter = 2 * 3.14 * radius;
	}

	@Override
	public void setArea(int radius) throws IllegalArgumentException {
		this.area = 3.14 * Math.pow(radius, 2);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
