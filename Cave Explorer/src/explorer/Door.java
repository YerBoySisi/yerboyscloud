package explorer;

public class Door {
	
	private boolean locked;
	private boolean open;
	private String description;
	private String details;
	
	public Door() {

		locked = false;
		open = true;
		description = "passage";
		details = "";
		
	}

	public void setLocked(boolean locked) {
		
		this.locked = locked;
		
	}

	public boolean isLocked() {
		
		return locked;
		
	}

	public void setOpen(boolean open) {
		
		this.open = open;
		
	}

	public boolean isOpen() {
		
		return open;
		
	}

	public void setDescription(String description) {
		
		this.description = description;
		
	}

	public String getDescription() {
		
		return description;
		
	}

	public void setDetails(String details) {
		
		this.details = details;
		
	}

	public String getDetails() {
		
		return details;
		
	}
	
	

}
