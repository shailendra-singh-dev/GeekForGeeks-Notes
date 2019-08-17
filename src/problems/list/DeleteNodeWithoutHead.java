package problems.list;

import data_structures.Node;
import data_structures.linkedList.LinkedList;

public class DeleteNodeWithoutHead {

	public static void deleteNodeWithoutHead(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
	}

	public static void test() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		Node head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;

		LinkedList.printList(head);
		deleteNodeWithoutHead(node3);
		LinkedList.printList(head);
	}

}
