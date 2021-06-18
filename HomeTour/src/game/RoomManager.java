package game;

//import fixtures.Bookshelf;
import fixtures.Room;

public class RoomManager {
	//creates a Room reference variable for this class
	private Room startingRoom;
	//creates a Room array reference variable for this class
	private Room[] rooms;
	
	//sets how big the array is going to be from Runner class
	public RoomManager(int roomCount) {
		rooms = new Room[roomCount];
	}
	
	//this is what is called first in the runner method
	public void init() {
		
		/*creates objects of the rooms, sets what they are in the array
		 * and sets what their names, short descriptions, and long descriptions are
		 * for the Room class
		 */
		Room room1 = new Room(
				"Food Stand",
				"A stand full of different kinds of foods",
				"A regular old stand with a ton of menus for the different kinds of foods."
				+ "\nThe food is stylish and delicious worth every penny. They have foods like funnel cake, "
				+ "\ncrumpets, macaroons, turkey legs, etc. The people are enjoying the food while sitting under"
				+ "\ncolor coded umbrellas with tables that fit the theme of the food stand.");
		this.rooms[0] = room1;
		
		Room room2 = new Room(
				"Ferris Wheel",
				"A ride that takes you higher in the sky",
				"The place where people scared of heights fear to go, but still can have fun. However, for the people who are fearless, enjoy the lovely"
				+ "\nscenery with the peacefull tune that feels like a brand new day. The scenery is filled with the view of the ocean, sunset, and "
				+ "\na little bit of civilization. At night, the view is filled with the brightest, fullest moon ever seen. A perfect place"
				+ "\nto go on dates and enjoy one another's company. ");
		this.rooms[1] = room2;
		
		Room room3 = new Room(
				"Castle",
				"Tall and sturdy towers",
				"A place suitable only fit for a princess or prince. There are tons of trinkets, decorations, and places "
				+ "\nnot many people know what are even used for. The castle is baby blue with touches of dark blue to show a modern look."
				+ "\nThe castle is lined with a crystal clear river around the base, with a wide bridge connecting to the carnival.");
		this.rooms[2] = room3;
		
		Room room4 = new Room(
				"Roundabout",
				"Horses moving in circles",
				"A very catchy musical ride with horses bobbing up and down. There are people of all ages enjoying the ride."
				+ "\nWith cries of laughter of children having a blast, to the parents taking pictures and enjoying every moment with their children."
				+ "\nEven adults are riding the chill and relaxing ride.");
		this.rooms[3] = room4;
		
		Room room5 = new Room(
				"Carnival Gate",
				"A tall and opened gate",
				"A gate with two giant, bricked pillars decorated with all sorts of festive decorations."
				+ "\nThe pillars loom over all the customers going in and out. There is no wall, just a giant gate in the "
				+ "\nmiddle of the pathway to the carnival.");
		this.rooms[4] = room5;
		
		//sets the starting room to be the first room
			this.startingRoom = room1;

		/*sets where the player can go
		 * 
		 * room#.setExits is the location the player is,
		 * then the exits are the locations of the next places "room#",
		 * finally the #'s on the end are the hard coded index's of the 
		 * directions, "north", "south", "west", "east"
		 */
		room1.setExits(room5, 3);
		room1.setExits(room2, 0);
		
		room2.setExits(room1, 1);
		room2.setExits(room3, 3);
		
		room3.setExits(room2, 2);
		room3.setExits(room4, 1);
		
		room4.setExits(room3, 0);
		room4.setExits(room1, 2);
		
		room5.setExits(room1, 2);
		room5.setExits(room4, 3);

		//room1.setItems(new Bookshelf("Book", "A plain old BookShelf", null));
}
	
	
	//public Room getRoom(int index) {
	//	return rooms[index];
	//}
	
//	public Room getRoom(String roomName) {
	//	for (int i = 0; i < rooms.length;) {
	//		if (roomName.toUpperCase() == rooms[i].getName().toUpperCase()) {
	//			return getRoom(i);
	//		}
	//		return startingRoom;
	//	}
	//	return startingRoom;
	//}
	
	//gets the starting room in the object
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	//sets the new starting room, where the player is, location
	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
	
	//gets the rooms array in the current object
	public Room[] getRooms() {
		return this.rooms;
	}
	
	//sets the new rooms array in the current object
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
}
	
