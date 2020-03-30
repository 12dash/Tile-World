package Agent;

public class Action {
	/** The class is used to make objects of actions. It stores the type of action i.e. up, down, left, right. */
	
	/*The data variable to store the action type*/
	private ActionType action;
	
	public Action(){
		/*constructor to set the action type*/
		setAction(ActionType.up);
	}
	
	public void set_action(String s)
	{
		
		/*method to get the string representation of the action like "up"*/
		this.setAction(ActionType.valueOf(s));
	}

	public ActionType getAction() {
		/*getter method of action*/
		return action;
	}

	public void setAction(ActionType action) {
		/*setter method of action */
		this.action = action;
	}	

}
