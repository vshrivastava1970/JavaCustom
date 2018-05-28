package com.syne.sort;

public class Sorting {

	private static int[] arr = {10,34,2,56,7,67,88,42};
	
	public Sorting() {
	}

	public void sort(ISortable sort){
		sort.sort();
	}
	
	public static void main(String[] args) {
		Sorting sorting = new Sorting();
		
		SelectionSort selectionSortType = new SelectionSort(arr);
		sorting.sort(selectionSortType);
		
		BubbleSort bubbleSortType = new BubbleSort(arr);
		sorting.sort(bubbleSortType);
		
		MergeSort mergeSortType = new MergeSort(arr);
		//sorting.sort(mergeSortType);
		
	}

	public static void print(String sortType, int[] arr2){
		System.out.println(sortType+" :");
		for(int i:arr2){
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.println("");
	}
}
