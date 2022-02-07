package problems.string;

public class StringCompare {

	public static int stringComparision(String str1, String str2) {
		return str1.compareTo(str2);
	}

	public static void test() {
		String str1 = "abc";
		String str2 = "ABC";
		int stringComparision = stringComparision(str1, str2);
		System.out.println("stringComparision:" + stringComparision);
	}
}
