package UtilityFunctions;
import Agent.*;
import Environment.*;

public class Utility {
	
	public static double get_action_utility(double i, double il, double ir)
	{	
		/** Gives the expected utility when the possible states are given */
		
		double a = 0.0;//The expected utility value
			
		a += i*Transition.intended.get_prob();		
		a += il*Transition.intendedLeft.get_prob();		
		a += ir*Transition.intendedRight.get_prob();
		 		
		return a;
	}
	
	public static boolean possible_state(int m, int n, Maze maze) 
	{
		/** to check if the agent is going out of the maze or hitting a wall*/
		
		boolean flag= true;
		
		if((m<0)||(n<0)||(m>=maze.m)||(n>=maze.n)) 	   	   flag = false;//Checks if the agent action is within the maze
		else if(maze.maze[m][n].getS() == SquareType.wall) flag = false;//Checks if the agent action is hitting a wall
					
		return flag;//Returns the outcome
	}
	
	public static double get_utility_state(int m, int n, Maze maze, double gamma)
	{
		//Method to get the best action and returns the string
		double util = 0;
		
		double reward = maze.maze[m][n].getS().get_reward();
		
		double action_util = 0;
		
		double action_up    = 0.0;		
		double action_left  = 0.0;		
		double action_right = 0.0;		
		double action_down  = 0.0;
		
		//To check if the agent can reach a particular state by taking that action.
		boolean up    = possible_state(m-1,n,maze);
		boolean down  = possible_state(m+1,n,maze);
		boolean left  = possible_state(m,n-1,maze);
		boolean right = possible_state(m,n+1,maze);
		
		//Stores the utility of the action 
		double up_util    = maze.maze[m][n].get_utility();
		double down_util  = maze.maze[m][n].get_utility();
		double left_util  = maze.maze[m][n].get_utility();
		double right_util = maze.maze[m][n].get_utility();
		
		if(up) up_util       = maze.maze[m-1][n].get_utility();
		if(left) left_util   = maze.maze[m][n-1].get_utility();
		if(right) right_util = maze.maze[m][n+1].get_utility();
		if(down) down_util   = maze.maze[m+1][n].get_utility();
		
		/* If the agent want to go up */
		action_up   = get_action_utility(up_util,left_util,right_util);
		/* If the agent want to go left */
		action_left = get_action_utility(left_util,up_util,down_util);		
		/* If the agent want to go right */
		action_right= get_action_utility(right_util,up_util,down_util);		
		/* If the agent want to go down*/
		action_down = get_action_utility(down_util,left_util,right_util);

		/*Stores the maximum utility with respect to an action */
		action_util = Math.max(Math.max(action_up, action_down),Math.max(action_left, action_right));
		
		util = reward + gamma*(action_util);
		
		return util;
	}
	
}
