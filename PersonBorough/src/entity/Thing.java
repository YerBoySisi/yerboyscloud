package entity;

public class Thing {
	
	private String description;
	
	public Thing(String description) {
		
		this.description = description;
		
	}
	
	public String toString() {
		
		return "I am just a " + description + ". An inanimate object. The fact that we're talking right now? I think you're crazy...";
		
	}
	
}
