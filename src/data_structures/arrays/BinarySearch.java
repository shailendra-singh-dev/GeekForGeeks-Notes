package data_structures.arrays;

public class BinarySearch {
	public static int binarySearch(int[] array, int num) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			int midElement = array[mid];
			if (num == midElement) {
				return mid;
			} else if (num < midElement) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearchWithRecursion(int[] array, int num, int low,
			int high) {
		int mid = (high + low) / 2;
		int midElement = array[mid];
		if (num == midElement) {
			return mid;
		} else if (num < midElement) {
			mid = binarySearchWithRecursion(array, num, low, mid - 1);
		} else {
			mid = binarySearchWithRecursion(array, num, mid + 1, high);
		}
		return mid;
	}

}
