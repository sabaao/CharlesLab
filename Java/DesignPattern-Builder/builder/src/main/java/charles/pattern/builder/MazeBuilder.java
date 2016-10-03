package charles.pattern.builder;

public interface MazeBuilder {
	
	public void buildRoad(int i ,int j );
	public void buildWall(int i ,int j);
	public void buildTreasure(int i ,int j);
	public Maze getMaze();
}
