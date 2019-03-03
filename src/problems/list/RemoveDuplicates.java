package problems.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import data_structures.Node;

public class RemoveDuplicates {

	private static final HashMap<Node, Node> HASHMAP = new HashMap<Node, Node>();

	// https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
<<<<<<< HEAD
	private static void removeDuplicatesUsingTwoPintersV1(Node head) {
		if (null == head) {
			return;
		}
		Node first = head;
		Node second = head.next;
		while (null != first) {
			while(null != second){
				if(first == second){
					
				}
			}
		}
	}
	
	private static void remove(Node head) {
=======
	private static void removeDuplicatesUsingHashing(Node head) {
		TreeMap<String, Node> TREEMAP = new TreeMap<String, Node>();
>>>>>>> 2f7dceb5ea16b762a9a27662a4fe0fbf31f6cc2d
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
<<<<<<< HEAD
		// remove(head);
		System.out.println("\n-----------");
		removeDuplicatesUsingTwoPintersV1(head);
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

=======
		// removeDuplicatesUsingHashing(head);
		// removeDuplicatesUsingTwoPointers(head);
		removeDuplicatesUsingTwoPointers(head);
		print(head);
	}

>>>>>>> 2f7dceb5ea16b762a9a27662a4fe0fbf31f6cc2d
}
