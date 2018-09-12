package problems.string;

import java.util.HashSet;
import java.util.Set;

public class CheckPermutation {

	private final static Set<String> permutations = new HashSet<String>();

	private static boolean checkIsPermutation(String checkString, String str) {
		if (checkString.isEmpty() || str.isEmpty() || checkString.length() != str.length()) {
			return false;
		}
		Set<String> permutations = getAllPermutations(str, "");
		System.out.println("permutations:" + permutations);
		return permutations.contains(checkString);
	}

	private static Set<String> getAllPermutations(String str, String prefix) {
		if (str.isEmpty()) {
			System.out.println("prefix:" + prefix);
			permutations.add(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				getAllPermutations(rem, prefix + str.charAt(i));
			}
		}
		return permutations;
	}

	public static void test() {
		boolean checkIsPermutation = checkIsPermutation("bca", "abc");
		System.out.println("checkIsPermutation:" + checkIsPermutation);

		sortAndChecklength("bca", "abc");

	}

	private static void sortAndChecklength(String a, String b) {
		System.out.println("sortString(a):" + sortString(a));
		System.out.println("sortString(b):" + sortString(b));
		System.out.println("sortAndChecklength:" + sortString(a).equals(sortString(b)));
	}

	private static String sortString(String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					char temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return new String(a);
	}

}
