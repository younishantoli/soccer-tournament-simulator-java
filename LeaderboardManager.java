package groupprojectsoccer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * keeps a global leaderboard in a txt file
 * uses two arraylists
 */

public class LeaderboardManager {
	private static final String FILE_NAME = "leaderboard.txt"; //keyword represents leaderboard.txt
	
	private static ArrayList<String> teamNames = new ArrayList<>();
	private static ArrayList<Integer> winCounts = new ArrayList<>();
	
	public static void loadLeaderboard() {
		teamNames.clear();
		winCounts.clear();
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) { //read through file
			String line;
			while((line = br.readLine()) != null) { //while it has next lines
				String[] parts = line.split("="); //tokenization
				
				if(parts.length == 2) { //if it has 2 parts (name and wins), cut them
					teamNames.add(parts[0].trim());
					winCounts.add(Integer.parseInt(parts[1].trim()));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No leaderboard file found. Will create one after the first tournament.");
		} catch (IOException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
	}
	
	//increment win for a certain team
	public static void updateLeaderboard(String winnerTeamName) {
		loadLeaderboard(); //start from latest file
		boolean teamFound = false;
		
		for(int i = 0; i < teamNames.size(); i++) {
			if(teamNames.get(i).equalsIgnoreCase(winnerTeamName)) {
				int updatedWins = winCounts.get(i) + 1;
				winCounts.set(i, updatedWins);
				teamFound = true;
				break;
			}
		}
		
		if(!teamFound) {
			teamNames.add(winnerTeamName);
			winCounts.add(1);
		}
		
		saveLeaderboard();
	}
	
	//save current list to file, and sort by wins
	public static void saveLeaderboard() {
		
		//create an index for sorting purposes
		ArrayList<Integer> indices = new ArrayList<>();
		for(int i = 0; i < teamNames.size(); i++) {
			indices.add(i);
		}
		
		//sort indices by winCounts; descending.
		indices.sort((a, b) -> winCounts.get(b) - winCounts.get(a));
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) { //add to file (BufferedWriter)
			for(int index : indices) {
				bw.write(teamNames.get(index) + "=" + winCounts.get(index));
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error saving leaderboard file.");
			e.printStackTrace();
		}
	}
	
	public static void printLeaderboard() {
		loadLeaderboard();
		
		if(teamNames.isEmpty()) { //if it is empty
			System.out.println("Leaderboard is empty.");
			return;
		}
		
		System.out.println("==========GLOBAL LEADERBOARD=========="); //else print leaderboard
		for(int i = 0; i < teamNames.size(); i++) {
			System.out.println(teamNames.get(i) + " - " + winCounts.get(i) + " wins");
		}
	}
}
