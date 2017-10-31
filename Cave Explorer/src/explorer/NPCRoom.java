package explorer;

import entity.NPC;

public class NPCRoom extends CaveRoom {
	
	private NPC presentNPC;
	
	public NPCRoom(String description) {
		
		super(description);
		presentNPC = null;
		
	}
	
	/**
	 * NPCs can enter a room if no other NPC is in the room
	 * @return
	 */
	public boolean canEnter() {
		
		return presentNPC == null;
		
	}
	
	public void enterNPC(NPC m) {
		
		presentNPC = m;
		
	}
	
	public void leaveNPC() {
		
		presentNPC = null;
		
	}
	
	public boolean containsNPC() {
		
		return presentNPC != null;
		
	}
	
	//The methods above ADD to CaveRoom methods
	//The methods below OVERRIDE CaveRoom methods
	
	public String validKeys() {
		
		return "wdsae";
		
	}
	
	public void printAllowedEntry() {
		
		System.out.println("You can enter 'W', 'A', 'S', or 'D' to move, or 'E' to interact.");
		
	}
	
	public void performAction(int key) {
		
		if(key == 4) {
			
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			} else {
				CaveExplorerMain.print("Huh? No one's here.");
			}
			
		} else {
			CaveExplorerMain.print("Nothing happened.");
		}
		
	}
	
	public String getContents() {
		
		if(containsNPC() && !presentNPC.isActive()) {
			return "There is someone here.";
		} else {
			return super.getContents();
		}
		
	}
	
	public String getDescription() {
		
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n" + presentNPC.getInactiveDescription();
		} else {
			return super.getDescription();
		}
		
	}
	
}
