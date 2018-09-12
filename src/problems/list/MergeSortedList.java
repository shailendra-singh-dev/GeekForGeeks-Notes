package problems.list;

import data_structures.Node;

public class MergeSortedList {

	private static Node a, b;

	private static Node getResult(Node headA, Node headB) {
		if (headA == null)
			return headB;
		if (headB == null)
			return headA;

		Node head = headA.mData < headB.mData ? headA : headB;

		Node currA = headA, currB = headB;
		while (currA != null && currB != null) {
			if (currA.mData < currB.mData) {
				Node aNext = currA.next;
				if (aNext == null || aNext.mData > currB.mData) {
					currA.next = currB;
				}
				currA = aNext;
			} else {
				Node bNext = currB.next;
				if (bNext == null || bNext.mData > currA.mData) {
					currB.next = currA;
				}
				currB = bNext;
			}
		}

		return head;
	}

	private static void printResult(Node result) {
		while (null != result) {
			System.out.print(result);
			result = result.next;
			if (null != result) {
				System.out.print("->");
			}
		}
	}

	public static void test() {
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		a1.next = a2;

		a = a1;

		Node a11 = new Node(1);
		Node a12 = new Node(3);
		a11.next = a12;

		b = a11;

		Node result = getResult(a, b);
		printResult(result);
	}
}
