package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MatchSpecificPattern {

	public static int[] getHashingValue(String pattern) {
		int[] array = new int[pattern.length()];
		for (char ch : pattern.toCharArray()) {
			array[pattern.indexOf(ch)] = pattern.indexOf(ch);
		}
		return array;
	}

	public static ArrayList<String> getMatchedValues(int[] pattern,
			String[] dictionary) {
		ArrayList<String> values = new ArrayList<String>();
		for (String str : dictionary) {
			if (Arrays.equals(pattern, getHashingValue(str))) {
				values.add(str);
			}
		}
		return values;
	}

	public static void test() {
		String[] dictionary = new String[] { "xyy", "cdd", "bvn" };
		int[] pattern = getHashingValue("abb");
		ArrayList<String> values = getMatchedValues(pattern, dictionary);
		System.out.print("values:" + values);
	}
}