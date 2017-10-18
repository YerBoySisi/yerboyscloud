package entity;

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
	
	public Person(String first, String last, Borough borough) {
		
		firstName = first;
		lastName = last;
		home = borough;
		
	}
	
	public String toString() {
		
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ".";
		
	}
	
}
