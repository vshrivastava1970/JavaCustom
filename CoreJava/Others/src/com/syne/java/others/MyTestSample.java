package com.syne.java.others;
import java.util.ArrayList;
import java.util.List;

public class MyTestSample {
	
	
	public static void reverse_a_number(int number) {
		System.out.println("Reverse a Number::"+ number);
		
		int reverse = 0;
		
		while(number !=0 ) {
			
			reverse = (reverse*10) + (number%10);
			number = number/10;
		}
		
		System.out.println("Reversed Number="+reverse);
	}
	
	public static void commonElementbetweenTwoArray() {
		System.out.println("Common Element Between Two Array::");
		int[] arr1 = {4,7,3,9,2};
		int[] arr2 = {3,2,12,9,40,32,4};

		for(int i=0;i<arr1.length;i++){
			for(int j=0;j<arr2.length;j++){
				if(arr1[i] == arr2[j]) {
					System.out.println(arr1[i]);break;
				}
			}
		}
	}
	
	public static void swapWithoutUsingTemporaryVariable(int num1, int num2) {
	
		System.out.printf("Before swap:: num1=%d and num2=%d", num1, num2);
		
		/*num1 = num1+num2;
		num2 = num1 - num2;
		num1 = num1 - num2;*/
	
		num1 = num1*num2;
		num2 = num1 / num2;
		num1 = num1 / num2;
		
		System.out.printf("\nAfter  swap:: num1=%d and num2=%d\n", num1, num2);
	}

	public static void duplicateNumberBetween1toN(List<Integer> numbers) {
		int sum = 0;
		for (int num:numbers) {
			sum+= num;
		}
		
		int highestNum = numbers.size() -1;
		System.out.println("highestNum="+highestNum);
		int tempSum =  highestNum*(highestNum -1)/2;
		
		int duplicate = sum - tempSum;
		System.out.println("Duplicate = "+duplicate);
	}
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList();
		for(int i=0;i<30;i++){
			numbers.add(i);
		}
		numbers.add(1);
		
		duplicateNumberBetween1toN(numbers);

		swapWithoutUsingTemporaryVariable(1, 3);
		
		commonElementbetweenTwoArray();
		
		reverse_a_number(157883);
	}

}
