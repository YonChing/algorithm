package org.rudolf.sort;

public class ShellSort implements Sort {
	
	private int[] array = null;
	
	
	public ShellSort() {
		this.array = Utility.getArray();
	}

	public void sort() {
		Utility.printArray(array);
		shellSort(array, true);
		Utility.printArray(array);
	}
	
	public void shellSort(int[] arr, boolean direction) {
		int step = 1;
		while ( (3 * step + 1) < arr.length) {
			step = 3 * step + 1;
		}
		while (step > 0) {
			for (int i = step - 1; i < arr.length; i++) {
				int key = arr[i];
				int j = i;
				for (; j >= step && arr[j-step] > key; j -= step) {
					arr[j] = arr[j-step];
				}
				arr[j] = key;
			}
			step /= 3;
		}
	}

}
