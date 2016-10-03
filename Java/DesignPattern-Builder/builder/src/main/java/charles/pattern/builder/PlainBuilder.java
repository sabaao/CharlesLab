package charles.pattern.builder;

public class PlainBuilder implements MazeBuilder {
	private char[][] maze;
	
	public PlainBuilder(int i,int j){
		maze = new char[i][j];
	}
	
	public void buildRoad(int i, int j) {
		maze[i][j] = ' ';

	}

	public void buildWall(int i, int j) {
		maze[i][j] = '□';

	}

	public void buildTreasure(int i, int j) {
		 maze[i][j] = '★';

	}

	public Maze getMaze() {
		Maze mazeImpl = new MazeImpl();
		mazeImpl.paint(maze);
		return mazeImpl;
	}

}
