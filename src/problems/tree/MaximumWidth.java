package problems.tree;

import java.util.LinkedList;
import java.util.Queue;

import data_structures.TreeNode;

/**
 * https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 * @author SS8468 
 */
public class MaximumWidth {
	
	public static void test() {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		root.left = node1;
		root.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.left = node5;
		node2.right = node6;

		/**
		 *               0 
		 *              / \ 
		 *             1   2 
		 *            / \ / \ 
		 *           3  4 5  6
		 * 
		 */
		int maxWidth = getMaxWidth(root);
		System.out.println("maxWidth:"+maxWidth);	
	}
	
	private static int getMaxWidth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int max = 0;
		while(!queue.isEmpty()) {
			int count = queue.size();
			max = Math.max(count, max);
			while(count-- > 0) {
				TreeNode temp = queue.remove();
				if(null != temp.left) {
					queue.add(temp.left);
				}
				if(null != temp.right) {
					queue.add(temp.right);
				}
			}			
		}
		return max;
	}
	
	
	
}
