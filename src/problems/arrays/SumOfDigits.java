package problems.arrays;

public class SumOfDigits {

  public static int findSumOfDigitsOfNum(int num) {
    int rem = 0, sum = 0;
    while (num > 0) {
      rem = num % 10;
      num = num / 10;
      sum = sum + rem;
    }
    System.out.print("sum  " + sum);
    return sum;
  }
}
