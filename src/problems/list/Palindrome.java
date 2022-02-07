package problems.list;

import data_structures.Node;
import data_structures.stack.Stack;

public class Palindrome {

	/*
	 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is
	 * -palindrome/
	 */

	private boolean isPalindromeUsingStack(Node head) {
		Stack<Integer> stack = new Stack<Integer>(100);
		Node current = head;
		while (null != current) {
			stack.push(current.data);
			current = current.next;
		}
		current = head;
		while (!stack.isEmpty() && null != current) {
			int data = stack.pop();
			if (data == current.data) {
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
			if (! (currentA.data == currentB.data)) {
				return false;
			}
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return true;
	}

	public static void test() {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		Node.printList(a);
		System.out.println("\nisPalindromeUsingStack():"
				+ new Palindrome().isPalindromeUsingStack(a));
	}
	
	
}
