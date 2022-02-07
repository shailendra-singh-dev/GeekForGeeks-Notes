package problems.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrintAllPositiveInEquation {

	private static final int MAX = 5;
	private final static HashMap<Integer, int[]> mMap = new HashMap<Integer, int[]>();

	private static void printPair() {
		int a = 0, b = 0, c = 0, d = 0;
		int[] pairCD = new int[2];
		for (c = 0; c < MAX; c++) {
			for (d = 0; d < MAX; d++) {
				pairCD[0] = c;
				pairCD[1] = d;
				int sum =(int) (Math.pow(a, 3) + Math.pow(b, 3));
				mMap.put(sum, pairCD);
			}
		}
		for (Map.Entry<Integer, int[]> entry : mMap.entrySet()) {
			System.out.println("key:" + entry.getKey() + ",value:"
					+ (int[]) entry.getValue());
		}

		for (a = 0; a < MAX; a++) {
			for (b = 0; b < MAX; b++) {
				System.out.println("(a+b)" + (a + b));
				int pairSum = (a + b);
				if (mMap.containsKey(a + b)) {
					int[] pair = mMap.get(pairSum);
					System.out.println("a:" + a + ",b:" + b + ",c:" + pair[0]
							+ ",d" + pair[1]);
				}
			}
		}
	}

	public static void test() {
		printPair();
	}
}
