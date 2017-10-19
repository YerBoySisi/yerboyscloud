package entity.characteristics;

import entity.Thing;

public class Hobby extends Thing {
	
	public Hobby(String description) {
		
		super(description);
		
	}

	public static Hobby randomHobby() {
		
		Hobby[] hobbies = {new Hobby("Programming"), new Hobby("Gaming"),
						   new Hobby("Hunting"), new Hobby("Dancing"),
						   new Hobby("Singing"), new Hobby("Drawing")};
		
		return hobbies[(int)(Math.random() * hobbies.length)];
		
	}
	
}
