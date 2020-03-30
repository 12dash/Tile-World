package Helper;

import Environment.*;

public class Normalize {
	/* The class is used to Normalize the utilites after each iteration to the maximum utility which is 10*/
	public static void normalize(Maze m, int n)
	{
		double max = max_value(m);		
		divide(m, max, n);	}
	
	private static double max_value(Maze m)
	{
		/* Gets the maximum value of the utility in the maze*/
		double max = m.maze[0][0].get_utility();
		
		for(int i =0;i<m.m;i++)
		{
			for(int j =0;j<m.n;j++)
			{
				if(m.maze[i][j].getS()!=SquareType.wall)
					max = Math.max(max, m.maze[i][j].get_utility());
			}
		}
		if (max==0) max = 1;
		return max;
	}
	
	private static void divide(Maze m, double max, int n)
	{
		/* Divides the utility of each square in the maze with the maximum utility*/
		for(int i =0;i<m.m;i++)
		{
			for(int j =0;j<m.n;j++)
			{
				if(m.maze[i][j].getS()!=SquareType.wall)
				{
					double normal = (m.maze[i][j].get_utility())/max;
					
					(m.maze[i][j]).set_utility(normal*n);
				}	
			}
		}
	}

}
