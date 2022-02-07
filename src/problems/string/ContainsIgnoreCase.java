package problems.string;

public class ContainsIgnoreCase {

	public static boolean containsIgnoreCase(String str, String what) {
		int len = what.length();
		char firstLo = Character.toLowerCase(str.charAt(0));
		char firstUp = Character.toUpperCase(str.charAt(0));
		for (int i = str.length() - what.length(); i >= 0; i--) {
			if (str.charAt(i) != firstLo && str.charAt(i) != firstUp) {
				continue;
			} else if (str.regionMatches(true, i, what, 0, len)) {
				return true;
			}
		}
		return false;
	}

	public static void test() {
		System.out.println(containsIgnoreCase("Shailendra", "Shail"));
	}
}
