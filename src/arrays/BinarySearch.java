package arrays;

public class BinarySearch {
    public static int binarySearch(int[] array, int num) {
	int low = 0;
	int high = array.length;
	for (int i = low; i < high; i++) {
	    int mid = (high - low) / 2;
	    System.out.println();
	    int midElement = array[mid];
	    System.out.print("midElement:" + midElement);
	    if (num == midElement) {
		return mid;
	    } else if (num < midElement) {
		high = mid - 1;
		System.out.print("high:" + high);
	    } else {
		low = mid + 1;
		System.out.print("low:" + low);
	    }
	}
	return -1;
    }

    public static int binarySearchWithRecursion(int[] array, int num, int low,
	    int high) {
	int mid = (high - low) / 2;
	System.out.println();
	int midElement = array[mid];
	System.out.print("midElement:" + midElement);
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
