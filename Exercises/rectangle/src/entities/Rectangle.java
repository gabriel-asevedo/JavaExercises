package entities;

public class Rectangle {

	private Double width;
	private Double height;

	public Rectangle() {
		super();
	}

	public Rectangle(Double width, Double height) {
		this.width = width;
		this.height = height;
	}

	public double area() {
		return width * height;
	}

	public double perimeter() {
		return 2 * (width + height);
	}

	public double diagonal() {
		return Math.sqrt(width * width + height * height);
	}

	@Override
	public String toString() {
		return "\n\tRectangle Data"
				+ String.format("\nArea: %.2f\nPerimeter: %.2f\nDiagonal: %.2f", area(), perimeter(), diagonal());
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

}