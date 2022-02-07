package problems.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


import data_structures.Node;

public class RemoveDuplicates {

	private static final HashMap<Node, Node> HASHMAP = new HashMap<Node, Node>();

	// https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/

	private static void removeDuplicatesUsingHashing(Node head) {
		TreeMap<Integer, Node> TREEMAP = new TreeMap<Integer, Node>();
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
		System.out.println("\n-----------------");
		if (null == head) {
			return;
		}
		Node current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			Node runner = current;
			while (runner.next != null) { 
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	
	private static void removeDuplicatesUsingMergeSort(Node head) {
		System.out.println("\n-----------------");
		if (null == head) {
			return;
		}
		Node current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			Node runner = current;
			while (runner.next != null) { 
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
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
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(0);
		Node node8 = new Node(1);
		Node node9 = new Node(2);

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
		// remove(head);
		System.out.println("\n-----------");
		print(head);
	}

}
