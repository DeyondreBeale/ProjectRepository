package fixtures;

public class Room extends Fixture {
	//creates a Room array of 5 to a reference variable
	private Room[] exits = new Room[5]; 
	
	//private Fixture[] items = new Fixture[3];

	//creates a custom super() to give information to the Fixture class
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		//this.exits = new Room[5]; 	
	}
	
	//returns what the exits is in the object
	public Room[] getExits() {
		return this.exits;
	}

	/*uses a switch statement to hard code a number of 
	 * what each direction means.
	 * 
	 * the method is called in the main class which figures out 
	 * what the "direction" will be
	 */
	public Room getExit(String direction) {
		int index = 0;
		direction = direction.toUpperCase();
		switch (direction) {
		case "NORTH":
			index = 0;
			break;
		case "SOUTH":
			index = 1;
			break;
		case "WEST":
			index = 2;
			break;
		case "EAST":
			index = 3;
			break;
		
		}
		/*will print the text if the index is greater than the exits array length
		 * or the exits index is empty
		 */
		if (index >= this.exits.length || this.exits[index] == null) {
			System.out.println("There is no room in that direction");
		}
		//returns the specified array object
		return this.exits[index];
	}

	//sets the exits of the current location
	public void setExits(Room[] exits) {
		this.exits = exits;
	}
	
	//sets the exit to the specified array object
	public void setExits(Room exit, int index) {
		this.exits[index] = exit;
	}
	
	//public Fixture[] getItems() {
	//	return items;
	//}
	
	//public void setItems(Fixture...items) {
	//	this.items = items;
	//}
	
}
