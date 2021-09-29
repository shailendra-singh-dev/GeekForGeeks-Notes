package problems.string;

import java.util.Arrays;

/**
 * https://github.com/shailendra-singh-dev/StringCalculator
 * 
 * @author ShSingh
 *
 */
public class StringCalculator {

	public void test() {
		String[] array = { "-1;2;1", "//$\n1$2$3", "//;\n1;2;3", "//@\n2@3@8", "//***\n1***2***3" };
		String[] delimiter = { ";", "$", ";", "@", "*" };
//		System.out.println(getSum(array[0], delimiter[0]));

		System.out.println(getSumV3(array[0]));

	}

	private int getSum(String str, String delimiter) {
		if (str.isEmpty()) {
			return 0;
		}
		int sum = 0;
		int index = str.indexOf("//");
		System.out.println(index);
		if (index >= 0) {
			str = str.substring(str.indexOf("//") + 2, str.length());
		}
		str = str.replaceAll("\\n", "");
		str = str.trim();
		String[] strArr = str.split("\\" + delimiter);

		System.out.println(str + "," + Arrays.toString(strArr));
		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].isEmpty()) {
				int num = Integer.parseInt(strArr[i]);
				if (num < 0) {
					throw new RuntimeException("Negatives Not allowed, number is " + num);
				}
				if (num < 1000) {
					sum += Integer.parseInt(strArr[i]);
				}
			}
		}

		return sum;
	}

	/**
	 * https://www.javatpoint.com/java-regex
	 * 
	 * @param str
	 * @return
	 */
	private int getSumV2(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		int sum = 0;
		String[] strArr = str.split("\\W");

		System.out.println(str + "," + Arrays.toString(strArr));
		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].isEmpty()) {
				int num = Integer.parseInt(strArr[i]);
				if (num < 0) {
					throw new RuntimeException("Negatives Not allowed, number is " + num);
				}
				if (num < 1000) {
					sum += Integer.parseInt(strArr[i]);
				}
			}
		}
		return sum;
	}

	/**
	 * https://www.javatpoint.com/java-regex
	 * 
	 * @param str
	 * @return
	 */
	private int getSumV3(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		int sum = 0;
//		String[] strArr = str.split("\\W");
		String[] strArr = str.split("\\D");
		
		System.out.println(str + "," + Arrays.toString(strArr));
		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].isEmpty()) {
				int num = Integer.parseInt(strArr[i]);
				if (num < 0) {
					throw new RuntimeException("Negatives Not allowed, number is " + num);
				}
				if (num < 1000) {
					sum += Integer.parseInt(strArr[i]);
				}
			}
		}
		return sum;
	}
}
