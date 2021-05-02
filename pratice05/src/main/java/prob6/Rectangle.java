package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;
	
	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	@Override
	public void resize(double s) {
		this.width *= s;
		this.height *= s;
	}

	@Override
	public double getArea() {
		double area = this.width * this.height;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = (this.width + this.height) * 2.0;
		return perimeter;
	}
}