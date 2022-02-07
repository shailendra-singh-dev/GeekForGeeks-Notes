package problems.string;

public class PrintOrderedSequence {

	public static void test() {
		int[] a1 = { 0, 1, 2, 3, 8 };
		int[] a2 = { 1, 5, 8, 10 };
		int[] a3 = { 3, 4, 8 };
		int[] a4 = { 3, 4, 5, 6, 1021, 1022 };
		System.out.println(getString(a4));
	}

	private static String getString(int[] a) {
		String str = "" + a[0];
		if (null == a || a.length == 0) {
			return str;
		}

		boolean isDash = false;
		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] == 1) {
				isDash = true;				
				if(i== a.length-1)
					str += "-" + a[i];
				
				continue;
			}
			if (isDash) {
				str += "-" + a[i - 1];
				str += "," + a[i];
				isDash = false;
			} else {
				str += "," + a[i];
			}
		}
		return str;
	}

}
