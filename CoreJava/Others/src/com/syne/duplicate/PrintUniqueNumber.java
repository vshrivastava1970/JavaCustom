package com.syne.duplicate;

public class PrintUniqueNumber {

	private final int[] intArray = {1,2,2,3,3,3,4,6,7,9,5,5,8};
	
	public PrintUniqueNumber() {
		
		this.print(this.intArray);
	}

	public void print(int[] intArray2) {
		
		for (int i = 0; i < intArray2.length; i++) {
			boolean isDuplicate = false;
			for (int j = i+1; j < intArray2.length; j++) {
				if(intArray2[i] == intArray2[j]){
					isDuplicate = true;
					break;
				}/*else{
					isDuplicate = false;
					//break;
				}*/
			}
			if(!isDuplicate)
			System.out.println("intArray2["+i+"] ="+intArray2[i]);
		}
	}

	public static void main(String[] args) {
		PrintUniqueNumber uniqueNum = new PrintUniqueNumber();

	}

}
