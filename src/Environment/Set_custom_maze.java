package Environment;

public class Set_custom_maze {
	public static Maze setUp() {

		Maze maze= new Maze(6,6);
		
		String g = "green";
		String w = "wall";
		String b = "brown";
		String wh = "white";
		
		maze.set_square(wh,  0, 0);
		maze.set_square(wh,  0, 1);
		maze.set_square(wh,  0, 2);
		maze.set_square(g, 0, 3);
		maze.set_square(wh, 0, 4);
		maze.set_square(wh,  0, 5);
		
		maze.set_square(wh, 1, 0);
		maze.set_square(w,  1, 1);
		maze.set_square(w, 1, 2);
		maze.set_square(b,  1, 3);
		maze.set_square(w,  1, 4);
		maze.set_square(w,  1, 5);
		
		maze.set_square(wh, 2, 0);
		maze.set_square(w, 2, 1);
		maze.set_square(wh,  2, 2);
		maze.set_square(wh, 2, 3);
		maze.set_square(wh,  2, 4);
		maze.set_square(w, 2, 5);
		
		maze.set_square(wh, 3, 0);
		maze.set_square(w, 3, 1);
		maze.set_square(w, 3, 2);
		maze.set_square(w,  3, 3);
		maze.set_square(w, 3, 4);
		maze.set_square(w,  3, 5);
		
		maze.set_square(wh, 4, 0);
		maze.set_square(wh,  4, 1);
		maze.set_square(wh,  4, 2);
		maze.set_square(wh,  4, 3);
		maze.set_square(wh,  4, 4);
		maze.set_square(wh, 4, 5);
		
		maze.set_square(wh, 5, 0);
		maze.set_square(wh, 5, 1);
		maze.set_square(wh, 5, 2);
		maze.set_square(wh, 5, 3);
		maze.set_square(wh, 5, 4);
		maze.set_square(wh, 5, 5);	
		
		//maze.display_maze_symbolic();
		//maze.display_maze_utility();
		return maze;
	}	
}
