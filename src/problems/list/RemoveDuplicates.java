package problems.list;

import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;

import data_structures.Node;

public class RemoveDuplicates {

	private static void removeDuplicatesUsingHashing(Node head) {
		TreeMap<String, Node> TREEMAP = new TreeMap<String, Node>();
		Node previous = null;
		Node current = head;
		while (null != current) {
			if (TREEMAP.containsKey(current.data)) {
				previous.next = current.next;
			} else {
				previous = current;
				TREEMAP.put(current.data, current);
			}
			current = current.next;
		}
	}

	private static void removeDuplicatesUsingTwoPointers(Node head) {
		if (null == head) {
			return;
		}
		Node previous = null;
		Node slow = head;
		Node fast = head.next;
		while (null != slow && null != fast) {
			if (isSame(slow, fast)) {
				previous.next = fast.next;
			}
			previous = fast;
			fast = fast.next;
		}
	}

	private static boolean isSame(Node node, Node head) {
		System.out.println("node:" + node + ",head" + head);
		Node current = head;
		while (null != current) {
			if (current == node) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	private static void print(Node head) {
		System.out.println("\n-----------------");
		Node current = head;
		while (null != current) {
			System.out.print(" " + current);
			current = current.next;
		}
	}

	public static void test() {
		Node node1 = new Node("F");
		Node node2 = new Node("O");
		Node node3 = new Node("L");
		Node node4 = new Node("L");
		Node node5 = new Node("O");
		Node node6 = new Node("W");
		Node node7 = new Node(" ");
		Node node8 = new Node("U");
		Node node9 = new Node("P");

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
		// removeDuplicatesUsingHashing(head);
		removeDuplicatesUsingTwoPointers(head);
		print(head);
	}

}
