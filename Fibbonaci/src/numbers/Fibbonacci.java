package numbers;

public class Fibbonacci {
	
	private static int num = 100;
	
	public static void main(String[] args) {
		
		System.out.println("The " + num + " Fibbonacci number is " + getFibbonacciNumber(num));
		
	}

	private static int getFibbonacciNumber(int n) {
		
		if(n < 0) {
			return -1;
		} else {
		
			if(n == 0 || n == 1) {
				return 1;
			} else {
				return getFibbonacciNumber(n - 2) + getFibbonacciNumber(n - 1);
			}
		
		}
		
	}
	
}
