package problems.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import data_structures.TreeNode;

/**
 * https://www.baeldung.com/java-depth-first-search
 * https://leetcode.com/tag/breadth-first-search/
 * https://leetcode.com/tag/depth-first-search/
 */

/**
 * https://leetcode.com/discuss/study-guide/1072548/A-Beginners-guid-to-BFS-and-DFS
 * @author ShSingh
 *
 * 1.Add the visited Node to stack.
 * 2.Pop the Node from stack, explore its children and add them to stack.
 * 3.Explore all the nodes till stack becomes empty
 */
public class DFS {
	
	public static void test() {
		/**
		 *              1
		 *            /   \
		 *           2     3
		 *          / \   / \
		 *         4   5 6   7
		 *         
		 *         Pre-Order: 1245367
                   Inorder: 4251637
                   Post-Order: 4526731
		 */
		
		/*
		TreeNode root = new TreeNode(1);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		TreeNode node_4 = new TreeNode(4);
		TreeNode node_5 = new TreeNode(5);
		TreeNode node_6 = new TreeNode(6);
		TreeNode node_7 = new TreeNode(7);
		root.setLeftNode(node_2);
		root.setRightNode(node_3);
		node_2.setLeftNode(node_4);
		node_2.setRightNode(node_5);
		node_3.setLeftNode(node_6);
		node_3.setRightNode(node_7);
		*/
		
		
		/**
		 *          2
		 *         /
		 *        3
		 *       /
		 *      1            
		 
			Pre-Order:2,3,1 
		    Inorder: 1,3,2
		    Post-Order: 1,3,2
		*/
		
		/*
		TreeNode root = new TreeNode(2);
		TreeNode node_2 = new TreeNode(3);
		TreeNode node_3 = new TreeNode(1);
		root.setLeftNode(node_2);
		node_2.setLeftNode(node_3);
		*/
		
		/**
		 *         1
		 *          \
		 *   		 2
		 *          /
		 *         3 
		 *
		 *    Pre-Order:1,2,3
		      Inorder: 
		      Post-Order: 3,2,1 
		 */
		
		TreeNode root = new TreeNode(1);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		root.setRightNode(node_2);
		node_2.setLeftNode(node_3);
		
//		preOrderTraversalWithoutRecursion(root);
//		System.out.println();
		inOrderTraversalWithoutRecursion(root);
//		System.out.println();
//		postOrderTraversalWithRecursion(root);
//		System.out.println();
//		postOrderTraversalWithoutRecursion(root);
	}
	
	private static void preOrderTraversalWithRecursion(final TreeNode root) {
		if(root != null) {
			visitNode(root);
			preOrderTraversalWithRecursion(root.left);
			preOrderTraversalWithRecursion(root.right);
		}		
	}
	
	
	/**
	 * https://www.youtube.com/watch?v=oakpyHhZ53A
	 * @param root
	 */
	private static void preOrderTraversalWithoutRecursion(final TreeNode root) {
		Stack<TreeNode> visited =new Stack<>();
		TreeNode current = root;
		visited.push(current);		 
		while(!visited.isEmpty()) {
			current = visited.pop();
			if(null != current) {
				visitNode(current);
				if(null != current.right) { 
					visited.push(current.right);
				}
				if(null != current.left) { 
					visited.push(current.left);
				}
			}
		}
	}
	
	private static void inOrderTraversalWithRecursion(final TreeNode root) {
		if(root != null) {
			inOrderTraversalWithRecursion(root.left);
			visitNode(root);			
			inOrderTraversalWithRecursion(root.right);
		}		
	}
	
	private static void inOrderTraversalWithoutRecursion(final TreeNode root) {
		Stack<TreeNode> visited = new Stack<>();
		TreeNode current = root;
        visited.push(current);
        
		while (!visited.isEmpty()) {
			while (null != current) {
                current = current.left;
				visited.push(current);				
			}
			current = visited.pop();
            
            if(null != current)  
            	visitNode(current);
            
            if(null != current){                
                current = current.right;
                visited.push(current);				
            }			
		}
	}
	
	private static void postOrderTraversalWithRecursion(final TreeNode root) {
		if(root != null) {
			System.out.println(root);
			postOrderTraversalWithRecursion(root.left);
			postOrderTraversalWithRecursion(root.right);
			visitNode(root);
		}		
	}
	
	/**
	 * https://www.youtube.com/watch?v=PiqIXedWhoY
	 * @param root
	 */
	private static void postOrderTraversalWithoutRecursion(final TreeNode root) {
		Stack<TreeNode> visited = new Stack<>();
		ArrayList<TreeNode> visitedNodes = new ArrayList<>();
		TreeNode current = root;
		visited.push(current);		 
		while(!visited.isEmpty()) {
			current = visited.pop();
			if(null != current) {
				visitedNodes.add(current);
				if(null != current.left) { 
					visited.push(current.left);
				}
				if(null != current.right) { 
					visited.push(current.right);
				}
			}
		}
		Collections.reverse(visitedNodes);
		for (TreeNode node : visitedNodes) {
			visitNode(node);
		}
	}
	
	private static void visitNode(final TreeNode node) {
		if (null != node)
			System.out.print(node); 
	}
}
