package problems.tree;

import data_structures.TreeNode;

public class PrintLeftView {

	private static int level = 0;
	
	//https://www.geeksforgeeks.org/print-left-view-binary-tree/
	
	private static void printRecursiveLeft(TreeNode node, int nodeLevel) {
		if (null == node) {
			return;
		}
		if (nodeLevel > level) {
			level = nodeLevel;
			System.out.print(node);
		}

		printRecursiveLeft(node.getLeftNode(), nodeLevel+1);
		printRecursiveLeft(node.getRightNode(), nodeLevel+1);
	}
	
	
	private static void printRecursiveRight(TreeNode node, int nodeLevel) {
		if (null == node) {
			return;
		}
		if (nodeLevel > level) {
			level = nodeLevel;
			System.out.print(node);
		}

		printRecursiveRight(node.getRightNode(), nodeLevel+1);
		printRecursiveRight(node.getLeftNode(), nodeLevel+1);
	}
	
	
	public static void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.mLeftNode = node2;
		node1.mRightNode = node3;

		node2.mLeftNode = node4;
		node2.mRightNode = node5;

		node4.mLeftNode = node6;

		/*
		 *              1 
		 *             / \ 
		 *            2   3 
		 *           / \ 
		 *          4   5 
		 *         / 
		 *        6
		 * 
		 */
		System.out.println("Left View of Tree");
		printRecursiveLeft(node1, 1);
		level = 0;
		System.out.println("\nRight View of Tree");
		printRecursiveRight(node1, 1);

	}



}
