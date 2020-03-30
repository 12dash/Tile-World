package Environment;
import Environment.Square;
public class Maze {
	
	public Square maze[][];// Returns a maze object
	
	public int m;//number of rows
	public int n; //number of columns
	
	public Maze(int m, int n)
	{ /* Constructor for the class which initializes the maze environment*/
		maze = new Square[m][n];
		this.m = m;
		this.n = n;
		for(int i =0;i<m;i++)
		{
			for(int j = 0;j<n;j++)
			{
				set_square("wall",i,j);
			}
			
		}
	}
	
	protected void set_square(String name,int m, int n)
	{
		/* Set the square type*/
		Square temp = Square.valueOf(name);
		maze[m][n] = temp;
	}
	
	public void display_maze_symbolic()
	{
		/* Displays the maze */
		System.out.println("The Maze Symbolic : ");
		System.out.println(" _______________________________________________________________________________________________");
		for(int i=0; i<this.m ; i++)
		{
			System.out.print("|");
			for(int j=0; j<this.n; j++)
			{
				System.out.print("\t"+(maze[i][j].getS()).get_display()+"\t|");				
			}
			System.out.println("");
			System.out.println(" _______________________________________________________________________________________________");
		}
	}
	public void display_maze_utility()
	{
		/* Displays the maze */
		System.out.println("The Maze with Utility : ");
		System.out.println(" _______________________________________________________________________________________________");
		for(int i=0; i<this.m ; i++)
		{
			System.out.print("|");
			for(int j=0; j<this.n; j++)
			{
				if (maze[i][j].getS()!=SquareType.wall)
					System.out.print(String.format("\t%.3f",(maze[i][j]).get_utility())+"\t|");	
				else
					System.out.print("\t"+(maze[i][j].getS()).get_display()+"\t|");	
			}
			System.out.println("");
			System.out.println(" _______________________________________________________________________________________________");
		}
	}
	
}
