package problems.string;

public class UpperLowerCase {

	// 65-90 (A-Z), 97-122(a-z)
	
	public static String toLowerCase(String str) {
		if (null == str || str.isEmpty()) {
			return null;
		}
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (ch >= 65 && ch <= 90) {
				ch += 32;
				chars[i] = ch;
			}
		}
		return new String(chars);
	}
	
	public static String toUpperCase(String str) {
		if (null == str || str.isEmpty()) {
			return null;
		}
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (ch >= 97 && ch <= 122) {
				ch -= 32;
				chars[i] = ch;
			}
		}
		return new String(chars);
	}
	
	
	public static void test() {
		String str = "ABC";
		String lowerCaseString = toLowerCase(str);
		System.out.println("lowerCaseString:" + lowerCaseString);
		
		String upperCaseString = toUpperCase(lowerCaseString);
		System.out.println("upperCaseString:" + upperCaseString);
	}
}
