package entity;

import place.Borough;

public class Student extends Person {
	
	public static final String[] classes = {"Freshman", "Sophomore", "Junior",
											"Senior", "Super Senior"};
	private String grade;
	
	public Student(String first, String last, Borough borough, int gradeLevel) {
		
		super(first, last, borough); //super constructor is first because a Person must exist before a Student
		int idx = gradeLevel - 9;
		grade = classes[idx];
		
	}
	
	public String toString() {
		
		//To call the parent method, use super.
		return super.toString() + " I am also a " + grade + "."; 
		
	}
	
}
