package com.syne.sort;

public class BubbleSort implements ISortable {

	private int[] arr;
	
	public BubbleSort(int[] arr) {
		this.arr = arr; 
	}

	@Override
	public void sort() {
		int k =0;
		int tmp = 0;
		for(int j = 0; j < arr.length; j++){
			for (int i = 0; i < arr.length - 1; i++) {
				k = i+1;
				if(arr[i] > arr[k]){
					tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
					
				}
			}
		}
		
		Sorting.print("BubbleSort", arr);
	}

}
