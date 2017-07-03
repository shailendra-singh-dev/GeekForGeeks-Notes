package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import data_structures.CircularLinkedList;
import data_structures.DoubleLinkedList;
import data_structures.LinkedList;
import data_structures.Stack;
import data_structures.StackTemp;

public class AlgorithmsMain {

	public static void main(String[] args) {
		mainTest();
	}
	
	// Driver method
	public static void main1(String args[]) {
		StackTemp<Integer> stackTemp = new StackTemp<Integer>(5);
		Integer pushE1 = stackTemp.push(1000);
		System.out.println("push(1000):" + pushE1);

		Integer popE1 = stackTemp.pop();
		System.out.println("pop():" + popE1);

		// Integer peekE1 = stackTemp.peek();
		// System.out.println("peek():" + peekE1);

		stackTemp.print();
	}

	static int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
			{ 13, 14, 15, 16 } };

	public static void main2(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(arr[j][i - j]);
				System.out.print(",");
			}
			System.out.println();
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				System.out.print(arr[i + j][arr.length - j - 1]);
				System.out.print(",");
			}
			System.out.println();
		}
	}

	private static void mainTest() {
		int M = 3, N = 4;
		int a[][] = { 
				       { 1, 2, 3, 4 }, 
				       { 5, 6, 7, 8 },
				       { 9, 10, 11, 12 } 
				    };

		int i, j, t;
		for (t = 0; t < M + N; t++)
			for (i = t, j = 0; i >= 0; i--, j++)
				if ((i < M) && (j < N))
					System.out.print(" "+a[i][j]);
		
		
		System.out.println("-------");
		
		for (t = 0; t < M + N; t++)
			for (i = 0, j = t; j >= 0; j--, i++)
				if ((i < M) && (j < N))
					System.out.print(" "+a[i][j]);
		
		
	}
}
