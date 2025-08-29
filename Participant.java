package groupprojectsoccer;
/*
 * use of Abstraction and Inheritance
 * (Participant is an ABSTRACT idea)
 */

public abstract class Participant {
	private String name;
	
	public Participant(String name) {
		this.name = name;
	}
	
	public String getName() { //getter for participant name
		return name;
	}
	
	
	//a method we expect to be overridden and used
	public abstract void printInfo();
}
