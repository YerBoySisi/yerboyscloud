package main;

public class ArtificialForLoop {
	
	public static void main(String[] args) {
		
		forLoop(24000, new Action() {
			
			int count = 1;
			
			public void act() {
				
				System.out.println(count + ". Hello World!");
				count++;
				
			}
		});

	}

	private static void forLoop(int i, Action a) {

		if(i > 0) {
			a.act();
			forLoop(i - 1, a);
		}
		
	}
	
}
