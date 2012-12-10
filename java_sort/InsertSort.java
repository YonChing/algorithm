package org.rudolf.sort;

public class InsertSort implements Sort {
	
	private int[] array = null;
	
	
	public InsertSort() {
		this.array = Utility.getArray();
	}

	public void sort() {
		Utility.printArray(array);
		insertSort(array, true);
		Utility.printArray(array);

	}
	
	public void insertSort(int[] arr, boolean direction) {
		int shift = 1;
		for (int i = shift; i < arr.length; i += shift) {
			for (int j = i; j >= shift && arr[j] < arr[j-shift] ; j -= shift) {
					Utility.swap(arr, j, j-shift);
			}	
		}
	}

}
