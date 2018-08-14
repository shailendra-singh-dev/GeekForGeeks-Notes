package problems.string;

public class IsAllUniqueCharacters {

	private boolean isUnique(String str) {
		if (str.isEmpty() || str.length() == 265 || isAnyDuplicate(str)) {
			return false;
		}
		return true;
	}

	private boolean isAnyDuplicate(final String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j < a.length - i - 1; i++) {
				if (a[j + 1] == a[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
