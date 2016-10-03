package charles.pattern.builder;

/**
 * you can use implement different Maze
 * @author charles
 *
 */
public class MazeImpl implements Maze {

	public void paint(char[][] maze) {
		for(int i =0;i<maze.length;i++){
			for(int j =0;j<maze[i].length;j++){
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}

}
