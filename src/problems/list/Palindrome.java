package problems.list;

import data_structures.Node;
import data_structures.stack.Stack;

public class Palindrome {

	/*
	 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is
	 * -palindrome/
	 */

	private boolean isPalindromeUsingStack(Node head) {
		Stack<String> stack = new Stack<String>(100);
		Node current = head;
		while (null != current) {
			stack.push(current.data);
			current = current.next;
		}
		current = head;
		while (!stack.isEmpty() && null != current) {
			String data = stack.pop();
			if (!data.equals(current.data)) {
				return false;
			}
			current = current.next;
		}
		return true;
	}

	private boolean isPalindromUsingReverseAndCompare(Node head) {
		return isSame(head, getReversedList(head));
	}


	public Node getReversedList(Node head) {
		Node newHead = null;
		while (null != head) {
			Node node = new Node(head.data);
			node.next = newHead;
			newHead = node;
			head = head.next;
		}
		return newHead;
	}

	private boolean isSame(Node a, Node b) {
		if ((null == a || null == b)) {
			return false;
		}
		Node currentA = a;
		Node currentB = b;
		while (null != currentA && null != currentB) {
			if (!currentA.data.equals(currentB.data)) {
				return false;
			}
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return true;
	}

	public static void test() {
		Palindrome palindrome = new Palindrome();
		Node node1 = new Node("A");
		Node node2 = new Node("B");
		Node node3 = new Node("C");
		Node node4 = new Node("C");
		Node node5 = new Node("B");
		Node node6 = new Node("A");

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		Node.printList(node1);
		System.out.println("\nisPalindromeUsingStack():"
				+ palindrome.isPalindromeUsingStack(node1));
	}
	
	
}
