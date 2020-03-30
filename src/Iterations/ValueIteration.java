package Iterations;

import Environment.*;
import UtilityFunctions.*;
import Helper.*;
import Agent.*;

import java.util.*;

public class ValueIteration {
	
	public static double run_value_iteration(double gamma, Maze m, double thresh, Policy p, List <String> s, int q, Maze m1)
	{
		/*The value iteration method */
		
		double delta=10;
		int number_iterations = 1;		
		while(delta>thresh) {//Terminates when the utilities converge and the value changes max upto threshold
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
						double utility = Utility.get_utility_state(i,j,m,gamma);
						m1.maze[i][j].set_utility(utility);
						
					}
					
				}	
				
			}	
			//Normalize.normalize(m1,q);	//normalizing the utility values			
			delta = CopyMaze.copy(m, m1);//Copying the maze					
			SaveCSV.save_list(m, s, number_iterations);	//Saving the utilities in the state			
			number_iterations++; //incrementing the number of iterations
		}	
		return number_iterations;
	}
	
}
