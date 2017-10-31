package explorer;

import entity.NPC;

public class NPCRoom extends CaveRoom {
	
	private NPC presentNPC;
	
	public NPCRoom(String description) {
		
		super(description);
		presentNPC = null;
		
	}
	
	/*
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
	
}
