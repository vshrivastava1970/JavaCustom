package com.syne.fibonacci;

public class FibonacciTest {

	public FibonacciTest() {
			
	}

	private void printFibonacci(int fibonacciCount){
		if (fibonacciCount < 2){
			System.out.println("Please provide correct fibonacciCount to print");
		}
		
		int i = 0;
		int j = 1;
		
		int sum = 0;
		
		System.out.print("Fibonacci Series: "+ i +", "+ j);
		
		for (int m = 2; m < fibonacciCount; m++){
			sum = i+j;
			System.out.print(", "+sum);
			i =j;
			j =sum;
			
		}
		
	}
	
	public static void printFebonacciNumber(int num){
		if(num <= 0) { 
   			System.out.println("Enter correct number greater than 0");
			return;
		}
		
		int first =	0;
		int next =	1;
		int sum = 0;
		System.out.println("\n");
		System.out.print(first);
		System.out.print(", "+next);

		for( int i = 2; i < num; i++){
			sum = first + next; 
			System.out.print(", "+sum);
			first = next;
			next = sum;
		}
	}
	public static void main(String[] args) {
		FibonacciTest FibonacciTest = new FibonacciTest();
		FibonacciTest.printFibonacci(10);
		//printFebonacciNumber(10);
	}

}
