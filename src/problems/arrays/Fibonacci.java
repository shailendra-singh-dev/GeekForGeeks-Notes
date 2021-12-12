package problems.arrays;

import java.util.Scanner;

public class Fibonacci {

	private static int nTHFibonacciV1(int n) {
		if (0 == n)
			return 0;
		if (1 == n)
			return 1;

		return nTHFibonacciV1(n - 1) + nTHFibonacciV1(n - 2);
	}

	private static int nTHFibonacciV2(int n) {
		int f0 = 0, f1 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = f1;
			f1 += f0;
			f0 = temp;
		}
		return f1;
	}

	public static void test() {
		int n = nTHFibonacciV2(4);
//		findAllFibs(N);
		System.out.println("nTHFibonacci:" + n);
	}

	private static void findAllFibs(int n) {
		for (int i = 0; i < n; i++) {
			int fib = nTHFibonacciV1(i);
			System.out.print(fib + ",");
		}
	}
}
