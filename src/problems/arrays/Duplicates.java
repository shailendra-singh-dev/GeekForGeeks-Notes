package problems.arrays;

import java.util.Arrays;

public class Duplicates {

	public int[] getDuplicatesArray(int[] array) {
		boolean isDuplicateFound = false;
		int[] duplicateArray = new int[array.length];
		int nonDuplicateElement = -1;
		for (int i = 0; i < array.length - 1; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] == array[j]) {
					duplicateArray[i] = array[i];
					duplicateArray[j] = array[j];
					isDuplicateFound = true;
				} else {
					isDuplicateFound = false;
					nonDuplicateElement = array[j];
				}
			}

			if (!isDuplicateFound) {
				duplicateArray[i] = nonDuplicateElement;
				System.out.println("duplicateArray[i]:" + duplicateArray[i]);
			}

		}
		return duplicateArray;
	}

	public int getLastNonDuplicate(int[] array) {
		int lastNonDuplicate = -1;
		for (int i = 0; i < array.length - 1; i++) {

			for (int j = i + 1; j < array.length; j++) {
				if (array[i] != array[j]) {
					lastNonDuplicate = array[j];
				}
			}
		}
		return lastNonDuplicate;
	}

	public static void test() {
		Duplicates duplicates = new Duplicates();
		int[] array = new int[] { 10, 10, -1, 20, 20, -2 };
		System.out.println(Arrays.toString(array));
		int[] duplicatesArray = duplicates.getDuplicatesArray(array);
		System.out.println(Arrays.toString(duplicatesArray));

		int lastNonDuplicate = duplicates.getLastNonDuplicate(array);
		System.out.println("lastNonDuplicate:" + lastNonDuplicate);

	}

	public void print(int[] array) {

	}

}
