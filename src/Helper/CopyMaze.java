package Helper;

import Environment.*;

public class CopyMaze {
	public static double copy(Maze m, Maze m1)
	{
		//This methods copies the content of one maze and stores it into another
		
		// The delta variable is used to check the max difference in the utilites of each square in the maze.
		double delta = m1.maze[0][0].get_utility()-m.maze[0][0].get_utility();
		for(int i=0; i<m.m; i++)
		{
			for(int j = 0; j<m.n; j++)
			{
				if(m.maze[i][j].getS()==SquareType.wall)
				{
					continue;
				}
				else 
				{
					double utility = m1.maze[i][j].get_utility();
					double temp = m1.maze[i][j].get_utility()-m.maze[i][j].get_utility();
					delta = Math.max(temp, delta);
					m.maze[i][j].set_utility(utility);
					
					
				}
				
			}				
		}
		return delta;
	}
}
