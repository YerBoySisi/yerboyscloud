package nature;

import traits.Trait;

public class RoamingAnimal extends Animal {
	
	protected Habitat habitat;
	private boolean sex;
	
	public RoamingAnimal(Habitat matingArea) {
		
		super();
		this.habitat = matingArea;
		sex = Math.random() > .5;
		
	}
	
	public RoamingAnimal(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		
		super (description, trait1, trait2);
		this.habitat = matingArea;
		sex = Math.random() > .5;
		
	}
	
	public static void main(String[] args) {
		
		int capacity = 6;
		Habitat h = new Habitat(capacity);
		
		for(int i = 0; i < capacity; i++) {
			
		}
		
	}
	
}

/*
1. What is the point of a mate() method at line 43 if the method just prints "does not have a mating ritual"?
 *
2. In line 31, why is it necessary to check whether a is null? When would a ever be null?
 *
3. There is no boolean instance variable "living" to keep track of whether an animal is alive or dead. In lines 50 and 55, animals do die. How does the program "keep track" of which animals are alive and which animals are dead?
 *
4. Under what circumstances would an animal ever die of starvation? Can you explain how the method at line 64 works?
 * 
*/