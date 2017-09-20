package problems.string;

public class SubSequence {

	public static String subSequence(String str, int startIndex, int endIndex) {
		if (null == str || str.isEmpty()) {
			return null;
		}
		return str.subSequence(startIndex, endIndex).toString();
	}

	public static void test() {
		String str = "shailendra";
		int startIndex = 0;
		int endIndex = 2;
		String modifiedString = subSequence(str, startIndex, endIndex);
		System.out.println("modifiedString:" + modifiedString);
	}
}
