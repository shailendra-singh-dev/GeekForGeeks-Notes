package problems.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BurnMaxCalories {

	public static void test() {
		try {
			InputStreamReader r = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(r);
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String[] stringArray = br.readLine().split(" ");
				int[] a = new int[n];
				Integer[] A = new Integer[a.length];
				for (int j = 0; j < n; j++) {
					A[j] = Integer.parseInt(stringArray[j]);
				}
				Arrays.sort(A, Collections.reverseOrder());
				for (int k = 0; k < A.length; k++) {
					a[k] = A[k].intValue();
				}
				System.out.println(getMaxRun(a));
			}
		} catch (Exception exception) {

		}
	}

	private static int getIthRun(int i, int[] a) {
		int run = 0;
		for (int j = 0; j <= i - 1; j++) {
			run += a[j];
		}
		return run;
	}

	private static int getMaxRun(int[] a) {
		int run = 0;
		for (int i = 0; i < a.length; i++) {
			run += 2 * getIthRun(i, a) + a[i];
		}
		return run;
	}

}

