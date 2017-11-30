package main;

public class LionsPuzzle {

	public static void main(String[] args) {

		int lions = 101;
		System.out.println(lions + " lions decide to eat the sheep? " + eatSheepOrNot(lions));

	}
	
	private static boolean eatSheepOrNot(int lions) {
		
		if(lions == 1) {
			//There are no lions to eat you if you eat a sheep!
			return true;
		} else {
			//You would eat the sheep knowing that the other lions wouldn't eat the sheep
			return !eatSheepOrNot(lions - 1);
		}
		
	}

}
