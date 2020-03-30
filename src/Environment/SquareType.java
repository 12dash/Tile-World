package Environment;

public enum SquareType {
	
	/*Enumerating all the possible types of squares that are present */
	white(" ", -0.04),green("+", +1),brown("-", -1),wall("wall", 0);
	
	private double reward; // This is the reward for the squares	
	
	private String display; // Used to display in the maze
	
	
	
	private SquareType(String disp, double reward) {
		/* constructor to initialize the object */
		this.display = disp;
		this.reward = reward;	
		
	}
	
	
	
	public String get_display()
	{
		/*To get the string representation */
		return this.display;
	}	
	
	public double get_reward()
	{
		/* To get the reward value from outside the */
		return this.reward;
	}
	
	
}

