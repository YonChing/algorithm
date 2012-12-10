package org.rudolf.sort;

import java.util.Random;


public class Utility {
	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(" " + i);
		}
		System.out.print("\n");
	}
	
	public static void swap(int[] arr, int a, int b) {
		arr[a] ^= arr[b];
		arr[b] ^= arr[a];
		arr[a] ^= arr[b];
	}
	
	public static int[] getArray(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = new Random().nextInt(5 * len);
		}
		return arr;
	}
	
	public static int[] getArray() {
		int len = 8;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = new Random().nextInt(5 * len);
		}
		return arr;
	}
	
}
 