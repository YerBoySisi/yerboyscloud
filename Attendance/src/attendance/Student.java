package attendance;

public class Student implements Attendee {
	
	private String firstName;
	private String lastName;
	boolean present = false;
	
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
		
		return (this.firstName == first && this.lastName == last);
		
	}

	public boolean matches(String last) {
		
		return (this.lastName == last);
		
	}

	public String getReportString() {
		
		if(firstName.length() > 20) {
			
		}

		if(lastName.length() > 20) {
			
		}
		
		return null;
		
	}

}
