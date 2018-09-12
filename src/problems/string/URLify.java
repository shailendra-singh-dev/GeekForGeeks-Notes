package problems.string;

import java.util.Scanner;

public class URLify {

	public static void test() {
 		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int length = scanner.nextInt();
        

		scanner.close();
	}

	private static int getNumberOfKM(int[] a, int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += a[i];
		}
		return sum;
	}

	private int[] getSortedArray(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					int temp = a[i];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		return a;
	}

}
