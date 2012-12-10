package org.rudolf.sort;

public class QuickSort implements Sort {
	
	private int[] array = null;
	
	
	public QuickSort() {
		this.array = Utility.getArray();
	}

	public void sort() {
		Utility.printArray(array);
		quickSort(array, 0, array.length - 1);
		Utility.printArray(array);
	}
	
	public void quickSort(int[] arr, int left, int right) {
		 if (left > 1) {
			 partition(arr, left, right);
			 quickSort(arr, left, (left + right) / 2);
			 quickSort(arr, (left + right) / 2 + 1, right);
		 }
	}
	
	public void partition(int[] arr, int left, int right) {
		int key = arr[right];
		for (int i = left, j = right; i <= right; i++) {
			if (arr[i] > key) {
				Utility.swap(arr, i, j);				
				j--;
			}
		}
	}

}
