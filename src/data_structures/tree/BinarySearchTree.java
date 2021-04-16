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
			if (rootNode.left == null) {
				rootNode.left = treeNode;
			} else {
				insertWithRecursion(rootNode.left, treeNode);
			}
		} else if (treeNode.getData() > rootNode.getData()) {
			if (rootNode.right == null) {
				rootNode.right = treeNode;
			} else {
				insertWithRecursion(rootNode.right, treeNode);
			}
		}
	}
	
	public TreeNode insertWithRecursionV2(final TreeNode rootNode, final TreeNode treeNode) {
	   if(null == rootNode) {
		   return treeNode;
	   }
	   if(treeNode.data < rootNode.data) {
		   rootNode.left = insertWithRecursionV2(rootNode.left,treeNode);
	   }
	   if(treeNode.data > rootNode.data) {
		   rootNode.right = insertWithRecursionV2(rootNode.right,treeNode);
	   }
	   return rootNode;
	}	

	public void insertIterative(final TreeNode rootNode, final TreeNode treeNode) {
		if (null == rootNode) {
			return;
		}
		TreeNode currentNode = rootNode;
		while (true) {
			if (treeNode.getData() < currentNode.getData()) {
				if (currentNode.getLeftNode() != null) {
					currentNode = currentNode.getLeftNode();
				} else {
					currentNode.left = treeNode;
					break;
				}
			} else if (treeNode.getData() > currentNode.getData()) {
				if (currentNode.getRightNode() != null) {
					currentNode = currentNode.getRightNode();
				} else {
					currentNode.right = treeNode;
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

	public TreeNode searchItemV2(final TreeNode rootNode, final TreeNode treeNode) {
		if(null == rootNode) {
			return null;
		}
		if(rootNode.data == treeNode.data) {
			System.out.println("Found element");
			return treeNode;
		}
		if(treeNode.data < rootNode.data) {
			searchItemV2(rootNode.left,treeNode);
		}
		return searchItemV2(rootNode.right,treeNode);
	}
	
	public TreeNode deleteRecursive(TreeNode rootNode, TreeNode treeNode) {
		if(rootNode == null) {
			return rootNode;
		}
		if(treeNode.data < rootNode.data) {
			rootNode.left = deleteRecursive(rootNode.left,treeNode);
		}else if(treeNode.data > rootNode.data) {
			rootNode.right = deleteRecursive(rootNode.right, treeNode);
		}else {
		   // Node with 1 child. 	
		   if(rootNode.left ==null) {
			   return rootNode.right;
		   }else if(rootNode.right ==null){
			   return rootNode.left;
		   }
		   //Node with 2 Child
		   rootNode.data = minRightSubTree(rootNode.right);
		   rootNode.right = deleteRecursive(rootNode.right,rootNode);
		}
		return rootNode;
	}
	
	
	private int minRightSubTree(TreeNode rootNode) {
		int minValue = rootNode.data;
		while(rootNode.left != null) {
			minValue = rootNode.left.data;
			rootNode = rootNode.left;
		}
		return minValue;
	}

	public void test() {
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

//		insertWithRecursion(rootNode, node1);
//		insertWithRecursion(rootNode, node2);
//		insertWithRecursion(rootNode, node3);
//		insertWithRecursion(rootNode, node4);
//		insertWithRecursion(rootNode, node5);
//		insertWithRecursion(rootNode, node6);

		insertWithRecursionV2(rootNode, node1);
		insertWithRecursionV2(rootNode, node2);
		insertWithRecursionV2(rootNode, node3);
		insertWithRecursionV2(rootNode, node4);
		insertWithRecursionV2(rootNode, node5);
		insertWithRecursionV2(rootNode, node6);
		
//		rootNode = searchItemV2(rootNode,node3);
//		if(rootNode != null)
//			System.out.println("Element "+node3+" found");
//		else
//			System.out.println("Element "+node3+" Not found");
		
		System.out.println("--------inOrderTraversal---------------");
		inOrderTraversal(rootNode);
		System.out.println("\n--------deleteRecursive---------------");
		rootNode = deleteRecursive(rootNode, node6);
		System.out.println("----------inOrderTraversal-------------");
		inOrderTraversal(rootNode);
		rootNode = deleteRecursive(rootNode, node1);
		System.out.println("----------inOrderTraversal-------------");
		inOrderTraversal(rootNode);
	}

	public void setRootNode(TreeNode rootNode) {
		mRootNode = rootNode;
	}

	public void preOrderTraversal(final TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		System.out.print(treeNode.getData() + ",");
		preOrderTraversal(treeNode.left);
		preOrderTraversal(treeNode.right);
	}

	public void postOrderTraversal(final TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		postOrderTraversal(treeNode.left);
		postOrderTraversal(treeNode.right);
		System.out.print(treeNode.getData() + ",");
	}

	public void inOrderTraversal(final TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		inOrderTraversal(treeNode.left);
		System.out.print(treeNode.getData() + ",");
		inOrderTraversal(treeNode.right);
	}

	public TreeNode getRootNode() {
		return mRootNode;
	}
	

}
