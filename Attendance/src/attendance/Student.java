package attendance;



public class Student implements Attendee {
	
	private String firstName;
	private String lastName;
	boolean present = false;
	
	Student(String first, String last) {
		
		firstName = first;
		lastName = last;
		
	}
	
	public boolean isPresent() {

		return present;
		
	}

	public void setPresent(boolean present) {
		
		if(!present) {
			present = true;
		} else {
			present = false;
		}
		
	}

	public String getFirstName() {

		return firstName;
		
	}

	public String getLastName() {

		return lastName;
		
	}

	public boolean matches(String first, String last) {
		
		return (firstName.equalsIgnoreCase(first) && lastName.equalsIgnoreCase(last));
		
	}

	public boolean matches(String last) {
		
		return (lastName.equalsIgnoreCase(last));
		
	}

	public String getReportString() {
		
		String status;
		
		if(firstName.length() > 20) {
			firstName = firstName.substring(0, 17);
			firstName += "...";
		}

		if(lastName.length() > 20) {
			lastName = lastName.substring(0, 17);
			lastName += "...";
		}
		
		if(present) {
			status = "PRESENT";
		} else {
			status = "ABSENT";
		}
		
		return firstName + "                   " + lastName + "                   " + status;
		
	}

}
