package arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
	int temp = -1;
	for (int i = 0; i < array.length; i++) {
	    for (int j = i; j < array.length; j++) {
		if (array[j] < array[i]) {
		    temp = array[i];
		    array[i] = array[j];
		    array[j] = temp;
		}
	    }
	}
	return array;
    }
}
