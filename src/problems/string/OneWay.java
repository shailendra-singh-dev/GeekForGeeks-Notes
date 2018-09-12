package problems.string;

public class OneWay {

	private static boolean isOneInsertAwayV1(String str1, String str2) {
		String sortedStr1 = quickSort(0, str1.length() - 1,str1.toCharArray());
		String sortedStr2 = quickSort(0, str2.length() - 1,str2.toCharArray());
		return sortedStr1.indexOf(sortedStr2) >= 0 || sortedStr2.indexOf(sortedStr1) >= 0;
	}
	
	private static boolean isOneInsertAwayV2(String str1, String str2) {
		
		return false;
	}

	private static boolean isOneReplaceAwayV1(String str1, String str2) {
		char replacedChar = '\0';
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str2.length(); i++) {
				String rem = str2.substring(0, i) + str2.substring(i + 1);
				if (str1.indexOf(rem) >= 0) {
					replacedChar =  str2.charAt(i);
					break;
				}
			}
		}
		System.out.println("replacedChar:"+replacedChar);
		return replacedChar != '\0';
	}
	
	private static boolean isOneReplaceAwayV2(String str1, String str2) {
		boolean found = false;
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					if (found) {
						return false;
					}
					found = true;
				}
			}
		}
		return found;		
	}
	

	public static void test() {
		String str1 = "pale";
		String str2 = "bale";
//		String sortedStr1 = quickSort(0, str1.length() - 1, str1.toCharArray());
//		String sortedStr2 = quickSort(0, str2.length() - 1, str2.toCharArray());
//		System.out.println("sortedStr1:" + sortedStr1);
//		System.out.println("sortedStr2:" + sortedStr2);
//		boolean isOneEditAway = isOneEditAway(sortedStr1, sortedStr2);
//		System.out.println("isOneEditAway:" + isOneEditAway);
//		 boolean isOneReplaceAway = isOneReplaceAwayV2(str1, str2);
//		 System.out.println("isOneReplaceAway:" + isOneReplaceAway);
		isOneEditAway(str1,str2);	

	}

	private static String quickSort(int low, int high, char[] a) {
		if (low > high || high > a.length) {
			return null;
		}

		int i = low, j = high, mid = (low + high) / 2;
		char piot = a[mid];
		while (i <= j) {
			while (a[i] < piot) {
				i++;
			}
			while (a[j] > piot) {
				j--;
			}

			if (i <= j) {
				char temp = a[i];
				a[i] = a[j];
				a[j] = temp;

				i++;
				j--;
			}
		}
		if (low < j) {
			quickSort(low, j, a);
		}
		if (i < high) {
			quickSort(i, high, a);
		}
		return new String(a);
	}

	private static void isOneEditAway(String str1, String str2) {
		if (str1.length() == str2.length()) {
			boolean isOneReplaceAwayV1 = isOneReplaceAwayV1(str1, str2);
			System.out.println(isOneReplaceAwayV1);
		} else if (str1.length() - 1 == str2.length()) {
			boolean isOneInsertAwayV1 = isOneInsertAwayV1(str1, str2);
			System.out.println(isOneInsertAwayV1);
		} else if (str1.length() == str2.length() - 1) {
			boolean isOneInsertAwayV1 = isOneInsertAwayV1(str1, str2);
			System.out.println(isOneInsertAwayV1);
		}
	}
}
