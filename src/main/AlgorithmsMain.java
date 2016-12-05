package main;

import java.util.Arrays;

import arrays.BinarySearch;
import arrays.MergeSort;
import arrays.MergingSortedArrays;

public class AlgorithmsMain {

	// Driver method
	public static void main(String args[]) {
		int array[] = { 4, 7, 9, 10, 40, 80 };
		int index = BinarySearch.binarySearchWithRecursion(array, 0, 5, 40);
		System.out.print("" + index);
	}

}
