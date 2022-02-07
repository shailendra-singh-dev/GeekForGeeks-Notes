package problems.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem statement.
 * 
 * https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/practice-problems/algorithm/divide-apples/
 * 
 * @author SS8468
 *
 */
public class DivideApples {

	public static void test() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String number = br.readLine();
			int N = Integer.parseInt(number);

			String arrayInput = br.readLine();
			int[] a = new int[N];
			String[] strArray = arrayInput.split(" ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(strArray[i]);
			}
			int count = getCount(a);
			System.out.println(count);

		} catch (Exception e) {

		}

	}

	private static int getCount(int[] a) {
		int count = 0;
		while (count >= 0) {
			for (int i = 0; i < a.length - 1; i++) {
				for (int j = i + 1; i < a.length; j++) {
					int num1 = a[i] - 1;
					int num2 = a[j] + 1;
					if (num1 != num2) {
						count++;
						if (areElementsSame(a)) {
							break;
						}
					}
				}
			}
		}

		return count;
	}

	private static boolean areElementsSame(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] != a[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
