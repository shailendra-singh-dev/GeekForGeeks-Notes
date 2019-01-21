package problems.tree;

import data_structures.TreeNode;
import data_structures.tree.BinaryTree;

public class IsMirrorOfEachOther {

	private static TreeNode aNode = new TreeNode(1);
	private static TreeNode dNode = new TreeNode(1);

	private static boolean isMirror(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		if ((a != null && b == null) || (a == null && b != null)) {
			return false;
		}
		return (a.getData() == b.getData())
				&& (isMirror(a.getLeftNode(), b.getRightNode()))
				&& (isMirror(a.getRightNode(), b.getLeftNode()));
	}

	private static void buildTree() {
		TreeNode bNode = new TreeNode(2);
		TreeNode cNode = new TreeNode(3);
		aNode.setLeftNode(bNode);
		aNode.setRightNode(cNode);

		TreeNode eNode = new TreeNode(2);
		TreeNode fNode = new TreeNode(3);
		dNode.setLeftNode(fNode);
		dNode.setRightNode(eNode);
	}

	public static void test() {
		buildTree();
		boolean isMirror = isMirror(aNode, dNode);
		System.out.println("isMirror():" + isMirror);
	}

}
