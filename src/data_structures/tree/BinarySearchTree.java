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
				insertIterative(rootNode.mLeftNode, treeNode);
			}
		} else if (treeNode.getData() > rootNode.getData()) {
			if (rootNode.mRightNode == null) {
				rootNode.mRightNode = treeNode;
			} else {
				insertIterative(rootNode.mRightNode, treeNode);
			}
		}
	}
	
	public TreeNode insertWithRecursionV2(final TreeNode rootNode, final TreeNode treeNode) {
	   if(null == rootNode) {
		   return treeNode;
	   }
	   if(treeNode.mData < rootNode.mData) {
		   rootNode.mLeftNode = insertWithRecursionV2(rootNode.mLeftNode,treeNode);
	   }
	   if(treeNode.mData > rootNode.mData) {
		   rootNode.mRightNode = insertWithRecursionV2(rootNode.mRightNode,treeNode);
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

	public TreeNode searchItemV2(final TreeNode rootNode, final TreeNode treeNode) {
		if(null == rootNode) {
			return null;
		}
		if(rootNode.mData == treeNode.mData) {
			System.out.println("Found element");
			return treeNode;
		}
		if(treeNode.mData < rootNode.mData) {
			searchItemV2(rootNode.mLeftNode,treeNode);
		}
		return searchItemV2(rootNode.mRightNode,treeNode);
	}
	
	private TreeNode deleteRecursive(TreeNode rootNode, TreeNode treeNode) {
		if(rootNode == null) {
			return rootNode;
		}
		if(treeNode.mData < rootNode.mData) {
			rootNode.mLeftNode = deleteRecursive(rootNode.mLeftNode,treeNode);
		}else if(treeNode.mData > rootNode.mData) {
			rootNode.mRightNode = deleteRecursive(rootNode.mRightNode, treeNode);
		}else {
		   // Node with 1 child. 	
		   if(rootNode.mLeftNode ==null) {
			   return rootNode.mRightNode;
		   }else if(rootNode.mRightNode ==null){
			   return rootNode.mLeftNode;
		   }
		   //Node with 2 Child
		   rootNode.mData = minRightSubTree(rootNode.mRightNode);
		   rootNode.mRightNode = deleteRecursive(rootNode.mRightNode,rootNode);
		}
		return rootNode;
	}
	
	
	private int minRightSubTree(TreeNode rootNode) {
		int minValue = rootNode.mData;
		while(rootNode.mLeftNode != null) {
			minValue = rootNode.mLeftNode.mData;
			rootNode = rootNode.mLeftNode;
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
