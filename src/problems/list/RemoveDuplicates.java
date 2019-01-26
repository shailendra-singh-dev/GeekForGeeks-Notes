package problems.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import data_structures.Node;

public class RemoveDuplicates {

	private static final HashMap<Node, Node> HASHMAP = new HashMap<Node, Node>();
	
	private static void remove(Node head) {
		Node previous = null;
		Node current = head;
		while (null != current) {
			if (HASHMAP.containsKey(current)) {
				if (null != previous) {
					previous.next = current.next;
				}
			} else {
				previous = current;
				HASHMAP.put(current, current);
			}
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
		remove(head);
		System.out.println("\n-----------");
		print(head);
	}

	private static void print(Node head) {
		Node current = head;
		while (null != current) {
			System.out.print(" " + current);
			current = current.next;
		}
	}

	private static void printHash() {
		System.out.println("\n-----------");
		Set<Node> set = (Set<Node>) HASHMAP.keySet();
		Iterator<Node> iterator = set.iterator();
		while (iterator.hasNext()) {
			Node node = iterator.next();
			System.out.print(" " + node);
		}

	}

	// https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
}
