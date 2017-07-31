package data_structures.queue;

import data_structures.Node;

public class QueueUsingLinkedList {

	private Node mFront;
	private Node mRear;

	public boolean isEmpty() {
		return null == mFront;
	}

	public void enqueue(Node node) {
		if (isEmpty()) {
			mFront = mRear = node;
		} else {
			mRear.next = node;
			mRear = node;
		}
	}

	public Node dequeue() {
		Node temp;
		if (isEmpty()) {
			return null;
		} else {
			temp = mFront;
			mFront = mFront.next;
		}
		return temp;
	}

	public static void test() {

		QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		queueUsingLinkedList.enqueue(node1);
		queueUsingLinkedList.enqueue(node2);
		queueUsingLinkedList.enqueue(node3);

		queueUsingLinkedList.print();

		Node dequedNode1 = queueUsingLinkedList.dequeue();
		System.out.println();
		System.out.print("dequedNode1:" + dequedNode1);

		System.out.println();
		queueUsingLinkedList.print();

		Node dequedNode2 = queueUsingLinkedList.dequeue();
		System.out.println();
		System.out.print("dequedNode2:" + dequedNode2);

		System.out.println();
		queueUsingLinkedList.print();
		
		queueUsingLinkedList.enqueue(node4);
		queueUsingLinkedList.enqueue(node5);
		queueUsingLinkedList.enqueue(node6);
		
		System.out.println();
		queueUsingLinkedList.print();

	}

	private void print() {
		Node current = mFront;
		while (null != current) {
			System.out.print(" " + current);
			current = current.next;
		}
	}

}
