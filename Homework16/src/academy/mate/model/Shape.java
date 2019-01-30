package academy.mate.model;

public abstract class Shape {
	private String name;
	private String color;
	private double perimeter;
	private double area;
	private String user;

	public abstract void setArea(int side);

	public abstract void setPerimeter(int side);

	public abstract void setColor(String color);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public double getArea() {
		return area;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
