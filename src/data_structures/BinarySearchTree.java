package data_structures;

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

	private TreeNode mRootNode;

	public BinarySearchTree() {
		mRootNode = null;
	}

	public TreeNode getRootNode() {
		return mRootNode;
	}

	public void setRootNode(TreeNode mRootNode) {
		this.mRootNode = mRootNode;
	}

	private void insertNodeInTree(TreeNode treeNode) {
		if (mRootNode != null && treeNode.getIntData() < mRootNode.getIntData()) {
			mRootNode.mLeftNode = treeNode;
		} else {
			mRootNode.mRightNode = treeNode;
		}
		mRootNode=treeNode;		
		insertNodeInTree(treeNode);
	}

	public void constructTree() {
		TreeNode root = new TreeNode(10);
		setRootNode(root);

		TreeNode node1 = new TreeNode(5);
		insertNodeInTree(node1);

		TreeNode node2 = new TreeNode(20);
		insertNodeInTree(node2);

		TreeNode node3 = new TreeNode(15);
		insertNodeInTree(node3);

		TreeNode node4 = new TreeNode(25);
		insertNodeInTree(node4);
	}

	public void inorderTraversal(final TreeNode treeNode) {
		if(null == treeNode){
			return;
		}
		System.out.print("/");
		inorderTraversal(treeNode.mLeftNode);
		System.out.print(treeNode.getIntData());
		System.out.print("\\");
		inorderTraversal(treeNode.mRightNode);
	}

}
