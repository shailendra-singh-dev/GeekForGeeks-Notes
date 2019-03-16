package problems.arrays;

public class EquilibriumIndex {

	public static int getEquilibriumIndex(int[] array) {
		int sumLeft = 0;
		int sumRight = 0;

		for (int i = 0; i < array.length; i++) {
			sumLeft = 0;
			sumRight = 0;
			for (int j = 0; j < i; j++) {
				sumLeft += array[j];
			}

			for (int j = i + 1; j < array.length; j++) {
				sumRight += array[j];
			}

			if (sumLeft == sumRight) {
				return i;
			}
		}
		return -1;
	}

	public static int getEquilibriumIndexEfficient(int[] array) {
		int sum = 0;
		int sumLeft = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		for (int i = 0; i < array.length; i++) {
			sum -= array[i];
			if (sum == sumLeft) {
				return i;
			}
			sumLeft += array[i];
		}
		return -1;
	}
}
