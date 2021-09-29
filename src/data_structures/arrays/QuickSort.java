package data_structures.arrays;

import java.util.Arrays;

public class QuickSort {

	private static int[] quickSort(int[] array, int low, int high) {
		//check for empty or null array
        if (array == null || array.length == 0){
            return null;
        }
         
        if (low >= high){
            return null;
        }

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = array[middle];
		 //int pivot = array[low];
         //int pivot = array[high];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(array, low, j);
		if (i < high)
			quickSort(array, i, high);
		
		return array;
	}


	public static void test() {
		int[] inputArray = new int[] { 90, 8, -1, 0, 50 };
		int[] b = quickSort(inputArray, 0, inputArray.length - 1);
		print(b);

	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}

}
