package data_structures.arrays;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/merge-sort-algorithm/
 * @author ssingh42
 *
 */
public class MergeSort {

	public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
	
	
	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/*
	 * The mergeSort algorithm implementation
	 */
	private static void mergeSort(int[] array, int left, int right) {

		if (left < right) {
			// split the array into 2
			int center = (left + right) / 2;

			// sort the left and right array
			mergeSort(array, left, center);
			mergeSort(array, center + 1, right);

			// merge the result
			merge(array, left, center + 1, right);
		}
	}

	/*
	 * The merge method used by the mergeSort algorithm implementation.
	 */
	private static void merge(int[] array, int leftArrayBegin,
			int rightArrayBegin, int rightArrayEnd) {

		int leftArrayEnd = rightArrayBegin - 1;

		int numElements = rightArrayEnd - leftArrayBegin + 1;
		int[] resultArray = new int[numElements];
		int resultArrayBegin = 0;

		// Find the smallest element in both these array and add it to the
		// result array i.e you may have a array of the form [1,5] [2,4]
		// We need to sort the above as [1,2,4,5]
		while (leftArrayBegin <= leftArrayEnd
				&& rightArrayBegin <= rightArrayEnd) {
			if (array[leftArrayBegin] <= array[rightArrayBegin]) {
				resultArray[resultArrayBegin++] = array[leftArrayBegin++];
			} else {
				resultArray[resultArrayBegin++] = array[rightArrayBegin++];
			}
		}

		// After the main loop completed we may have few more elements in
		// left array copy them first
		while (leftArrayBegin <= leftArrayEnd) {
			resultArray[resultArrayBegin++] = array[leftArrayBegin++];
		}

		// After the main loop completed we may have few more elements in
		// right array copy them
		while (rightArrayBegin <= rightArrayEnd) {
			resultArray[resultArrayBegin++] = array[rightArrayBegin++];
		}

		System.out.println("resultArray:" + Arrays.toString(resultArray));
//		System.out.print("rightArrayEnd:" + rightArrayEnd + ",numElements:"	+ numElements);
		// Copy resultArray back to the main array
		for (int i = numElements - 1; i >= 0; i--, rightArrayEnd--) {
			array[rightArrayEnd] = resultArray[i];
		}
		System.out.println("array:" +Arrays.toString(array));

	}

	/*
	 * A sample merge method to help understand the merge routine. This below
	 * function is not used by the merge sort
	 * 
	 * This is here only for explanation purpose
	 */
	public int[] sampleMerge(int[] leftArray, int[] rightArray) {

		int leftArrayEnd = leftArray.length - 1;
		int rightArrayEnd = rightArray.length - 1;
		int leftArrayBegin = 0;
		int rightArrayBegin = 0;

		int numElements = leftArray.length + rightArray.length;
		int[] resultArray = new int[numElements];
		int resultArrayBegin = 0;

		// Find the smallest element in both these array and add it to the temp
		// array i.e you may have a array of the form [1,5] [2,4]
		// We need to sort the above as [1,2,4,5]
		while (leftArrayBegin <= leftArrayEnd
				&& rightArrayBegin <= rightArrayEnd) {
			if (leftArray[leftArrayBegin] <= rightArray[rightArrayBegin]) {
				resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];
			} else {
				resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];
			}
		}

		// After the main loop completed we may have few more elements in
		// left array copy them first
		while (leftArrayBegin <= leftArrayEnd) {
			resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];
		}

		// After the main loop completed we may have few more elements in
		// right array copy them
		while (rightArrayBegin <= rightArrayEnd) {
			resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];
		}

		return resultArray;
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	private static void mergeV2(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = m; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public static void mergeSortV2(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSortV2(arr, l, m);
			mergeSortV2(arr, m + 1, r);

			// Merge the sorted halves
			mergeV2(arr, l, m, r);
		}
	}
}
