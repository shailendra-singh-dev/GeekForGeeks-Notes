package problems.list;

import data_structures.Node;

public class MergeSortedList {

	private static Node result;
	private static Node a, b;

	private static Node getSortedNode(Node a, Node b) {
		System.out.println("a:" + a + ",b:" + b);
		if (null == a || null == b) {
			if (null != a) {
				return b;
			}
			return a;
		}
		if (a.mData <= b.mData) {
			a.next = b;
			return a;
		} else if (b.mData <= a.mData) {
			b.next = a;
			return b;
		}
		return null;
	}

	private static Node getResult(Node a, Node b) {
		if (null == result) {
			if (a.mData <= b.mData) {
				result = a;
				result.next = b;
			} else if (b.mData <= a.mData) {
				result = b;
				result.next = a;
			}
		}

		while (null != result) {
			System.out.print(result);
			result = result.next;
			if (null != result) {
				System.out.print("->");
			}
		}

		while (null != a.next && null != b.next) {
			
		}

		return result;
	}

	private static void uploadData() {
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		a1.next = a2;

		a = a1;

		Node a11 = new Node(1);
		Node a12 = new Node(3);
		a11.next = a12;

		b = a11;
	}

	public static void test() {
		uploadData();
		Node result = getResult(a, b);
		// System.out.println("Result:" + result);
	}
}
