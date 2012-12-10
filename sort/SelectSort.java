package org.rudolf.sort;

public class SelectSort implements Sort {
	
	private int[] array = null;
	
	public SelectSort() {
		this.array = Utility.getArray();		
	}
	

	public void setArray(int[] arr) {
		this.array = arr;
	}

	public void sort() {
		Utility.printArray(array);
		selectSort(true);
		Utility.printArray(array);
	}
	
	public void selectSort(boolean direction) {
		
		int key = 0;
		int index = 0;
		if (direction) {			
			for (int i = 0; i < array.length; i++) {
				key = array[i];
				for(int j = i; j < array.length; j++) {
					if (array[j] <= key) {
						key = array[j];
						index = j;
					}
				}
				array[index] = array[i];
				array[i] = key;				
			}
		}
	}
	
}
