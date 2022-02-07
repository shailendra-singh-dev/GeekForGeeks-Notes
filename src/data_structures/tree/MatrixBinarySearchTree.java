package data_structures.tree;

import java.util.ArrayList;
import java.util.Queue;

import data_structures.BSTNode;
import data_structures.TreeNode;

public class MatrixBinarySearchTree {

	ArrayList<Integer> mRowIndexes = new ArrayList<>();
			
	public BSTNode insert(final BSTNode rootNode, final BSTNode treeNode) {
		if (null == rootNode) {
			return treeNode;
		}
		if (treeNode.data < rootNode.data) {
			rootNode.left = insert(rootNode.left, treeNode);
		}
		if (treeNode.data > rootNode.data) {
			rootNode.right = insert(rootNode.right, treeNode);
		}
		return rootNode;
	}
	
	public BSTNode search(final BSTNode rootNode, final BSTNode treeNode) {
		if(null == rootNode) {
			return null;
		}
		if(rootNode.data == treeNode.data) {
			System.out.println("Found element");
			return treeNode;
		}
		if(treeNode.data < rootNode.data) {
			search(rootNode.left,treeNode);
		}
		return search(rootNode.right,treeNode);
	}
	
	public BSTNode delete(BSTNode rootNode, BSTNode treeNode) {
		if(rootNode == null) {
			return rootNode;
		}
		if(treeNode.data < rootNode.data) {
			rootNode.left = delete(rootNode.left,treeNode);
		}else if(treeNode.data > rootNode.data) {
			rootNode.right = delete(rootNode.right, treeNode);
		}else {
		   // Node with 1 child. 	
		   if(rootNode.left ==null) {
			   return rootNode.right;
		   }else if(rootNode.right ==null){
			   return rootNode.left;
		   }
		   //Node with 2 Child
		   rootNode.data = minRightSubTree(rootNode.right);
		   rootNode.right = delete(rootNode.right,rootNode);
		}
		return rootNode;
	}
	
	private int minRightSubTree(BSTNode rootNode) {
		int minValue = rootNode.data;
		while(rootNode.left != null) {
			minValue = rootNode.left.data;
			rootNode = rootNode.left;
		}
		return minValue;
	}

	
	public void preOrderTraversal(final BSTNode treeNode) {
		if (null == treeNode) {
			return;
		}
		System.out.print(treeNode.getBinary() + ",");
		preOrderTraversal(treeNode.left);
		preOrderTraversal(treeNode.right);
	}

	public void postOrderTraversal(final BSTNode treeNode) {
		if (null == treeNode) {
			return;
		}
		postOrderTraversal(treeNode.left);
		postOrderTraversal(treeNode.right);
		System.out.print(treeNode.getBinary() + ",");
	}

	public void inOrderTraversal(final BSTNode treeNode) {
		if (null == treeNode) {
			return;
		}
		inOrderTraversal(treeNode.left);
		System.out.print(treeNode.getBinary() + ",");
		inOrderTraversal(treeNode.right);
	}
	
}
