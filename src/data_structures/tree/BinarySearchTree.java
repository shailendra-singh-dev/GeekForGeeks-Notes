package data_structures.tree;

import java.util.Queue;
import java.util.LinkedList;

import data_structures.TreeNode;

public class BinarySearchTree {

	private TreeNode mRootNode;

	public BinarySearchTree() {
		mRootNode = null;
	}

	public void insertWithRecursion(final TreeNode rootNode,
			final TreeNode treeNode) {
		if (null == rootNode) {
			return;
		}
		if (treeNode.getData() < rootNode.getData()) {
			if (rootNode.mLeftNode == null) {
				rootNode.mLeftNode = treeNode;
			} else {
				insert(rootNode.mLeftNode, treeNode);
			}
		} else if (treeNode.getData() > rootNode.getData()) {
			if (rootNode.mRightNode == null) {
				rootNode.mRightNode = treeNode;
			} else {
				insert(rootNode.mRightNode, treeNode);
			}
		}
	}

	public void insert(final TreeNode rootNode, final TreeNode treeNode) {
		if (null == rootNode) {
			return;
		}
		TreeNode currentNode = rootNode;
		while (true) {
			if (treeNode.getData() < currentNode.getData()) {
				if (currentNode.getLeftNode() != null) {
					currentNode = currentNode.getLeftNode();
				} else {
					currentNode.mLeftNode = treeNode;
					break;
				}
			} else if (treeNode.getData() > currentNode.getData()) {
				if (currentNode.getRightNode() != null) {
					currentNode = currentNode.getRightNode();
				} else {
					currentNode.mRightNode = treeNode;
					break;
				}
			}
		}
	}

	public TreeNode searchItem(final TreeNode rootNode, final TreeNode treeNode) {
		if (treeNode.getData() == rootNode.getData()) {
			return rootNode;
		} else if (treeNode.getData() < rootNode.getData()) {
			if (rootNode.getLeftNode() != null) {
				return searchItem(rootNode.getLeftNode(), treeNode);	
			}
		} else if (treeNode.getData() > rootNode.getData()) {
			if (rootNode.getRightNode() != null) {
				return searchItem(rootNode.getRightNode(), treeNode);	
			}
		} 
		return null;
	}

	public void constructTreee() {
		/*
		 * Let us create following BST 50
		 * 							  /  \ 
		 * 							30    70 
		 * 						   / \   /  \ 
		 * 						 20  40 60  80
		 */
		TreeNode rootNode = new TreeNode(50);

		TreeNode node1 = new TreeNode(30);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(40);
		TreeNode node4 = new TreeNode(70);
		TreeNode node5 = new TreeNode(60);
		TreeNode node6 = new TreeNode(80);

		setRootNode(rootNode);

		// insert(rootNode, node1);
		// insert(rootNode, node2);
		// insert(rootNode, node3);
		// insert(rootNode, node4);
		// insert(rootNode, node5);
		// insert(rootNode, node6);

		insertWithRecursion(rootNode, node1);
		insertWithRecursion(rootNode, node2);
		insertWithRecursion(rootNode, node3);
		insertWithRecursion(rootNode, node4);
		insertWithRecursion(rootNode, node5);
		insertWithRecursion(rootNode, node6);
	}

	private void setRootNode(TreeNode rootNode) {
		mRootNode = rootNode;
	}

	public void preOrderTraversal(final TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		System.out.print(treeNode.getData() + ",");
		preOrderTraversal(treeNode.mLeftNode);
		preOrderTraversal(treeNode.mRightNode);
	}

	public void postOrderTraversal(final TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		postOrderTraversal(treeNode.mLeftNode);
		postOrderTraversal(treeNode.mRightNode);
		System.out.print(treeNode.getData() + ",");
	}

	public void inOrderTraversal(final TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		inOrderTraversal(treeNode.mLeftNode);
		System.out.print(treeNode.getData() + ",");
		inOrderTraversal(treeNode.mRightNode);
	}

	public TreeNode getRootNode() {
		return mRootNode;
	}

}
