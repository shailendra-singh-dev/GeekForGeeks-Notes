package data_structures.arrays;

import java.util.Arrays;

public class MergingSortedArrays {

	public static int[] getMergedSortedArray(int[] leftArray, int[] rightArray) {
		int[] resultingArray = new int[leftArray.length + rightArray.length];

		int leftArrayBegin = 0;
		int leftArrayEnd = leftArray.length - 1;
		int rightArrayBegin = 0;
		int rightArrayEnd = rightArray.length - 1;

		int resultingArrayBegin = 0;

		while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {
			if (leftArray[leftArrayBegin] < rightArray[rightArrayBegin]) {
				resultingArray[resultingArrayBegin++] = leftArray[leftArrayBegin++];
			} else {
				resultingArray[resultingArrayBegin++] = rightArray[rightArrayBegin++];
			}
		}
		while (leftArrayBegin <= leftArrayEnd) {
			resultingArray[resultingArrayBegin++] = leftArray[leftArrayBegin++];
		}
		while (rightArrayBegin <= rightArrayEnd) {
			resultingArray[resultingArrayBegin++] = rightArray[rightArrayBegin++];
		}
		return resultingArray;
	}

	public static void test() {
		int leftArray[] = { 1, 3, 5, 7 };
		int rightArray[] = { 2, 4, 8, 10 };
		System.out.println("Left Array:" + Arrays.toString(leftArray));
		System.out.println("Right Array:" + Arrays.toString(rightArray));
		System.out.println("Sorted Array:"
				+ Arrays.toString(MergingSortedArrays.getMergedSortedArray(
						leftArray, rightArray)));

	}
}
