package problems.list;


import data_structures.Node;

public class MergeSort {

	private static Node getMiddle(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static Node mergeSort(Node node) {
		if (null == node || null == node.next) {
			return node;
		}
		Node middle = getMiddle(node);
		Node secondHalf = middle.next;
		middle.next = null;

		return merge(mergeSort(node), mergeSort(secondHalf));
	}

	private static Node merge(Node a, Node b) {
		Node temp = new Node(-1);
		Node finalList = temp;

		while (null != a && null != b) {
			if (a.data < b.data) {
				temp.next = a;
				finalList = a;
				a = a.next;
			} else {
				temp.next = b;
				finalList = b;
				b = b.next;
			}
		}
		temp.next = (a == null) ? b : a;
		return finalList.next;
	}

	public static void test() {
		// Node node1 = new Node("F");
		// Node node2 = new Node("O");
		// Node node3 = new Node("L");
		// Node node4 = new Node("L");
		// Node node5 = new Node("O");
		// Node node6 = new Node("W");
		// Node node7 = new Node(" ");
		// Node node8 = new Node("U");
		// Node node9 = new Node("P");

		Node node1 = new Node(10);
		Node node2 = new Node(0);
		Node node3 = new Node(5);
		Node node4 = new Node(6);
		Node node5 = new Node(8);
		Node node6 = new Node(3);
		Node node7 = new Node(9);
		Node node8 = new Node(1);
		Node node9 = new Node(12);

		Node head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;

		print(head);
		mergeSort(head);
		print(head);
	}

	private static void print(Node head) {
		System.out.println("\n-----------------");
		Node current = head;
		while (null != current) {
			System.out.print(" " + current);
			current = current.next;
		}
	}

}
