package Agent;

public enum Transition {
	/*Enumerate class to store the transition model.*/
	intended(0.8),intendedLeft(0.1),intendedRight(0.1);
	//Enumerating all the possible transition state
	
	//Class variable to store the probability of the actions in the transition model
	private double probability;
	
	Transition(double p){
		//Constructor for the class
		this.probability = p;
	}
	
	public double get_prob() {
		//Getter method to get the probability 
		return this.probability;
	}
}
