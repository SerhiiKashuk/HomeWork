package academy.mate.model;

public class Triangle extends Shape {
	private String name;
	private String color;
	private double perimeter;
	private double area;
	private String user;

	public Triangle(String name) {
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
	public void setPerimeter(int side)  {
		this.perimeter = 3 * side;
	}

	@Override
	public void setArea(int side)  {
		this.area = Math.pow(side, 2) * Math.sqrt(3) / 4;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}



}
