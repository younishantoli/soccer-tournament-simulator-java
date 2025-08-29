package groupprojectsoccer;

/*
 * Describe 'Player' and has parameters.
 */
public class Player {
	//private attributes (encapsulation)
	private String name;
	private String position;
	private int skill; 
	
	//constructor for Player
	public Player(String name, String position, int skill) {
		this.name = name;
		this.position = position;
		this.skill = skill;
	}
	
	public String getName() { //getter for Name
		return name;
	}
	
	public String getPosition() { //getter for Position
		return position;
	}
	
	public int getSkill() { //getter for Skill
		return skill;
	}
	
	@Override
	public String toString() {
		return name + " (" + position + ") - Skill: " + skill;
	}
}
