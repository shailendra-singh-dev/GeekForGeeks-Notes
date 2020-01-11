package problems.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import data_structures.TreeNode;
import data_structures.tree.BinarySearchTree;

/**
 * https://www.geeksforgeeks.org/print-unique-rows/
 * 
 * @author ShSingh
 *
 */

public class PrintUniqueRowsInMatrix {
	
	BinarySearchTree binarySearchTree = new BinarySearchTree();
	
	private void uniqueRowsV2(int[][] M) {
		TreeNode rootNode = null;
		for (int i = 0; i < M.length; i++) {
			String nodeStr = "";
			for (int j = 0; j < M[0].length; j++) {
				nodeStr += M[i][j];
			}
			int nodeInt = Integer.parseInt(nodeStr);
			nodeInt= binaryToDecimal(nodeInt);
			System.out.println(nodeInt);
			rootNode = binarySearchTree.getRootNode();
			
			if(null == rootNode) {
				binarySearchTree.setRootNode(new TreeNode(nodeInt));	
			}
			binarySearchTree.insertWithRecursionV2(rootNode, new TreeNode(nodeInt));
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
	
	public void test() {
		int[][] M = {
				{0, 1, 0, 0, 1},  
                {1, 0, 1, 1, 0},  
                {0, 1, 0, 0, 1},  
                {1, 0, 1, 0, 0}
               }; 
		uniqueRowsV1(M);
		System.out.println("---------------------------------");
		uniqueRowsV2(M);
	}

}
