package com.syne.sort;

public class SelectionSort implements ISortable {

	private int[] arr;
	public SelectionSort(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void sort() {
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					//Without temp veriable
						/*arr[i] = arr[i]+arr[j];
						arr[j] = arr[i] - arr[j];
						arr[i] = arr[i] - arr[j];*/
				}
			}
		}
		
		Sorting.print("SelectionSort", this.arr);
	}

}
