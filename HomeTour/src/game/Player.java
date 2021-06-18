package game;

import fixtures.Room;

public class Player {

	//creates a Room variable private of this class
	private Room currentRoom;
	
	//method that gets where the player is
	public Room getCurrentRoom() {
		return currentRoom;
	}

	//method that sets a new location of where the player is
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
}
