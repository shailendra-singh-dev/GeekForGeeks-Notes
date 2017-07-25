package main;

import data_structures.stack.StackUsingLinkedList;
import arrays.MergeSort;

public class AlgorithmsMain {

	public static void main(String[] args) {
		int[] inputArray = new int[] { 90, 8, -1, 0, 50 };
		MergeSort.sort(inputArray);
		MergeSort.print(inputArray);
		// StackUsingLinkedList.test();
	}

	// Driver method
	public static void main1(String args[]) {
	}

	static int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
			{ 13, 14, 15, 16 } };

	public static void main2(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(arr[j][i - j]);
				System.out.print(",");
			}
			System.out.println();
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				System.out.print(arr[i + j][arr.length - j - 1]);
				System.out.print(",");
			}
			System.out.println();
		}
	}

	private static void mainTest() {
		int M = 3, N = 4;
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		int i, j, t;
		for (t = 0; t < M + N; t++)
			for (i = t, j = 0; i >= 0; i--, j++)
				if ((i < M) && (j < N))
					System.out.print(" " + a[i][j]);

		System.out.println("-------");

		for (t = 0; t < M + N; t++)
			for (i = 0, j = t; j >= 0; j--, i++)
				if ((i < M) && (j < N))
					System.out.print(" " + a[i][j]);

	}
}
