package charles.pattern.property;

public class FragileBrick extends Brick{
	
	public FragileBrick(Flower flower){
		super.setFlower(flower);
	}
	
	


	public Object clone() throws CloneNotSupportedException{
		Brick brick = (Brick)super.clone();
		
		brick.setFlower((Flower)flower.clone());
		
		return brick;
	}
}
