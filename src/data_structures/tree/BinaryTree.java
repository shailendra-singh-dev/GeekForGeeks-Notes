package data_structures.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.PriorityQueue;

import data_structures.TreeNode;

public class BinaryTree {

	private TreeNode mRootNode;

	public BinaryTree() {
		mRootNode = null;
	}

	public BinaryTree(final int data) {
		mRootNode = new TreeNode(data);
	}

	public void setRootNode(final TreeNode node) {
		mRootNode = node;
	}

	public TreeNode getRootNode() {
		return mRootNode;
	}

	public void constructTree() {
		TreeNode rootNode = new TreeNode(1);
		setRootNode(rootNode);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		rootNode.setLeftNode(node2);
		rootNode.setRightNode(node3);

		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node2.setLeftNode(node4);
		node2.setRightNode(node5);

		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		node3.setLeftNode(node6);
		node3.setRightNode(node7);

	}

	
	/**
	 * https://github.com/eugenp/tutorials/tree/master/algorithms-searching
	 * https://www.baeldung.com/java-depth-first-search	 * 
	 * 
	 */
	public void traversePreOrder(TreeNode node) {
	    if (node != null) {
	        visit(node);
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	
	public void traversePreOrderWithoutRecursion(TreeNode root) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode current = root;
	    stack.push(root);
	    while(!stack.isEmpty()) {
	        current = stack.pop();
	        visit(current);
	        
	        if(current.right != null) {
	            stack.push(current.right);
	        }    
	        if(current.left != null) {
	            stack.push(current.left);
	        }
	    }        
	}
	
	public void traverseInOrder(TreeNode node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        visit(node);
	        traverseInOrder(node.right);
	    }
	}
	
	public void traverseInOrderWithoutRecursion(TreeNode root) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode current = root;
	    stack.push(root);
	    while(! stack.isEmpty()) {
	        while(current.left != null) {
	            current = current.left;                
	            stack.push(current);                
	        }
	        current = stack.pop();
	        visit(current);
	        if(current.right != null) {
	            current = current.right;                
	            stack.push(current);
	        }
	    }
	}
	
	
	public void traversePostOrder(TreeNode node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        visit(node);
	    }
	}
	
	public void traversePostOrderWithoutRecursion(TreeNode root) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = root;
	    TreeNode current = root;
	    stack.push(root);

	    while (!stack.isEmpty()) {
	        current = stack.peek();
	        boolean hasChild = (current.left != null || current.right != null);
	        boolean isPrevLastChild = (prev == current.right || 
	          (prev == current.left && current.right == null));

	        if (!hasChild || isPrevLastChild) {
	            current = stack.pop();
	            visit(current);
	            prev = current;
	        } else {
	            if (current.right != null) {
	                stack.push(current.right);
	            }
	            if (current.left != null) {
	                stack.push(current.left);
	            }
	        }
	    }   
	}
	
	private void visit(TreeNode node) {
		System.out.println(node);
	}
	
	/**
	 * https://www.baeldung.com/java-breadth-first-search
	 */
	
	//Refer https://github.com/eugenp/tutorials/tree/master/algorithms-searching
	
	
}
