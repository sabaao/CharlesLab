package charles.pattern.builder;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final int[][] material = {
                {1, 1, 1, 1, 1, 1, 1}, 
                {1, 0, 0, 0, 0, 2, 1}, 
                {1, 0, 1, 0, 1, 0, 1}, 
                {1, 0, 2, 1, 0, 1, 1}, 
                {1, 1, 0, 1, 0, 1, 1}, 
                {1, 0, 0, 2, 0, 0, 1}, 
                {1, 1, 1, 1, 1, 1, 1}};
    	MazeBuilder builder = new PlainBuilder(material.length, material[0].length);
    	
        MazeDirector director = new MazeDirector(material, 
        		builder);
        director.build();
    }
}
