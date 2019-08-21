package problems.arrays;

/**
 * https://leetcode.com/discuss/interview-question/331158/amazon-oa-dice-pips
 * 
 * @author SS8468
 *
 */
public class MinimumDiceIterationsForSameFace {

	// BigO(n) Algorithm
	private static int getCount(final int[] a) {
		int minCount = Integer.MAX_VALUE;
		for (int i = 1; i < 7; i++) {
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				int currentElement = a[j];
				if (i == currentElement) {
					continue;
				} else if ((i + currentElement) == 7) {
					count += 2;
				} else {
					count += 1;
				}
			}
			minCount = Math.min(count, minCount);
		}
		return minCount;
	}

	// BigO(n^2) Algorithm
	private static int getCountV2(final int[] a) {
		int minCount = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			int currentElement = a[i];
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				int anotherElement = a[j];
				System.out.println(currentElement + " comparing with :" + anotherElement);
				if (currentElement == anotherElement) {
					continue;
				} else if ((currentElement + anotherElement) == 7) {
					count += 2;
				} else {
					count += 1;
				}
			}
			System.out.println("count:" + count);
			minCount = Math.min(count, minCount);
			System.out.println("minCount:" + minCount);
		}
		return minCount;
	}

	public static void test() {
		int[] a = new int[] { 1, 2, 3 };
		System.out.println("--------------------getCount(a):" + getCountV2(a));
	}
}
