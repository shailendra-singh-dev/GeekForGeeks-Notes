package problems.string;

public class URLify {

	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length)
			str[trueLength] = '\0';
		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
		System.out.println("\"" + new String(str) + "\"");
	}

	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}

	public static void test() {
		String str = "Mr John  Smith ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		// replaceSpaces(arr, trueLength);
		replaceSpacesV2(arr, trueLength);
	}

	private static void replaceSpacesV2(char[] str, int trueLength) {
		int spaceCount = 0, index;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		index = trueLength + spaceCount * 2;
		char[] newString = new char[index];
		index = index - 1;
		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				newString[index] = '0';
				newString[index - 1] = '2';
				newString[index - 2] = '%';
				index = index - 3;
			} else {
				newString[index--] = str[i];
			}
		}
		System.out.println("" + new String(newString));

	}
}
