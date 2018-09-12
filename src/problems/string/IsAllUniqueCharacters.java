package problems.string;

public class IsAllUniqueCharacters {

	private static boolean isUnique(String str) {
		if (str.isEmpty() || str.length() > 256 || isAnyDuplicate(str)) {
			return false;
		}
		return true;
	}

	private static boolean isAnyDuplicate(final String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				System.out.println("a[j]:" + a[j] + ",a[i]" + a[i]);
				if (a[j] == a[i]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void test() {
		String str = "*aci()&&";
		boolean isUnique = isUnique(str);
		System.out.println("isUnique:" + isUnique);
	}

}
