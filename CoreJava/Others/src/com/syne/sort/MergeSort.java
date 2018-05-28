package com.syne.sort;

public class MergeSort implements ISortable {

	private int [] arr;
	int[] tempArray;
	
	public MergeSort(int[] arr) {
		this.arr = arr;
		tempArray = new int[arr.length];
	}

	@Override
	public void sort() {
		int lowerIndex = 0;
		int higherIndex = arr.length-1;
		this.doMergeSort(lowerIndex, higherIndex);
		Sorting.print("MergeSort", arr);
	}

	private void doMergeSort(int lowerIndex, int higherIndex){
		if(lowerIndex < higherIndex){
			int middleIndex = lowerIndex + (higherIndex - lowerIndex)/2;
			
			this.doMergeSort(lowerIndex, middleIndex);
			this.doMergeSort(middleIndex+1, higherIndex);
			this.mergeParts(lowerIndex, middleIndex, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middleIndex, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempArray[i] = arr[i];
		}
		
		int i = lowerIndex;
		int j = middleIndex + 1;
		int k = lowerIndex;
		
		while (i <= middleIndex && j <= higherIndex) {
			if (tempArray[i] <= tempArray[j]) {
				arr[k] = tempArray[i];
				i++;
			} else {
				arr[k] = tempArray[j];
				j++;
			}
			k++;
		}
		while (i <= middleIndex) {
			arr[k] = tempArray[i];
			k++;
			i++;
		}

	}
}
