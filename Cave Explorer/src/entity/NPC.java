package entity;

public class NPC {
	
	private String inactiveDescription;
	private String activeDescription;
	private boolean active;
	private int currentRow;
	private int currentCol;

	public NPC() {
		
		
		
	}
	
	public void interact() {

		
		
	}

	public boolean isActive() {

		
		return false;
		
	}

	public String getInactiveDescription() {
		
		return inactiveDescription;
		
	}
	
	public String getActiveDescription() {
		
		return activeDescription;
		
	}
	
	public void act() {
		
		if(active) {
			int[] move = calculateMovement();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
		}
		
	}

	public int[] calculateMovement() {
		
		int[] move = new int[2];
		int[][] possibleMoves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int rand = (int)(Math.random() * 4);
		move[0] = possibleMoves[rand][0] + currentRow;
		move[1] = possibleMoves[rand][1] + currentCol;
		
		while() {
			
		}
		
		return null;
		
	}
	
}
