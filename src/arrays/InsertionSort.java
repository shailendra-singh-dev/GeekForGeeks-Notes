package arrays;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
	int key;
	int temp;
	for (int i = 1; i < array.length; i++) {
	    key = array[i];
	    int j = i - 1;
	    while (j >= 0 && key < array[j]) {
		temp = array[j];
		array[j] = array[j + 1];
		array[j + 1] = temp;
		j--;
	    }
	    System.out.println(Arrays.toString(array));
	}
	return array;
    }

}
