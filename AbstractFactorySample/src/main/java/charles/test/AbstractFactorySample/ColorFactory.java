package charles.test.AbstractFactorySample;

public class ColorFactory extends AbstractFactory {

	@Override
	protected Color getColor(String color) {
		if("RED".equals(color)){
			return new Red();
		}else if("WHITE".equals(color)){
			return new White();
		}
		return null;
	}

	@Override
	protected Shape getShape(String shape) {
		return null;
	}

}
