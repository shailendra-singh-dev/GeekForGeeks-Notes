package data_structures.tree;

import java.util.ArrayList;
import java.util.Queue;

import data_structures.TreeNode;

public class MatrixBinarySearchTree {

	ArrayList<Integer> mRowIndexes = new ArrayList<>();
			
	private class BSTNode {
		private int mBinaryData;
		private int mData;
		private int row;
		private BSTNode mLeft;
		private BSTNode mRight;
		
		private int decimalToBinary(int n) {
			int[] binary=new int[1000];
			int i=0;
			while(n > 0) {
				binary[i] = n%2;
				n = n/2;
				i++;	
			}
			StringBuffer stringhBuffer=new StringBuffer();
			for (int j = i-1; j>=0; j--) {
				stringhBuffer.append(binary[j]);
			}
			return Integer.parseInt(stringhBuffer.toString());
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
	}

	public BSTNode insert(final BSTNode rootNode, final BSTNode treeNode) {
		if (null == rootNode) {
			return treeNode;
		}
		if (treeNode.mData < rootNode.mData) {
			rootNode.mLeft = insert(rootNode.mLeft, treeNode);
		}
		if (treeNode.mData > rootNode.mData) {
			rootNode.mRight = insert(rootNode.mRight, treeNode);
		}
		return rootNode;
	}
	
	public BSTNode search(final BSTNode rootNode, final BSTNode treeNode) {
		if(null == rootNode) {
			return null;
		}
		if(rootNode.mData == treeNode.mData) {
			System.out.println("Found element");
			return treeNode;
		}
		if(treeNode.mData < rootNode.mData) {
			search(rootNode.mLeft,treeNode);
		}
		return search(rootNode.mRight,treeNode);
	}
	
	
	
	
	
}
