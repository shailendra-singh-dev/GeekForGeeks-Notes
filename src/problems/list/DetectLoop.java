package problems.list;

import data_structures.Node;
import data_structures.TreeNode;

public class DetectLoop {

	private static boolean isLoopDetectedIterative(final Node head) {
		if (null == head) {
			return false;
		}

		Node slow = head;
		Node fast = head.next;

		while (null != slow && null != fast && null != fast.next) {
			if (fast == slow) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	private static boolean isLoopDetectedRecursive(final Node head, Node slow,
			Node fast) {
		if (null == head) {
			return false;
		}
		if (null == slow && null == fast) {
			slow = head;
			fast = head.next;
		}
		if (fast == slow) {
			return true;
		}
		return isLoopDetectedRecursive(head, slow.next, fast.next.next);
	}

	public static void test() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		Node head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;

//		boolean IsLoopDetected = isLoopDetectedIterative(head);
		boolean isLoopDetectedRecursive = isLoopDetectedRecursive(head,null,null);
		System.out.println("isLoopDetectedRecursive:" + isLoopDetectedRecursive);
	}
}
