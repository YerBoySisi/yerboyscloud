package entity;

import entity.characteristics.Hobby;
import place.Borough;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "M", "L", "Gr", "Ph", "Th"};
	public static final String[] FIRST_MIDDLE = {"isti", "arc", "ance", "ace", "il", "eo"};
	public static final String[] FIRST_END = {"", "ne", "o", "e", "ip", "dore"};
	
	public static final String[] LAST_START = {"Sl", "M", "R", "Br", "L", "Th"};
	public static final String[] LAST_MIDDLE = {"ad", "as", "aken", "ance", "ancast", "eo"};
	public static final String[] LAST_END = {"er", "son", "berg", "mo", "or", ""};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private String nickname;
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough borough) {
		
		this.firstName = first;
		this.lastName = last;
		this.nickname = createNickname(firstName);
		this.home = borough;
		this.hobby = Hobby.randomHobby();
		this.friends = new Person[3];
		
	}
	
	public void mingle(Person[] people) {
		
		for(Person p: people) {
			
			if(p != this) {
				p = betterFriend(p, friends[0]); //reassign p to the better of the two friends
				addFriendToFirstPlace(p);
			}
			
		}
		
	}
	
	private Person betterFriend(Person p, Person q) {

		if(p == null) {
			return q;
		}
		
		if(q == null) {
			return p;
		}
		
		if(p.getClass() == this.getClass()) {
			
			if(q.getClass() == this.getClass()) {
				
				if(p.hobby == this.hobby) {
					return p;
				}
				
				if(q.hobby == this.hobby) {
					return q;
				}
				
				return p;
				
			}
			
			return p;
			
		}
		
		if(q.getClass() == this.getClass()) {
			return q;
		}
		
		return p; //If none of these are true, just take p
		
	}

	public void printFriends() {
		
		System.out.println("Hi, my name is " + firstName + " " + lastName + ". These are my friends: ");
		
		for(Person f:friends) {
			
			if(f != null) {
				System.out.println(f);
			}
			
		}
		
	}
	
	public void addFriendToFirstPlace(Person p) {
		
		for(int i = 0; i < friends.length - 1; i++) {
			
			friends[i + 1] = friends[i]; 
			
		}
		
		friends[0] = p;
		
	}
	
	public static String createNickname(String name) {
		
		boolean foundVowel = false;
		
		for(int i = 0; i < name.length(); i++) {
			
			if(isVowel(name.substring(i, i + 1))) {
				
				if(foundVowel) {
					return name.substring(0, i);
				}
				
				foundVowel = true;
			}
			
		}
		
		return name;
		
	}
	
	public static boolean isVowel(String letter) {
		
		if(letter.equals("a") || letter.equals("e") || letter.equals("i") ||
		   letter.equals("o") || letter.equals("u") || letter.equals("y")) {
			return true;
		}
		
		return false;
		
	}
	
	public String toString() {
		
		return "My name is " + firstName + " " + lastName + " and I live in " + home + 
				". You can call me " + nickname + ".";
		
	}
	
}
