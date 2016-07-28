package charles.test.AbstractFactorySample;

public abstract class AbstractFactory {
	protected abstract Color getColor(String color);
	protected abstract Shape getShape(String shape);
}
