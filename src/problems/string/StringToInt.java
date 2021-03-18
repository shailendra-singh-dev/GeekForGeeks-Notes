package problems.string;

public class StringToInt {

	public static int convertStringToInteger(String str) {
		int number = 0;
		int i = 0;

		// Remove white spaces..
		str = str.trim();

		boolean isNumberNegative = false;
		boolean isNonDigitCharFound = false;

		if (str.charAt(i) == '-') {
			isNumberNegative = true;
			str = str.substring(1);
		}
		while (i < str.length()) {
			if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
				isNonDigitCharFound = true;
				number = -1;
				break;
			}
			i++;
		}
		if (isNonDigitCharFound) {
			return number;
		}

		i = 0;

		for (i = 0; i < str.length(); i++) {
			number = number * 10 + (str.charAt(i) - '0');
		}

		if (isNumberNegative) {
			number = -number;
		}
		return number;
	}

	public static void test() {
		String str = "197";
		int number = convertStringToInteger(str);
		System.out.print("number:" + number);

	}
}
