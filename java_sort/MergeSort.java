package org.rudolf.sort;

public class MergeSort implements Sort {
	
	private int[] array = null;
	
	public MergeSort() {
		this.array = Utility.getArray();
	}
	
	public void sort() {
		Utility.printArray(array);
		mergeSort(array, 0, array.length - 1);
		Utility.printArray(array);
	}
	
	public void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			 mergeSort(arr, left, (left + right) / 2);
			 mergeSort(arr, (left + right) / 2 + 1, right);
			 if (arr.length > 0) {	
				 	// 拆分数组
					int middle = (left + right) / 2;
					
					int[] leArr = new int[middle - left + 1];
					int[] riArr = new int[right - middle];
					
					int i = left;
					for (; i <= middle; i++) {
						leArr[i - left] = arr[i];
					}
					for (; i <= right; i++) {
						riArr[i - middle - 1] = arr[i];
					}
					
					// 排序 并合并
					i = left;					
					for (int j = 0, k = 0; i <= right; i++) {
						if ( j < leArr.length && k < riArr.length)  {
							arr[i] = leArr[j] < riArr[k] ? leArr[j++] : riArr[k++];
							
						} else if(k < riArr.length){
							arr[i] = riArr[k++];							
						} else if(j < leArr.length) {
							arr[i] = leArr[j++];							
						}
 					}
					
				} 			
		}
		
	}

}
