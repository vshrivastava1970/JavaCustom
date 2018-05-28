package com.syne.java.others;

public class PerfectNumber {
	
	public static boolean isPerfectNumber(int num) {
		int sum =0;
		int loopCount = num/2;
		for (int i = 1; i <= loopCount; i++) {
			if(num%i == 0) {
				sum += i;
			}
		}
		if(sum == num) {
			System.out.printf("Perfect Number %d", num);
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		int num = 28;
		System.out.println("\nNumber "+num+" is a perfect number? : "+isPerfectNumber(num));
	}

}
