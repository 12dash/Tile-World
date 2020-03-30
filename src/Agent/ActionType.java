package Agent;

public enum ActionType {
	/**Class to enumerate all the types of action */
	
	/* Enumerating all the types of action */
	up("^"),down("v"),left("<"),right(">");
	
	/*Class variable to store the string representation of the action*/
	private String sign;
	
	private ActionType(String sign)
	{
		/**To return the type of action in the form of string */
		this.sign = sign;
	}
	
	public String get_display()
	{
		/**To display the string representation of the action */
		return this.sign;
	}
	
}
