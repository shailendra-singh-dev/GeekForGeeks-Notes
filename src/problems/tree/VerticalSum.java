package problems.tree;

import java.util.HashMap;


import data_structures.TreeNode;

public class VerticalSum {

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

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		findVerticalSumRecursive(map, root,0);
		System.out.println(map.entrySet());
	}

	private static void findVerticalSumRecursive(HashMap<Integer, Integer> map, TreeNode root,int HD) {
		if(null == root) {
			return;
		}
		findVerticalSumRecursive(map,root.left,HD-1);
		findVerticalSumRecursive(map,root.right,HD+1);
		int lastSum = map.get(HD) != null ? map.get(HD):0;
		map.put(HD, lastSum + root.getData());		
	}

}
