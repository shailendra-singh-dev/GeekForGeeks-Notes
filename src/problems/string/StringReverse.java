package problems.string;

public class StringReverse {

  public static String reversString(String string) {
	System.out.println("string:"+string+",size:"+string.length());
    char[] charArray = string.toCharArray();    
    for (int i = 0; i < charArray.length / 2; i++) {
      System.out.println("Swaping charArray[i]:"+(charArray[i])+",(charArray[charArray.length - i - 1]):"+(charArray[charArray.length - i - 1]));	
      char temp = charArray[i];
      charArray[i] = charArray[charArray.length - i - 1];
      charArray[charArray.length - i - 1] = temp;
    }
    String reverseString = new String(charArray);
    System.out.print(reverseString);

    return reverseString;
  }
}
