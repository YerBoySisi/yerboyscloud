package nature;

public class Environment {
	
	private int plants;
	private int growthRate;
	
	public static void main(String[] args) {
		
		Environment farm = new Environment(10);
		System.out.println(farm);
		farm.growPlants();
		
	}
	
	public Environment(int plants) {
		
		this.plants = plants;
		this.growthRate = plants / 2;
		
	}
	
	public void growPlants() {
		
		plants += growthRate;
		System.out.println("\n There are "+plants+" plants.");
		
	}
	
	public boolean eatPlants() {
		
		if(plants > 0) {
			plants--;
			return true;
		}
		
		return false;
		
	}
	
	public String toString() {
		
		return "A vast field";
		
	}
	
}

/*1. In line 67, what determines how the farm is represented when it is printed?
 *Whatever is returned in the toString method 
2. In line 82, when does eatPlants return true? What do you think this method was designed to do?
 *It returns true when there is at least 1 plant on the field
 *It was meant to check if plant were still on the field, and remove one if there are
3. Could any part of the code be improved?
 *Rename "eatPlants" to a more intuitive name.
*/
