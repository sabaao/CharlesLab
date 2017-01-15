package charles.pattern.property;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args ) throws CloneNotSupportedException
    {
        Flower flower = new Flower();
        flower.setType("rose");
        FragileBrick brick1 = new FragileBrick(flower);
        brick1.setColor(1);
        
        Brick brick2 = (Brick)brick1.clone();
        brick2.setColor(2);
        brick2.getFlower().setType("Ice");
        
        
        System.out.printf("brick1 type = %s%n", brick1.getFlower().getType());
        System.out.printf("brick2 type = %s%n", brick2.getFlower().getType());
        System.out.printf("brick1 color = %s%n", brick1.getColor());
        System.out.printf("brick2 color = %s%n", brick2.getColor());
    }
}
