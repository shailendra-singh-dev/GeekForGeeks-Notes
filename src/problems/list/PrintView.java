package problems.list;

import data_structures.Node;
import data_structures.TreeNode;

public class PrintView {

	private static void printLeftView(TreeNode node, int level) {
		int maxLevel = 0;
		if (null == node) {
			return;
		}
		if (maxLevel < level) {
			maxLevel = level;
			System.out.println(node);
		}
		printLeftView(node.getLeftNode(), level + 1);
		printLeftView(node.getRightNode(), level + 1);
	}

	public static void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
	
		node1.setLeftNode(node2);
		node1.setRightNode(node3);
		
		node2.setLeftNode(node4);
		node2.setRightNode(node5);
		
		node3.setLeftNode(node6);
		node3.setRightNode(node7);
		
		node4.setLeftNode(node8);
		
		printLeftView(node1, 1);
	}

}
