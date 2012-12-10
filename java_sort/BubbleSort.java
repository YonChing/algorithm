package org.rudolf.sort;

public class BubbleSort implements Sort{
	
	private int[] array = null;	
		
	public BubbleSort() {
		this.array = Utility.getArray();
	}

	public void sort() {
		Utility.printArray(array);
		bubbleSort(array, true);
		Utility.printArray(array);
	}
	
	public void bubbleSort(int[] arr, boolean direction) {		
		if (direction) {
			for (int i = arr.length - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[j+1]) {
						Utility.swap(arr, j, j+1);					
					}
				}
			}
		}		
	}

}
