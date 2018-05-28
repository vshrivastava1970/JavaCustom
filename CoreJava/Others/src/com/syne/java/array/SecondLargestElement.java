package com.syne.java.array;

import java.util.Arrays;

public class SecondLargestElement {

	public static void secondLargestElement(int[] inputArray) {
		int firstLargestNumber = inputArray[0];
		int secondLargetNumber = 0;
		
		for (int i = 1; i < inputArray.length; i++) {
			if(firstLargestNumber < inputArray[i]) {
				secondLargetNumber = firstLargestNumber;
				firstLargestNumber = inputArray[i];
			}else if(secondLargetNumber < inputArray[i]){
				secondLargetNumber = inputArray[i];
			}
		}
		 String array = Arrays.toString(inputArray);
		System.out.printf("\nSecond largest number in %s array is: %d", array,secondLargetNumber);
	}
	
	public static void main(String[] args) {
		int[] inputArray = {2, 4, 6, 8, 10, 12};
		secondLargestElement(inputArray);
		inputArray = new int[]{16, 41, 41, 9, 41, 7};
		secondLargestElement(inputArray);
		
		inputArray = new int[]{5, 3, 4, 1, 2};
		secondLargestElement(inputArray);
	}

}
