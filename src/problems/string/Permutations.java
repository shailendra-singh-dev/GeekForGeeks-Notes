package problems.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

	private static Set<String> getAllPermutations(String str) {
		HashSet<String> permutations = new HashSet<String>();
		if (null == str) {
			return null;
		} else if (str.isEmpty()) {
			permutations.add("");
			return permutations;
		}
		char firstChar = str.charAt(0);
		System.out.println("firstChar:" + firstChar);

		String remainingString = str.substring(1);
		System.out.println("remainingString:" + remainingString);

		Set<String> set = getAllPermutations(remainingString);
		System.out.println("set:" + set);

		for (String entry : set) {
			for (int i = 0; i <= entry.length(); i++) {
				String permutation = getSinglePermutation(entry, firstChar, i);
				System.out.println("permutation:" + permutation);
				permutations.add(permutation);
			}
		}
		return permutations;
	}

	private static String getSinglePermutation(String str, char ch, int i) {
		String start = str.substring(0, i);
		String end = str.substring(i);
		String permutaion = start + ch + end;
		return permutaion;
	}

	public static void test() {
		String str = "abc";
		printAllPermutations(str);
	}

	private static void printAllPermutations(String str) {
		printAllPermutations(str, "");
	}

	private static void printAllPermutations(String str, String prefix) {
		if (str.isEmpty()) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				System.out.println("str.substring(0, i):" + str.substring(0, i)
						+ ", str.substring(i + 1):" + (str.substring(i + 1))
						+ ",rem:" + rem);
				printAllPermutations(rem, prefix + str.charAt(i));
			}
		}
	}

}
