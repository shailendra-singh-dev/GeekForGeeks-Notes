package problems.arrays;

public class StringReverse {

  public static String reversString(String string) {
    char[] charArray = string.toCharArray();
    for (int i = 0; i < charArray.length / 2; i++) {
      char temp = charArray[i];
      charArray[i] = charArray[charArray.length - i - 1];
      charArray[charArray.length - i - 1] = temp;
    }
    String reverseString = new String(charArray);
    System.out.print(reverseString);

    return reverseString;
  }
}
