package data_structures.arrays;

import java.util.Scanner;

public class Fibonacci {

	private static int nTHFibonacci(int n) {
		if (0 == n)
			return 0;
		if (1 == n)
			return 1;

		return nTHFibonacci(n - 1) + nTHFibonacci(n - 2);
	}

	public static void test() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
//		int n = nTHFibonacci(N);
		findAllFibs(N);
//		System.out.println("nTHFibonacci:" + n);
	}

	private static void findAllFibs(int n) {
		for (int i = 0; i < n; i++) {
			int fib = nTHFibonacci(i);
			System.out.print( fib + "," );
		}
	}
}
