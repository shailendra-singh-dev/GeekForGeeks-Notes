package arrays;

import java.util.Arrays;

public class Duplicates {

	public int[] getDuplicatesArray(int[] array) {
		boolean isDuplicateFound = false;
		int k = 0;
		int[] duplicateArray = new int[array.length];
		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - i - 1; j++) {

				if (array[j + 1] == array[j]) {
					isDuplicateFound = true;
				} else {
					isDuplicateFound = false;
				}

				if (k < array.length) {
					if (isDuplicateFound) {
						duplicateArray[k] = array[j];
						k++;
					}					
				}
			}
		}
		return duplicateArray;
	}

	public static void test() {
		Duplicates duplicates = new Duplicates();
		int[] array = new int[] { 1, 1, 0, 99, -1 };
		System.out.println(Arrays.toString(array));
		int[] duplicatesArray = duplicates.getDuplicatesArray(array);
		System.out.println(Arrays.toString(duplicatesArray));
	}
	
	public void print(int[] array){
		
	}
}
