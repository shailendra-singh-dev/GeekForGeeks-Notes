package arrays;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
	if (low >= high || high > array.length || array.length == 0) {
	    return;
	}

	// pick the pivot
	int middle = low + (high - low) / 2;
	int pivot = array[middle];

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
	if (high > i)
	    quickSort(array, i, high);
    }

}
