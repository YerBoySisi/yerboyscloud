package arrays;

import java.util.Arrays;

import entity.Person;
import entity.Student;
import entity.Thing;
import place.Borough;

public class ObjectArrays {
	
	public ObjectArrays() {
		
		Person[] people = new Person[20];
		populate(people);
		
		for(Person p:people) {
			p.mingle(people);
			p.printFriends();
			System.out.println("");
		}
		
	}

	private void populate(Person[] people) {

		for(int i = 0; i < people.length; i++) {
			
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			
			//In Object arrays, you can have multiple data types (specifically
			//subclasses of the declared type).
			if(Math.random() < .6) {
				int grade = (int)(Math.random() * 5) + 9;
				people[i] = new Student(firstName, lastName, b, grade);
			} else {
				people[i] = new Person(firstName, lastName, b);
			}
			
		}
		
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		
		return get(a) + get(b) + get(c);
		
	}

	private String get(String[] n) {
		
		return n[(int)(Math.random() * n.length)];
		
	}
	
	private Borough randomBorough() {
		
		return Borough.NY_BOROUGHS[(int)(Math.random() * Borough.NY_BOROUGHS.length)];
		
	}
	
	public int countDifferences(Person[] arr1, Person[] arr2) {
		
		int differences = 0;
		
		for(int i = 0; i < arr1.length; i++) {
				
			if(arr1[i] != arr2[i]) {
				differences++;
			}
				
		}
		
		return differences;
		
	}
	
	public void testShuffling(Person[] arr1, Person[] arr2) {
		
		if(countDifferences(arr1, arr2) == 0) {
			
			int a = 0;
			int b = 1;
			int c = 2;
			int sum = 0;
			
			for(int i = 0; i < 100; i++) {
				
				while(a == c || a == b || b == c) {
					a = (int)(Math.random() * 3);
					b = (int)(Math.random() * 3);
					c = (int)(Math.random() * 3);
				}
				
				arr1[0] = arr1[a];
				arr1[1] = arr1[b];
				arr1[2] = arr1[c];
				
				while(a == c || a == b || b == c) {
					a = (int)(Math.random() * 3);
					b = (int)(Math.random() * 3);
					c = (int)(Math.random() * 3);
				}
				
				arr2[0] = arr1[a];
				arr2[1] = arr1[b];
				arr2[2] = arr1[c];
				
				sum += countDifferences(arr1, arr2);
				
			}
			
			System.out.println("The average difference is " + sum/100);
			
		}
		
	}
	
	public Person[] selectGroup(Person[] people, int length) {
		
		int rand = (int)(Math.random() * people.length);
		Person[] subgroup = new Person[length];
		
		for(int i = 0; i < subgroup.length; i++) {
			
			while(personInGroup(people[rand], subgroup)) {
				
				rand = (int)(Math.random() * people.length);
				
			}
			
			subgroup[i] = people[rand];
			
		}
		
		return subgroup;
		
	}

	public static boolean personInGroup(Person p, Person[] group) {
		
		for(int i = 0; i < group.length; i++) {
			
			if(group[i] == p) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	private Person selectAPerson(Person[] population) {
		
		return null;
		
	}
	
}
