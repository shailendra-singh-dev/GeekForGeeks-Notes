package problems.arrays;

import java.util.HashMap;

public class RomanToNumeric {
  private final static HashMap<Character, Integer> ROMAN_MAP = new HashMap<Character, Integer>();;

  public RomanToNumeric() {
    ROMAN_MAP.put('M', 1000);
    ROMAN_MAP.put('D', 500);
    ROMAN_MAP.put('C', 100);
    ROMAN_MAP.put('L', 50);
    ROMAN_MAP.put('X', 10);
    ROMAN_MAP.put('V', 5);
    ROMAN_MAP.put('I', 1);
    System.out.println("convertRomanToDecimal:" + convertToArabic("IIXVVIIIVXX") + "");
  }

  private static int getRomanNumeralValue(char ch) {
    if (ROMAN_MAP.containsKey(ch)) {
      return ROMAN_MAP.get(ch);
    } else {
      throw new RuntimeException("Roman numeral string contains invalid characters " + ch);
    }
  }

  private static int convertToArabic(String romanNumberString) {
    int romanNumberInt = 0;
    int lastIndex = romanNumberString.length() - 1;
    romanNumberInt = getRomanNumeralValue(romanNumberString.charAt(lastIndex));
    for (int i = 0; i <= lastIndex - 1; i++) {
      if (getRomanNumeralValue(romanNumberString.charAt(i)) < getRomanNumeralValue(romanNumberString
          .charAt(i + 1))) {
        romanNumberInt -= getRomanNumeralValue(romanNumberString.charAt(i));
      } else {
        romanNumberInt += getRomanNumeralValue(romanNumberString.charAt(i));
      }
    }
    return romanNumberInt;
  }
}
