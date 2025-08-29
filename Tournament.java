package groupprojectsoccer;

import java.util.ArrayList;
import java.util.Collections;

public class Tournament {
	private ArrayList<Team> teams;
	
	public Tournament(ArrayList<Team> teams) { //constructor (takes list of all active teams in this tournament
		this.teams = teams;
	}
	
	public Team startTournament() {
		System.out.println("===========TOURNAMENT START===========");
		
		Collections.shuffle(teams); //function to shuffle collection (random bracket)
		
		int round = 1; //initialize round to 1 (beginning round)
		
		while(teams.size() > 1) { //while there's more than 1 team in the tournament
			System.out.println("-----ROUND " + round + "-----"); 
			ArrayList<Team> winners = new ArrayList<>(); //makes a new list of all the winners of each round
			
			for(int i = 0; i < teams.size(); i+= 2) { //takes 2 teams at a time
				if(i + 1 >= teams.size()) { //if odd number of teams, last team auto-advances
					System.out.println(teams.get(i).getName() + " ADVANCES TO THE NEXT ROUND!");
					winners.add(teams.get(i));
					continue;
				}
				
				Team t1 = teams.get(i); //get the teams in index 'i'
				Team t2 = teams.get(i + 1); //^^
				
				Match match = new Match(t1, t2); //create new 'Match'
				match.simulateMatch(); //sim the match between them
				winners.add(match.getWinner()); //get winner and add to 'winners'
			}
			
			teams = winners; //next round is only the winners
			round++; //next round
		}
		
		Team champion = teams.get(0); //number 1 spot (index starts at 0)
		System.out.println("=========CHAMPION: " + champion.getName() + "=========");
		return champion;
	}
}