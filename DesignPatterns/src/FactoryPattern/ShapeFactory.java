package FactoryPattern;

public final class ShapeFactory{

	public ShapeFactory() {}

	public static Shape create(String shape) {
		switch(shape.toUpperCase()) {
			case "CIRCLE":
				return new Circle();
			case "SQUARE":
				return new Square();
			case "RECTANGLE":
				return new Rectangle();
			default:
				return null;
		}
	}
}
