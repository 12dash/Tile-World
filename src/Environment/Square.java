package Environment;

public class Square {
	private double utility;
	private SquareType s;
	
	public Square(String s)
	{
		this.setS(SquareType.valueOf(s));
		this.utility = 0;
	}
	
	public static Square valueOf(String s)
	{
		return (new Square(s)); 
	}
	
	public double get_utility()
	{
		return this.utility;
	}
	
	public boolean set_utility(double utility)
	{
		this.utility = utility;
		return true;
	}

	public SquareType getS() {
		return s;
	}

	public void setS(SquareType s) {
		this.s = s;
	}
}
