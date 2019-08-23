package problems.tree;

import java.util.LinkedList;

import data_structures.TreeNode;
import problems.concurrency.Queue;

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

		root.mLeftNode = node1;
		root.mRightNode = node2;

		node1.mLeftNode = node3;
		node1.mRightNode = node4;

		node2.mLeftNode = node5;
		node2.mRightNode = node6;

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
		java.util.Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		
		int max = 0;
		while(!queue.isEmpty()) {
			int count = queue.size();
			max = Math.max(count, max);
			while(count-- > 0) {
				TreeNode temp = queue.remove();
				if(null != temp.mLeftNode) {
					queue.add(temp.mLeftNode);
				}
				if(null != temp.mRightNode) {
					queue.add(temp.mRightNode);
				}
			}			
		}
		return max;
	}
	
	
	
}
