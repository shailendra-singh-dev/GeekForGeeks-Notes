package data_structures.arrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutations {

	public static void test() {
		String str = "tactc";
		HashMap<Character, Integer> countHashtable = getCountTable(str);
		System.out.println("countHashtable:" + countHashtable);
		 boolean isPermutationPalindrome = isPermutationPalindrome(str);
		System.out.println("isPermutationPalindrome:" + isPermutationPalindrome);
	}

	private static HashMap<Character, Integer> getCountTable(String str) {
		final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;

		char[] a = str.toCharArray();
		// Each element is compared with next elements.
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				System.out.println("j=" + j + ",a[j]=" + a[j] + ",i=" + i
						+ ",a[i]=" + a[i]);
				if (a[j] == a[i]) {
					count++;
				}
			}
			if (map.containsKey(a[i])) {
				count = map.get(a[i]);
				count++;
				map.put(a[i], count);
			} else {
				map.put(a[i], count);
			}
		}
		return map;
	}

	private static boolean isPermutationPalindrome(String str) {
		boolean isPermutationPalindrome = false;
		if (str.isEmpty()) {
			return false;
		}

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
