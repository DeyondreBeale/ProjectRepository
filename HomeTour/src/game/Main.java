package game;

import java.util.Scanner;

//import fixtures.Fixture;
//import fixtures.Interactable;
import fixtures.Room;

public class Main {
	
	//called in Runner class to show user where they are
	public static void printRoom(Player player) {
		System.out.println("--- CURRENT ROOM ---\n");
		System.out.println("Name: " + player.getCurrentRoom().getName() + "\n");
		System.out.println("Short Desc: " + player.getCurrentRoom().getShortDesc() + "\n");
		System.out.println("Long Desc: " + player.getCurrentRoom().getLongDesc() + "\n");
	}
	
	//also called in Runner class, gets user input and splits it into an array based on the spacing
	public static String[] collectInput() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] phrase = input.split(" ");
		return phrase;
	}
	
	/*also also called in Runner class, uses the split words as an array 
	 * to get the meaning and use of the array
	 */
	public static void parse(String[] command, Player player) {
		//calls the first word and sets it to uppercase to a reference variable
		String action = command[0].toUpperCase().intern();
		//creates an empty reference variable for the second word
		String option = null;
		
		/*if the array has two or more words it will set the second word to uppercase
		 * and set it to a reference variable
		 */
		if (command.length > 1) {
			option = command[1].toUpperCase().intern();
		}
		
		/*if the first word is "go" or "move" it will show text to the user to show 
		 * where they are trying to go. 
		 * It will also set the new current room based on what the information was 
		 * received from the getExit()
		 */
		if (action == "GO" | action == "MOVE") {
			System.out.println("You are moving: " + option);
			Room move = player.getCurrentRoom().getExit(option);
			player.setCurrentRoom(move);
			
		}// else if (action == "INTERACT") {
			//for (Fixture i : player.getCurrentRoom().getItems()) {
			//	if (i.getName().equalsIgnoreCase(option) & (i instanceof Interactable))
			//		((Interactable) i).interact();
			//	}
		
			//if the first word is "quit" the game will end
			else if (action == "QUIT") {
				Runner.endGame();
		}
	}
}
