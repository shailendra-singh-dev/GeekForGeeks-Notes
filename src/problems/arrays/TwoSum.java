package problems.arrays;


public class TwoSum {

    public static int[] twoSum(int[] array, int target) {
	int[] indexArray = new int[2];
	for (int i = 0; i < array.length; i++) {
	    for (int j = 1; j < array.length - 1; j++) {
		if (array[i] + array[j] == target) {
		    indexArray[0] = array[i];
		    indexArray[1] = array[j];
		}
	    }
	}
	return indexArray;
    }
}
