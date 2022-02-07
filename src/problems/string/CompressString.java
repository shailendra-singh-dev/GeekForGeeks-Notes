package problems.string;

import java.util.HashMap;
import java.util.Map;

public class CompressString {

	private static final HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	public static void test() {
		String compressedString = getCompressStringV2("abbaa");
		System.out.println(compressedString);
	}

	public static String getCompressString(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		HashMap<Character, Integer> map = getMap(str.toCharArray());
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			stringBuilder.append(entry.getKey());
			stringBuilder.append(entry.getValue());
		}

		String finalStr = stringBuilder.toString();
		if (finalStr.length() <= str.length()) {
			return finalStr;
		}
		return str;
	}

	private static HashMap<Character, Integer> getMap(char[] a) {
		if (null == a || a.length == 0) {
			return null;
		}

		for (int i = 0; i < a.length; i++) {
			char ch = a[i];
			if (map.containsKey(ch)) {
				int count = map.get(ch);
				map.put(ch, ++count);
			} else {
				map.put(ch, 1);
			}
		}
		return map;
	}

	public static String getCompressStringV2(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i + 1 >= str.length() ||  str.charAt(i+1) != str.charAt(i)) {
				stringBuilder.append(str.charAt(i));
				stringBuilder.append(count);
				count = 0;
			}
		}
		final String finalStr = stringBuilder.toString();
		return finalStr.length() < str.length() ? finalStr : str;
	}
	
	public static String compressBad(String str) {
		String compressedString = "";
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString : str;
	}

}
