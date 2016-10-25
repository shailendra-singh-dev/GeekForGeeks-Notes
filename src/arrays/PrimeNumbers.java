package arrays;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

  public static ArrayList<Integer> getAllPrimeNumbers(int number) {
    ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
    boolean isPrime = true;
    for (int i = 1; i <= number; i++) {
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        } else {
          isPrime = true;
        }
      }
      if (isPrime) {
        primeNumbers.add(i);
      }
    }
    return primeNumbers;
  }
}
