package explorer;

public class CaveRoom {
	
	//CONSTANTS
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	//FIELDS
	private String description; //tells you what the room looks like
	private String directions; //tells what you can do
	private String contents; //a symbol representing the contents of the room
	private String defaultContents;
	//the rooms are organized by direction
	//'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public CaveRoom(String description) {
		
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
		
	}
	
	/*
	 * For every door in doors[], appends a String to "directions"
	 * EXAMPLE:
	 * 	"There is a door to the north"
	 * 	
	 * If there are no doors at all, directions should say:
	 * 	"There are no doors, you are trapped in here"
	 */
	
	private void setDirections() {

		directions = "";
		
		boolean doorFound = false;
		
		for(int i = 0; i < doors.length; i++) {
			
			if(doors[i] != null) {
				doorFound = true;
				directions += "\n There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
			}
			
		}
		
		if(!doorFound) {
			
			directions += "There's no way out. You're trapped!";
			
		}
		
	}
	
	/*
	 * Converts an int to a direction
	 * EXAMPLE:
	 * 	toDirection(0) ---> "the North"
	 * @param dir
	 * @return
	 */
	
	public static String toDirection(int dir) {
		
		String[] directions = {"the North", "the East", "the South", "the West"};
		String noDirection = "somewhere";
		
		if(dir < 0 || dir > 3) {
			return noDirection;
		}
		
		return directions[dir];
		
	}
	
	public void enter() {
		
		contents = "X";
		
	}
	
	public void leave() {
		
		contents = defaultContents;
		
	}
	
	public void setConnection(int direction, CaveRoom otherRoom, Door door) {
		
		addRoom(direction, otherRoom, door);
		otherRoom.addRoom(oppositeDirection(direction), this, door);
		
	}

	public static int oppositeDirection(int direction) {
		
		return (direction + 2) % 4;
		
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {

		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
		
	}
	
	public void interpretInput(String input) {
		
		while(isValid(input)) {
			System.out.println("You can only enter 'W', 'A', 'S', or 'D'.");
			input = CaveExplorerMain.in.nextLine();
		}
		
		String inputs = "wdsa";
		goToRoom(directions.indexOf(input));
		
	}
	
	private boolean isValid(String input) {
		
		String validEntries = "wdsa";
		return (validEntries.indexOf(input) > -1 && input.length() == 1);
		
	}

	private void goToRoom(int direction) {
		
		if(borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorerMain.currentRoom.leave();
			CaveExplorerMain.currentRoom = borderingRooms[direction];
			CaveExplorerMain.currentRoom.enter();
			CaveExplorerMain.inventory.updateMap();
		}
		
	}
	
	/*
	 * This is where all caves and connections are set up
	 */
	
	public static void setUpCaves() {
		
		
		
	}

	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}

	public void setContents(String contents) {
		
		this.contents = contents;
		
	}

	public String getContents() {
		
		return contents;
		
	}

	public void setDefaultContents(String defaultContents) {
		
		this.defaultContents = defaultContents;
		
	}

}
