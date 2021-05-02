package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;
	
	public RectTriangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		double area = this.width * this.height * 0.5;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = this.width + this.height + Math.sqrt(Math.pow(width, 2.0) + Math.pow(height, 2.0));
		return perimeter;
	}
}