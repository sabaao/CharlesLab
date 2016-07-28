package charles.test.AbstractFactorySample;

public class ShapeFactory extends AbstractFactory {

	@Override
	protected Color getColor(String color) {
		return null;
	}

	@Override
	protected Shape getShape(String shape) {
		if("CIRCLE".equals(shape)){
			return new Circle();
		}else if("SQUARE".equals(shape)){
			return new Square();
		}
		return null;
	}

}
