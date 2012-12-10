package org.rudolf.sort;

public class BubbleSort implements Sort{
	
	private int[] arr = null;
	
		
	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public void sort() {
		// TODO Auto-generated method stub
		bubbleSort(arr, true);
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
