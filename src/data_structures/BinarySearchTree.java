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

    private TreeNode insertNodeInTree(TreeNode treeNode) {
	if(mRootNode != null && treeNode.getIntData()< mRootNode.getIntData()){
	    mRootNode.mLeftNode =  treeNode;
	}else{
	    mRootNode.mRightNode =  treeNode;
	}
	return treeNode;
    }

    public void constructTree() {
	TreeNode root = new TreeNode(0);
	setRootNode(root);
	
	TreeNode node1 = new TreeNode(1);
	insertNodeInTree(node1);
	
	TreeNode node2 = new TreeNode(2);
	insertNodeInTree(node2);
	
	TreeNode node3 = new TreeNode(3);
	insertNodeInTree(node3);
	
	TreeNode node4 = new TreeNode(4);
	insertNodeInTree(node4);
    }
    
    public void inorderTraversal(final TreeNode treeNode){
	System.out.print("/");
	inorderTraversal(treeNode.mLeftNode);
	System.out.print(treeNode.getIntData());
	System.out.print("");
	inorderTraversal(treeNode.mRightNode);
    }
    
    
}
