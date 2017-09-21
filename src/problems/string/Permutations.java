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
		String str = "ABC";
		Set<String> permutations = getAllPermutations(str);
		System.out.println("permutations:"+Arrays.toString(permutations.toArray()));
	}
}
