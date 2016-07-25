package charles.designpattern.SimpleFactorySample;

public class SimpleFactory {
	public static Shape createProduct(String product){
		if("circle".equals(product)){
			return new Circle();
		}else if("square".equals(product)){
			return new Square();
		}else{
			return null;
		}
	}
}
