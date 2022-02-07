package problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data_structures.TreeNode;

/*
 * https://www.baeldung.com/java-breadth-first-search
 * https://leetcode.com/discuss/study-guide/1072548/A-Beginners-guid-to-BFS-and-DFS
 * https://leetcode.com/tag/breadth-first-search/
 */
public class BFS {
	
	public static void test() {
		/**
		 *              1
		 *            /   \
		 *           2     3
		 *          / \   / \
		 *         4   5 6   7
		 *         
		 */
		
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
		
		
		/**
		 *          2
		 *         /
		 *        3
		 *       /
		 *      1            
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
		 */
		
		/*
		TreeNode root = new TreeNode(1);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		root.setRightNode(node_2);
		node_2.setLeftNode(node_3);
		*/
		
//		bfs(root);
		System.out.println(levelOrder(root));
	}

	private static void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode temp = root;
		queue.add(temp);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> visitedNodes = new ArrayList<List<Integer>>();
        if(null == root)
            return visitedNodes;
        
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode current = root;
		queue.add(current);

		while (!queue.isEmpty()) {
			ArrayList<Integer> levelNodes = new ArrayList<>();
			int size = queue.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				current = queue.poll();
                if(null != current){
                    levelNodes.add(current.data);	
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }    
                }				
			}
			visitedNodes.add(levelNodes);			
		}
		return visitedNodes;
	}	
	
	
}
