package arrays2d;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] test1 = {1, 2, 3};
		int[] test2 = {1, 2};
		int[] test3 = {2, 3};
		int[] test4 = {1};
		
		changeNeighbors(test1, 1);
		changeNeighbors(test2, 0);
		changeNeighbors(test3, 1);
		changeNeighbors(test4, 0);
		
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(test2));
		System.out.println(Arrays.toString(test3));
		System.out.println(Arrays.toString(test4));

	}
	
	public static void changeNeighbors(int[] arr, int psn) {
		
		arr[psn] += 1;
		
		if(arr.length > 1) {
		
			if(psn == 0) {
				arr[psn + 1] -= 1;
			} else if(psn == arr.length - 1) {
				arr[psn - 1] -= 1;
			} else {
				arr[psn - 1] -= 1;
				arr[psn + 1] -= 1;
			}
			
		}
		
	}

}
