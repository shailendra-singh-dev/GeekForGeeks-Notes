package problems.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SetsOperations {

	public static void test() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> output = null;
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				HashSet<Integer> A = new HashSet<Integer>();
				HashSet<Integer> B = new HashSet<Integer>();
				String[] nmArray = br.readLine().split(" ");
				int N = Integer.parseInt(nmArray[0]);
				int M = Integer.parseInt(nmArray[1]);
				String[] nArrayElements = br.readLine().split(" ");
				String[] mArrayElements = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					A.add(Integer.parseInt(nArrayElements[j]));
				}
				for (int k = 0; k < M; k++) {
					B.add(Integer.parseInt(mArrayElements[k]));
				}
				int operation = Integer.parseInt(br.readLine());

				switch (operation) {
					case 1:
						output = operationAND(A, B);
						break;
					case 2:
						output = operationOR(A, B);
						break;
					case 3:
						output = operationXOR(A, B);
						break;
					case 4:
						output = operationAMinusB(A, B);
						break;
					case 5:
						output = operationBMinusA(A, B);
						break;
	
					default:
						break;
				}

				print(output);
				output.clear();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void print(HashSet<Integer> A){
		String str =new String("{");
		Iterator<Integer> iteratorA = A.iterator();
		while (iteratorA.hasNext()) {
			int a = iteratorA.next();
			str = str + a+ " ";
		}
		str = str.trim();
		str = str+ "}";
		System.out.println(str);
	}

	private static HashSet<Integer> operationAND(HashSet<Integer> A,
			HashSet<Integer> B) {
		HashSet<Integer> output = new HashSet<Integer>();
		Iterator<Integer> iteratorA = A.iterator();
		while (iteratorA.hasNext()) {
			int a = iteratorA.next();
			if (B.contains(a)) {
				output.add(a);
			}
		}
		return output;
	}

	private static HashSet<Integer> operationOR(HashSet<Integer> A,
			HashSet<Integer> B) {
		HashSet<Integer> output = new HashSet<Integer>();
		Iterator<Integer> iteratorA = A.iterator();
		Iterator<Integer> iteratorB = B.iterator();
		while (iteratorA.hasNext()) {
			int a = iteratorA.next();
			output.add(a);
		}
		while (iteratorB.hasNext()) {
			int b = iteratorB.next();
			output.add(b);
		}
		return output;
	}

	private static HashSet<Integer> operationXOR(HashSet<Integer> A,
			HashSet<Integer> B) {
		HashSet<Integer> output = new HashSet<Integer>();
		Iterator<Integer> iteratorA = A.iterator();
		Iterator<Integer> iteratorB = B.iterator();
		while (iteratorA.hasNext()) {
			int a = iteratorA.next();
			if (!B.contains(a)) {
				output.add(a);
			}
		}
		while (iteratorB.hasNext()) {
			int b = iteratorB.next();
			if (!A.contains(b)) {
				output.add(b);
			}
		}
		return output;
	}

	private static HashSet<Integer> operationAMinusB(HashSet<Integer> A,
			HashSet<Integer> B) {
		HashSet<Integer> output = new HashSet<Integer>();
		Iterator<Integer> iteratorA = A.iterator();
		while (iteratorA.hasNext()) {
			int a = iteratorA.next();
			if (!B.contains(a)) {
				output.add(a);
			}
		}
		return output;
	}

	private static HashSet<Integer> operationBMinusA(HashSet<Integer> A,
			HashSet<Integer> B) {
		HashSet<Integer> output = new HashSet<Integer>();
		Iterator<Integer> iteratorB = B.iterator();
		while (iteratorB.hasNext()) {
			int b = iteratorB.next();
			if (!A.contains(b)) {
				output.add(b);
			}
		}
		return output;
	}
}
