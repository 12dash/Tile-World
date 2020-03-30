package Helper;

import Environment.*;
import Agent.*;

public class CopyPolicy {
	public static void copy(Policy p, Policy p1, Maze m)
	{
		//This methods copies the content of one maze and stores it into another
		for(int i=0; i<m.m; i++)
		{
			for(int j = 0; j<m.n; j++)
			{
				if(m.maze[i][j].getS()==SquareType.wall)//Checking if the square is wall
				{
					continue;
				}
				else 
				{
					//Copying the policy for the particular state
					ActionType temp = p1.policy[i][j].getAction();
					p.policy[i][j].setAction(temp);				
				}
				
			}				
		}
		
	}

}
