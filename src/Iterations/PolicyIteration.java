package Iterations;

import Environment.*;
import UtilityFunctions.Utility;
import Helper.*;

import java.util.List;

import Agent.*;

public class PolicyIteration {

	public static int policyIterations(Maze m, Policy p, double gamma, List<String> s, int q, Maze m1) {
		
		/* Policy iteration method*/
		Policy n = new Policy(m);	
		int s1 = 0;
		
		boolean flag = false;
		
		int k = 0;
		
		for (k = 0; k >=0; k++) {
			/* Outer loop to keep a track of the number of iterations */
			
			for (int i = 0; i < m.m; i++) {
				/*Iterating through the rows of the maze */
				
				for (int j = 0; j < m.n; j++) {
					/*Iterating through all the possible squares in the row i.e. the columns */
					
					double util = 0;
					
					/*Checking if the action is possible */
					boolean up    = Utility.possible_state(i - 1, j, m);
					boolean down  = Utility.possible_state(i + 1, j, m);
					boolean left  = Utility.possible_state(i, j - 1, m);
					boolean right = Utility.possible_state(i, j + 1, m);
					
					/* Initializes the utility of the next possible state when the action can not be performed due to collision with the wall */
					double up_util    = m.maze[i][j].get_utility();
					double down_util  = m.maze[i][j].get_utility();
					double left_util  = m.maze[i][j].get_utility();
					double right_util = m.maze[i][j].get_utility();
					
					/* Initializes the utility of the next state if the action is possible*/
					if (up)    up_util   = m.maze[i - 1][j].get_utility();
					if (left)  left_util = m.maze[i][j - 1].get_utility();
					if (right) right_util= m.maze[i][j + 1].get_utility();
					if (down)  down_util = m.maze[i + 1][j].get_utility();
					
					/*Stores the utility of the state based on the action*/
					if ((p.policy[i][j].getAction() == ActionType.up)) 	 util = Utility.get_action_utility(up_util, left_util, right_util);					
					if ((p.policy[i][j].getAction() == ActionType.left)) util = Utility.get_action_utility(left_util, up_util, down_util);					
					if ((p.policy[i][j].getAction() == ActionType.right))util = Utility.get_action_utility(right_util, up_util, down_util);					
					if ((p.policy[i][j].getAction() == ActionType.down)) util = Utility.get_action_utility(down_util, left_util, right_util);
					

					util = m.maze[i][j].getS().get_reward() + util * gamma;					
					
					m1.maze[i][j].set_utility(util);
					
					String temp = Policy.get_best_action(i, j, m1);
					
					n.policy[i][j].set_action(temp);
				}
			}
			/* To check if the policy changed after each iteration*/
			boolean f = detect_change(p, n, m);
			
			
			/*The method ends when the policy does not change for 10 iteration */
			if (f) 
			{
				flag = false;
				s1 = k;
			} 
			else 
			{
				if (!flag) {flag = true;s1 = k;}
				else if (k - s1 > 10)	return k;
			}

			//Normalize.normalize(m1,q);	//normalizing the utility values			
			CopyPolicy.copy(p, n, m);	//Storing the policy
			CopyMaze.copy(m, m1);		//Copying the maze
			SaveCSV.save_list(m, s, k);	//Saving the utilities in the state
		}

		return k;//The number of iterations
	}

	

	private static boolean detect_change(Policy n, Policy m, Maze maze) {
		
		/** The method checks if the policy is changed or not*/
		
		boolean flag = false;

		for (int i = 0; i < maze.m; i++) {
			
			for (int j = 0; j < maze.n; j++) {
				
				if(maze.maze[i][j].getS()!=SquareType.wall)//Checking if the maze square is not a wall
					if (!(n.policy[i][j].getAction()==(m.policy[i][j]).getAction())) flag = true;// If there is a change			
			}
		}

		return flag;
	}
}
