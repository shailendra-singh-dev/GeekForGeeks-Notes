package problems.string;

public class Palindrome {
	public static boolean isPalindrome(String str) {
		if (null == str || str.isEmpty()) {
			return false;
		}
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			if (str.charAt(i) != str.charAt(chars.length - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void testPalindrome() {
		Palindrome palindrome = new Palindrome();
		String str = "Shailendra";
		String reverse = palindrome.getPalindromeString(str);
		System.out.println("reverse:" + reverse);
	}
	
	public String getPalindromeString(String str) {
		if (null == str || str.isEmpty()) {
			return null;
		}
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = temp;
		}
		return new String(chars);
	}
}
