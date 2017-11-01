package arrays;

public class TwoDArrayPractice {

	public static void main(String[] args) {

		String[][] pic = new String[7][11];
		
		for(int row = 0; row < pic.length; row++) {
			
			for(int col = 0; col < pic[row].length; col++) {
				pic[row][col] = "X";
			}
			
		}
		
		drawHorizontalLine(pic, 1);
		drawHorizontalLine(pic, 3);
		drawHorizontalLine(pic, 5);
		drawVerticalLine(pic, 1);
		drawVerticalLine(pic, 3);
		drawVerticalLine(pic, 5);
		drawVerticalLine(pic, 7);
		drawVerticalLine(pic, 9);
		printSlot(pic, 1, 1);
		printBox(pic, 4, 5);
		print(pic);

	}

	private static void print(String[][] pic) {
		
		for(int row = 0; row < pic.length; row++) {
			
			for(int col = 0; col < pic[row].length; col++) {
				System.out.print(pic[row][col] + " ");
			}
			
			System.out.println();
			
		}
		
	}
	
	private static void drawHorizontalLine(String[][] pic, int row) {

		for(int col = 0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}
		
	}

	private static void drawVerticalLine(String[][] pic, int col) {

		for(int row = 0; row < pic.length; row++) {
			pic[row][col] = "|";
		}
		
	}
	
	/*
	 * A slot looks like this:
	 * 		| |
	 * It is two vertical lines with a space between them
	 * The coordinates (x,y) are the coordinates of the space
	 * In other words, a slot is a vertical line in front of (x,y) and after (x,y)
	 * @param pic
	 * @param x
	 * @param y
	 */
	
	private static void printSlot(String[][] pic, int y, int x) {
		
		if(x > 0 && x < pic[y].length && y >= 0 && y < pic.length) {
			drawSlot(pic, y, x);
		}
		
	}
	
	private static void drawSlot(String[][] pic, int y, int x) {
		
		pic[y][x - 1] = "|";
		pic[y][x] = " ";
		pic[y][x + 1] = "|";
		
	}
	
	/*
	 * A box looks like this:
	 * 		 _
	 * 		|*|
	 * 		|_|
	 * The * marks the coordinates of the box
	 * Draw any portion of the box that fits at the coordinates
	 * @param pic
	 * @param x
	 * @param y
	 */
	
	private static void printBox(String[][] pic, int y, int x) {
		
		if(x > 0 && x < pic[y].length && y >= 0 && y < pic.length) {
			drawBox(pic, y, x);
		}
		
	}
	
	private static void drawBox(String[][] pic, int y, int x) {
		
		drawSlot(pic, y, x);
		drawSlot(pic, y + 1, x);
		drawIfInBounds("_", pic, y + 1, x);
		drawIfInBounds("_", pic, y - 1, x);
		
	}

	private static void drawIfInBounds(String string, String[][] pic, int y, int x) {

		if(y >= 0 && y < pic.length && x > 0 && x < pic[y].length) {
			pic[y][x] = string;
		}
		
	}

}
