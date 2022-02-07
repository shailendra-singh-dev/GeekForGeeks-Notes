package data_structures.arrays;

import java.util.Arrays;

public class SelectionSort {

	public static int[] selectionSort(int[] array) {
		int temp = -1;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static int[] selectionSortDecreasingOrder(int[] array) {
		int temp = -1;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[i]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}
	
	public static void test(){
		int[] array = selectionSortDecreasingOrder(new int[]{10,8,-1,4,5});
		print(array);
	}
}
