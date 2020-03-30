package Environment;
import Environment.Maze;

public class SetMaze {
	public static Maze setUp() {
		/* The method sets up the maze and defines each and every possible type of square that is present in the maze like green, white, brown and wall*/
		Maze maze= new Maze(6,6);
		
		String g = "green";
		String w = "wall";
		String b = "brown";
		String wh = "white";
		
		maze.set_square(g,  0, 0);
		maze.set_square(w,  0, 1);
		maze.set_square(g,  0, 2);
		maze.set_square(wh, 0, 3);
		maze.set_square(wh, 0, 4);
		maze.set_square(g,  0, 5);
		
		maze.set_square(wh, 1, 0);
		maze.set_square(b,  1, 1);
		maze.set_square(wh, 1, 2);
		maze.set_square(g,  1, 3);
		maze.set_square(w,  1, 4);
		maze.set_square(b,  1, 5);
		
		maze.set_square(wh, 2, 0);
		maze.set_square(wh, 2, 1);
		maze.set_square(b,  2, 2);
		maze.set_square(wh, 2, 3);
		maze.set_square(g,  2, 4);
		maze.set_square(wh, 2, 5);
		
		maze.set_square(wh, 3, 0);
		maze.set_square(wh, 3, 1);
		maze.set_square(wh, 3, 2);
		maze.set_square(b,  3, 3);
		maze.set_square(wh, 3, 4);
		maze.set_square(g,  3, 5);
		
		maze.set_square(wh, 4, 0);
		maze.set_square(w,  4, 1);
		maze.set_square(w,  4, 2);
		maze.set_square(w,  4, 3);
		maze.set_square(b,  4, 4);
		maze.set_square(wh, 4, 5);
		
		maze.set_square(wh, 5, 0);
		maze.set_square(wh, 5, 1);
		maze.set_square(wh, 5, 2);
		maze.set_square(wh, 5, 3);
		maze.set_square(wh, 5, 4);
		maze.set_square(wh, 5, 5);	
		
		return maze;
	}	
}
