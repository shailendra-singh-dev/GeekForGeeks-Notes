package problems.arrays;

import java.util.Arrays;

import data_structures.BSTNode;
import data_structures.tree.MatrixBinarySearchTree;

/**
 * https://www.geeksforgeeks.org/print-unique-rows/
 * 
 * @author ShSingh
 *
 */

public class PrintUniqueRowsInMatrix {
	
	MatrixBinarySearchTree binarySearchTree = new MatrixBinarySearchTree();
	
	private void uniqueRowsV2(int[][] M) {
		BSTNode rootNode = null;
		for (int i = 0; i < M.length; i++) {
			String nodeStr = "";
			for (int j = 0; j < M[0].length; j++) {
				nodeStr += M[i][j];
			}
			int nodeInt = Integer.parseInt(nodeStr);
			nodeInt= binaryToDecimal(nodeInt);
			BSTNode bstNode = new BSTNode(nodeInt);
			System.out.println(bstNode);
			BSTNode insertedNode = binarySearchTree.insert(rootNode,bstNode);
			if(insertedNode == bstNode) {
				binarySearchTree.delete(rootNode, bstNode);
			}
		}		
		binarySearchTree.inOrderTraversal(rootNode);
	}
	
	private int binaryToDecimal(int n) {
		int temp =n;
		int base =1;
		int dec_value = 0;
		while(temp > 0) {
			int last_digit= temp % 10;
			temp = temp/10;
			dec_value += base*last_digit;
			base = base*2;
		}
		return dec_value;
		
	}
	
	//Time complexity: O( ROW^2 x COL )
	private void uniqueRowsV1(int[][] M) {
		boolean[] duplicates = new boolean[M.length];
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j< M.length; j++) {
				if(i!=j) {
					if(isSame(i, j, M)) {
						duplicates[i] = true;
						break;
					}	
				}
				
			}
		}		
		System.out.println(Arrays.toString(duplicates));
		
		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M[0].length;j++) {
				if(!duplicates[i]) {
					printRow(i,M);
					break;
				}
			}
		}
		
	}
	
	private boolean isSame(int i,int j,int[][] M) {
		for (int k = 0; k < M[0].length; k++) {
			if(M[i][k] != M[j][k]) {
				return false;
			}
		}
		return true;
	}
	
	private void printRow(int rowIndex ,int[][] M) {
		for(int i=0;i<M[0].length;i++) {
			System.out.print(M[rowIndex][i]+ " ");
		}
		System.out.println();
	}
	
	public static void test() {
		int[][] M = {
				{0, 1, 0, 0, 1},  
                {1, 0, 1, 1, 0},  
                {0, 1, 0, 0, 1},  
                {1, 0, 1, 0, 0}
               }; 
		PrintUniqueRowsInMatrix printUniqueRowsInMatrix= new PrintUniqueRowsInMatrix();
		printUniqueRowsInMatrix.uniqueRowsV3(M);
//		System.out.println("---------------------------------");
//		printUniqueRowsInMatrix.uniqueRowsV2(M);
	}
	
	private void uniqueRowsV3(int[][] M) {
		boolean[] array=new boolean[M.length];
		for(int i=0;i<M.length-1;i++) {
			for(int j=i+1;j<M.length;j++) {
				if(i != j && equal(M[i],M[j])) {
					array[i] = true;
				}
			}
		}
		for(int i=0;i<array.length;i++) {
			System.out.println();
			if(!array[i]) {
				printRow(M[i]);
			}
		}
	}


	private void printRow(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +" ");
		}
	}

	private boolean equal(int[] a1, int[] a2) {
		for(int i=0;i < a1.length;i++) {
			if(a1[i] != a2[i]) {
				return false;
			}
		}
		return true;
	}

}
