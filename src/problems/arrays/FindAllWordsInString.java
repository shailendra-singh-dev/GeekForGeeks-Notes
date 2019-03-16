package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllWordsInString {

	private static String[] getAllWordsUsingSplit(String input) {
		if (null == input || input.length() == 0) {
			return null;
		}
		// return Pattern.compile(" ").split(input);
		return input.split(" ");
	}

	private static String[] getAllWords(String input) {
		if (null == input || input.length() == 0) {
			return null;
		}
		StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
		int tokens = stringTokenizer.countTokens();
		String[] string = new String[tokens];
		int count = 0;
		while (stringTokenizer.hasMoreTokens()) {
			string[count++] = stringTokenizer.nextToken();
		}
		return string;
	}

	public static void test() {
		String[] words = getAllWords("This is a demo");
		System.out.print(Arrays.toString(words));
	}

}
