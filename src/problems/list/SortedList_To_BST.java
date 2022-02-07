package problems.list;

import data_structures.Node;
import data_structures.TreeNode;

public class SortedList_To_BST {

	/**
	 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solution/
	*/
	private static Node getMiddleNode(Node head) {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static void test() {
		Node head = new Node(10);
		Node node1 = new Node(12);
		Node node2 = new Node(90);
		Node node3 = new Node(100);
		Node node4 = new Node(20);
		head.next = node1;
		node1.next= node2;
		node2.next = node3;
		node3.next = node4;
		print(head);
		Node middle = getMiddleNode(head);
		System.out.print("middle" + middle);	
		TreeNode treeNode = sortedListToBST(head);
		System.out.print("treeNode" + treeNode);	
	}
	
	private static void print(Node head) {
		System.out.println();
		Node current = head;
		while (null != current) {
			System.out.print(current + " ");
			current = current.next;
		}
	}
	
	public static TreeNode sortedListToBST(Node head) {
		// If the head doesn't exist, then the linked list is empty
		if (head == null) {
			return null;
		}

		// Find the middle element for the list.
		Node mid = getMiddleNode(head);

		// The mid becomes the root of the BST.
		TreeNode node = new TreeNode(mid.data);

		// Base case when there is just one element in the linked list
		if (head == mid) {
			return node;
		}

		// Recursively form balanced BSTs using the left and right halves of the
		// original list.
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(mid.next);

		return node;
	}
	
}
