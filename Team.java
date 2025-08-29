package groupprojectsoccer;

import java.util.ArrayList;

public class Team extends Participant{ //extends Participant bc each team is a participant and it will inherit 'Participant' methods
	private ArrayList<Player> players; //holds roster
	private int wins = 0;
	
	public Team(String name) {
		super(name); //participant's name
		this.players = new ArrayList<>(); //create empty list to store 'Player' objects in for that team
	}
	
	//adds players to team (if team has < 10 Players
	public void addPlayer(Player p) {
		if(players.size() < 10) {
			players.add(p);
		}
	}
	
	//the Player objects in a list
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	//Average skill of the team
	public int getAverageSkill() {
		if(players.isEmpty()) return 0;
		int total = 0;
		for(Player p : players) {
			total += p.getSkill();
		}
		return (total / players.size());
	}
	
	//increase wins of the team by 1
	public void incrementWins() {
		wins++;
	}
	
	//getter for wins
	public int getWins() {
		return wins;
	}
	
	//Random player getter
	public Player getRandomPlayer() {
		if(players.isEmpty()) return null;
		int index = (int) (Math.random() * players.size()); //Math.random() get's a random value >= 0 & <= 1
		return players.get(index);
	}
	
	
	//Implementation of abstract method from participant
	@Override 
	public void printInfo() {
		System.out.println("Team: " + getName() + " | Players:");
		for(Player p : players) {
			System.out.println("- " + p);
		}
	}
}
