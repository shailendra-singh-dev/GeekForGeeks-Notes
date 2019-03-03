package problems.list;

import data_structures.Node;

public class MergeTwoSortedList {

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

		Node result = getResult(a,b);
		printResult(result);
	}
	
	private static Node getMergedListV2() {
		Node head = null;
		if(a.mData <= b.mData) {
			head = a;
			head.next = b;
		}else if(b.mData <= a.mData) {
			head = b;
			head.next= a;
		}
		
		Node aNext = a.next;
		Node bNext = b.next;
		
		while (null != aNext && null != bNext) {
			if (aNext.mData >= head.mData && aNext.mData <= bNext.mData) {
				head.next = aNext;
				head = head.next;
			}
			if (bNext.mData >= head.mData && bNext.mData <= aNext.mData) {
				head.next = bNext;
				head = head.next;
			}
			aNext = a.next;
			bNext = b.next;
		}
		return head;
	}
	
	
}
