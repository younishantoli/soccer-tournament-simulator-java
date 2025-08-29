package groupprojectsoccer;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * User Interface and basically connects everything; as a Main function basically does
 */

public class Main {
	private static ArrayList<Team> teams = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;
		
		do {
			displayMenu();
			choice = getIntInput("Enter your choice: ");
			
			switch(choice) {
			case 1: addTeam(); break;
			case 2: addPlayerToTeam(); break;
			case 3: startTournament(); break;
			case 4: LeaderboardManager.printLeaderboard(); break;
			case 5: System.out.println("Exiting...."); System.exit(0);
			default: System.out.println("Invalid choice; try again!");
			}
			
		} while (choice != 5); //bc if 5, then exit so don't want to displaymenu or any of that
		
		scan.close();
	}
	
	private static void displayMenu() {
		System.out.println("==========SOCCER SIMULATOR MENU==========");
		System.out.println("1. Add a team");
		System.out.println("2. Add a Player to a Team");
		System.out.println("3. Start Tournament");
		System.out.println("4. View Leaderboard");
		System.out.println("5. Exit");
		System.out.println("=========================================");
	}
	
	private static void addTeam() {
		System.out.println("Enter team name: ");
		String name = scan.nextLine();
		
		for(Team team : teams) {
			if(team.getName().equalsIgnoreCase(name)) {
				System.out.println("Team already exists...");
				return;
			}
		}
		
		Team newTeam = new Team(name);
		teams.add(newTeam);
		System.out.println("Team added: " + name);
	}
	
	private static void addPlayerToTeam() {
		if(teams.isEmpty()) {
			System.out.println("No teams available. Add a team first.");
			return;
		}
		
		System.out.println("Enter team name: ");
		String teamName = scan.nextLine();
		Team selectedTeam = null;
		
		for(Team team : teams) {
			if(team.getName().equalsIgnoreCase(teamName)) {
				selectedTeam = team;
				break;
			}
		}
		
		if(selectedTeam == null) {
			System.out.println("Team not found.");
			return;
		}
		
		if(selectedTeam.getPlayers().size() >= 5) {
			System.out.println("Team already has 5 players.");
			return;
		}
		
		System.out.println("Enter player name: ");
		String playerName = scan.nextLine();
		
		System.out.println("Enter player position: ");
		String position = scan.nextLine();
		
		int skill = getIntInput("Enter Skill Level (1-100): ");
		if(skill < 1 || skill > 100) {
			System.out.println("Invalid skill value.");
			return;
		}
		
		Player player = new Player(playerName, position, skill);
		selectedTeam.addPlayer(player);
	}
	
	private static void startTournament() {
		if(teams.size() < 2) {
			System.out.println("Need atleast 2 teams to start a tournament.");
			return;
		}
		
		for(Team t : teams) {
			if(t.getPlayers().isEmpty()) {
				System.out.println("Team '" + t.getName() + "' has no players. Add players first.");
				return;
			}
		}
		
		Tournament tournament = new Tournament(new ArrayList<>(teams));
		Team champion = tournament.startTournament();
		
		LeaderboardManager.updateLeaderboard(champion.getName());
		System.out.println("Leaderboard updated for champion: " + champion.getName());
	}
	
	private static int getIntInput(String prompt) {
		while(true) {
			try {
				System.out.println(prompt);
				String line = scan.nextLine().trim();
				return Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

}
