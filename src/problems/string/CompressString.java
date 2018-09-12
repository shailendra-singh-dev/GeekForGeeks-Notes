package problems.string;

import java.util.HashMap;
import java.util.Map;

public class CompressString {

	private static final HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	public static void test() {
		String compressedString = getCompressString("ab");
		System.out.println(compressedString);
	}

	public static String getCompressString(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		HashMap<Character, Integer> map = getMap(str.toCharArray());
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			stringBuilder.append(entry.getKey());
			stringBuilder.append(entry.getValue());
		}

		if (stringBuilder.toString().length() <= str.length()) {
			return str;
		}
		return stringBuilder.toString();
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
}
