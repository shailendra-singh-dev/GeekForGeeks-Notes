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
		String remainingString = str.substring(1);

		Set<String> permutationSet = getAllPermutations(remainingString);

		for (String permutationSetEntry : permutationSet) {
			for (int i = 0; i <= permutationSetEntry.length(); i++) {
				String start = permutationSetEntry.substring(0, i);
				String end = permutationSetEntry.substring(i);
				String permutaion = start + firstChar + end;
				permutations.add(permutaion);
			}
		}
		return permutations;
	}

	public static void test() {
		String str = "AAA";
		Set<String> permutations = getAllPermutations(str);
		System.out.println(Arrays.toString(permutations.toArray()));
	}
}
