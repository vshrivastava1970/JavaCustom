package com.syne.duplicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterDuplicateNumber {

	List<Integer> numbers;
	
	public FilterDuplicateNumber() {
		this.numbers = new ArrayList<Integer>();
		
		for(int i=1;i<30;i++){
			numbers.add(i);
		}
		numbers.add(12);
		
		numbers.add(21);
	}

	public void printDuplicate(){
		for(int i=1; i< this.numbers.size(); i++){
			for(int j=i+1; j< this.numbers.size(); j++){
				if(this.numbers.get(i) == this.numbers.get(j)){
					System.out.println("Dupplicate Number is: "+this.numbers.get(i));
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		FilterDuplicateNumber filterDuplicateNumber = new FilterDuplicateNumber();
		filterDuplicateNumber.printDuplicate();
	}
}
