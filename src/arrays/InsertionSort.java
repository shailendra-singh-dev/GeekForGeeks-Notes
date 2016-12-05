package arrays;

import java.util.Arrays;

public class InsertionSort {

	public static int[] insertionSort(int[] array) {
		int key;
		for (int i = 1; i < array.length; i++) {
			key = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (key < array[j]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				System.out.println(Arrays.toString(array));
			}
		}
		return array;
	}
}
