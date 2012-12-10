package org.rudolf.sort;

public class HeapSort implements Sort {

	private int[] array = null;
	
	public HeapSort() {
		this.array = Utility.getArray();
	}
	
	public void sort() {
		Utility.printArray(array);
		heapSort(true);
		Utility.printArray(array);
	}
	
	public void heapSort(boolean direction) {		
		int len = array.length - 1;
		buildHeap(len);		
		for (int i = array.length - 1; i > 0; i--) {
			Utility.swap(array, i, 0);
			len--;
			heapify(0, len);	
		}
	}	
	
	public void buildHeap(int len) {
		for (int i = len / 2; i >= 1; i--) {
			heapify(i, len);
		}
	}
	
	public void heapify(int index, int len) {
		int left = 2 * index + 1;
		int right = 2 * (index + 1);
		int max = index;
		if (left <= len) {
			if (array[left] > array[max]) {
				max = left;
			}			
		}	
		if (right <= len && array[right] > array[max]) {
			max = right;
		}
		if (max != index) {
			Utility.swap(array, index, max);
			heapify(max, len);
		}
		
	}

}
