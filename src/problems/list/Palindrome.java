package problems.list;

import data_structures.Node;

public class Palindrome {

	private boolean isPalindrome(Node head) {
		Node reversedList = getReversedList(head);
		return isSame(head, reversedList);
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
		Node currentA = a, currentB = b;
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

		Palindrome palindrome = new Palindrome();
		System.out.println("isPalindrome():"+palindrome.isPalindrome(a));;
	}
	
	
}
