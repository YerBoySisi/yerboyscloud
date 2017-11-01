package array;

import java.util.Arrays;

public class ArraysMain {
	
	private int[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		
		intRay = new int[100];
		populate1ToN(intRay);
		shuffle(intRay);
		
		System.out.println(Arrays.toString(intRay));
		
	}

	public static void main(String[] args) {
		
		ArraysMain arrayPractice = new ArraysMain();

	}
	
	private void populate(int[] arr) {

		for(int i = 0; i < arr.length; i++) {
			arr[i] = diceRoll(3);
		}
		
	}
	
	private void populate1ToN(int[] arr) {

		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = i + 1;
			
		}
		
	}
	
	private void swap(int[] arr, int x, int y) {
		
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		
		
	}
	
	private void shuffle(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			
			int a = (int)(Math.random() * arr.length);
			int b = (int)(Math.random() * arr.length);
			
			while(a == b) {
				a = (int)(Math.random() * arr.length);
				b = (int)(Math.random() * arr.length);
			}
			
			swap(arr, a, b);
		}
		
	}
	
	private void checkOccurences(int[] arr, int start, int end) {

		int[] counter = new int[end - start + 1];
		
		for(int value: arr) {
			counter[value - start]++;
		}
		
		for(int i = 0; i < counter.length; i++) {
			System.out.println("A " + (start + i) + " was rolled " + counter[i] + " times.");
		}
		
	}
	
	public static int diceRoll(int numDice) {
		
		int result = 0;
		
		for(int i = 0; i < numDice; i++) {
			result += (int)(Math.random() * 6 + 1); 
		}
		
		return result;
		
	}
	
	public void notes() {
		
		//There are two types of constructors
				//1
				int[] firstType = {3, 14, -9, 10}; //can only be used at the declaration
				// ERROR: firstType = {12, 13, 14, 15};
				
				//2
				testArray = new int[50]; //creates array with number of elements
				//When primitive arrays are instantiated, they are automatically populated
				//with 0s. This is not the case with object arrays, which are populated with
				//'null'.
				
				//Standard 'for' loop
				for(int i = 0; i < testArray.length; i++) {
					System.out.println("Item #" + i + " is " + testArray[i]);
				}
				
				//'for each' loop (useful only when you don't need to keep track of an index)
				for(int value:testArray) {
					//"for each int in testArray..."
					System.out.println(value);
				}
		
	}

}
