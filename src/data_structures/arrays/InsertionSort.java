package data_structures.arrays;

import java.security.Principal;
import java.util.Arrays;

public class InsertionSort {

	public void insertionSort(int[] array) {
		int key;
		for (int i = 1; i < array.length; i++) {
			key = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (key < array[j]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
	
	public static void test() {
		InsertionSort insertionSort = new InsertionSort();
		int[] inputArray = new int[] { 90, 8, -1, 0, 50 };
		insertionSort.insertionSort(inputArray);
		insertionSort.print(inputArray);

	}

	private void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}
}
