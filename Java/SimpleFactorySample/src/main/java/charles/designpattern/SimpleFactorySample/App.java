package charles.designpattern.SimpleFactorySample;

public class App {
	public static void main(String[] args){
		SimpleFactory.createProduct("circle").draw();
		SimpleFactory.createProduct("square").draw();
	}
}
