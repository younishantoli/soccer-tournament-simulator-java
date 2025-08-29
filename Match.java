package groupprojectsoccer;

public class Match implements Simulatable{ //basically it'll use simulateMatch()
	private Team team1;
	private Team team2;
	private int score1;
	private int score2;
	private Player mvp;
	private Team winner;
	//^ characteristics of a match
	
	public Match(Team t1, Team t2) { 
		this.team1 = t1;
		this.team2 = t2;
	} //pass 2 team objects and store in a Match
	
	@Override
	public void simulateMatch() {
		score1 = (int) (Math.random() * 5);
		score2 = (int) (Math.random() * 5);
		//randomize scores (simulate)
		
		if(score1 == score2) {
			if(Math.random() > 0.5) score1++;
			else score2++;
		} //if tie, randomize winner
		
		winner = (score1 > score2) ? team1 : team2; //if score 1 > score 2, team1 wins; else, team 2
		winner.incrementWins(); //for the winner, increment their Wins
		
		//get random player from winning team and make them a candidate for MVP award
		Player mvpCandidate = winner.getRandomPlayer();
		mvp = (mvpCandidate != null && mvpCandidate.getSkill() >= 70) ? mvpCandidate:  winner.getPlayers().get(0);
		//^ if the candidate isn't empty and has a skill >= 70, then they're MVP; else, make the first player on the team the MVP
		
		
		printResult(); //print the Result! (call the function)
	}
	
	public void printResult() { //here it is ^^
		System.out.println("--- Match Result ---");
		System.out.println(team1.getName() + " " + score1 + " - " + score2 + " " + team2.getName());
		System.out.println("Winner: " + winner.getName());
		System.out.println("MVP: " + mvp);
	}
	
	public Team getWinner() { //getter for Winner
		return winner;
	}
}
