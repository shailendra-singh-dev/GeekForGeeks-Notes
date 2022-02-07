package problems.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public static ArrayList<Integer> getAllPrimeNumbersV2(int number) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= number; i++) {
			if(isPrime(i)){
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}
	

	private static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void test(){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		ArrayList<Integer> allPrimeNumbers = getAllPrimeNumbersV2(N);
		System.out.println(allPrimeNumbers);
	}
}
