package arrays;

import entity.Person;
import entity.Student;
import entity.Thing;
import place.Borough;

public class ObjectArrays {
	
	public ObjectArrays() {
		
		Object[] people = new Object[20];
		populate(people);
		people[0] = new Thing("wall");
		
		for(Object p: people) {
			System.out.println(p);
		}
		
	}

	private void populate(Object[] people) {

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
	
}
