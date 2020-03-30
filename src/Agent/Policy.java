package Agent;

import Environment.*;
import UtilityFunctions.Utility;
import Agent.Action;

public class Policy {
	/** Class which will be instantiated to store the policy that an agent has*/
	
	//The matrix storing the policy. Since a policy is a series of action, the matrix is of type Action.
	public Action policy[][];
	
	public Policy(Maze maze)
	{
		//Constructor to initialize the policy matrix
		policy = new Action[maze.m][maze.n];
		
		for(int i =0;i<maze.m;i++)
		{
			for(int j =0;j<maze.n;j++)
			{
				//Default policy is up for each state
				policy[i][j] = new Action();				
			}
		}
	}
	
	public void display_policy(Maze m)
	{
		//Method to display the policy
		System.out.println("Policy : ");
		System.out.println(" _______________________________________________________________________________________________");
		for(int i = 0;i<m.m;i++)
		{			
				System.out.print("|");
				for(int j=0; j<m.n; j++)
				{
					if (((m.maze[i][j]).getS())!=SquareType.wall)
						System.out.print("\t"+this.policy[i][j].getAction().get_display()+"\t|");	
					else
						System.out.print("\t"+(m.maze[i][j].getS()).get_display()+"\t|");	
				}
				System.out.println("");
				System.out.println(" _______________________________________________________________________________________________");
			}
		}
	
	public boolean set_policy(Maze m) {
		//The method sets the policy when the maze is given. The maze stores utilites of each state. The method selects best action to take in each state.
		boolean flag = false;//
			for(int i =0;i<m.m;i++)
			{
				for(int j =0;j<m.n;j++)
				{
					//To check if the agent can reach a particular state by taking that action.
					boolean up = Utility.possible_state(i-1,j,m);
					boolean down = Utility.possible_state(i+1,j,m);
					boolean left = Utility.possible_state(i,j-1,m);
					boolean right = Utility.possible_state(i,j+1,m);
					
					//Utility of the current state
					double current = m.maze[i][j].get_utility();
					
					//Utility if the action 
					double u_up = 0;
					double u_down = 0;
					double u_right= 0;
					double u_left = 0;
					
					//Will be used to calculate maximum utility
					double max = current;
					if(up)
					{
						u_up = m.maze[i-1][j].get_utility();
					}
					if(down)
					{
						u_down = m.maze[i+1][j].get_utility();
					}
					if(left)
					{
						u_left = m.maze[i][j-1].get_utility();
					}
					if(right)
					{
						u_right = m.maze[i][j+1].get_utility();
					}
					
					boolean flag1 = false ; 
					
					if(u_down>max)
					{
						policy[i][j].set_action("down");
						max = u_down;
						flag1 = true;
					}
					if(u_left>max)
					{
						policy[i][j].set_action("left");
						max = u_left;
						flag1 = true;
					}
					if(u_right>max)
					{
						policy[i][j].set_action("right");
						max = u_right;
						flag1 = true;
					}
					if(u_up>max)
					{
						policy[i][j].set_action("up");
						max = u_up;
						flag1 = true;
					}
					
					if(flag1==false)
					{
						String s = get_best_action(i,j,m);
						policy[i][j].set_action(s);
					}
					
				}
			}
		return flag;
	}
	
	public static String get_best_action(int m, int n, Maze maze)
	{
		//Method to get the best action and returns the string
		String s = "";
		
		double action_up = 0.0;		
		double action_left = 0.0;		
		double action_right = 0.0;		
		double action_down = 0.0;
		
		//To check if the agent can reach a particular state by taking that action.
		boolean up = Utility.possible_state(m-1,n,maze);
		boolean down = Utility.possible_state(m+1,n,maze);
		boolean left = Utility.possible_state(m,n-1,maze);
		boolean right = Utility.possible_state(m,n+1,maze);
		
		//Stores the utility of the action 
		double up_util = maze.maze[m][n].get_utility();
		double down_util = maze.maze[m][n].get_utility();
		double left_util = maze.maze[m][n].get_utility();
		double right_util = maze.maze[m][n].get_utility();
		
		if(up) up_util = maze.maze[m-1][n].get_utility();
		if(left) left_util = maze.maze[m][n-1].get_utility();
		if(right) right_util = maze.maze[m][n+1].get_utility();
		if(down) down_util = maze.maze[m+1][n].get_utility();
		
		/* If the agent want to go up */
		action_up = Utility.get_action_utility(up_util,left_util,right_util);
		/* If the agent want to go left */
		action_left = Utility.get_action_utility(left_util,up_util,down_util);		
		/* If the agent want to go right */
		action_right = Utility.get_action_utility(right_util,up_util,down_util);		
		/* If the agent want to go down*/
		action_down =Utility. get_action_utility(down_util,left_util,right_util);
		
		double action_util = Math.max(Math.max(action_up, action_down),Math.max(action_left, action_right));
		
		if(action_util == action_up)
		{
			s = "up";
		}
		else if(action_util == action_down)
		{
			s = "down";
		}
		else if(action_util == action_left)
		{
			s = "left";
		}
		else if(action_util == action_right)
		{
			s = "right";
		}
		
		return s;
	}
}
	
