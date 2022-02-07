package problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class IsPermutationPalindrome {

	public static void test() {
		String str = "tactc";
		HashMap<Character, Integer> countHashtable = getCountTable(str);
		System.out.println("countHashtable:" + countHashtable);
		boolean isPermutationPalindrome = isPermutationPalindromeV1(str);
		System.out.println("isPermutationPalindrome:" + isPermutationPalindrome);
	}

	private static HashMap<Character, Integer> getCountTable(String str) {
		final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : str.toCharArray()) {
			Integer count = map.get(ch);
			if (count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, ++count);
			}
		}
		return map;
	}

	private static boolean isPermutationPalindromeV1(String str) {
		if (str.isEmpty()) {
			return false;
		}
		final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : str.toCharArray()) {
			Integer count = map.get(ch);
			if (count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, ++count);
			}
		}
		boolean isPermutationPalindrome = false;
		HashMap<Character, Integer> countHashtable = getCountTable(str);
		for (Map.Entry<Character, Integer> entry : countHashtable.entrySet()) {
			int value = entry.getValue();
			if (value % 2 == 1) {
				if (isPermutationPalindrome) {
					return false;
				}
				isPermutationPalindrome = true;
			}
		}
		return true;
	}

}
