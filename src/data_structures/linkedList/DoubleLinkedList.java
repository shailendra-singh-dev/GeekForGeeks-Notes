package data_structures.linkedList;

import data_structures.Node;

public class DoubleLinkedList {

	private static final int SIZE_ONE = 1;
	private Node mHead;
	private Node mTail;
	private int mSize;

	public boolean isEmpty() {
		return 0 == mSize && null == mHead;
	}

	// Insert node as a Head.
	public void insertAtStart(final Node node) {
		if (isEmpty()) {
			mHead = node;
			mTail = node;
		} else {
			node.next = mHead;
			mHead.previous = node;
			mHead = node;
		}
		mSize++;
	}

	// Insert node as a Tail.
	public void insertAtend(final Node node) {
		if (isEmpty()) {
			mHead = node;
			mTail = node;
		} else {
			mTail.next = node;
			node.previous = mTail;
			mTail = node;
		}
		mSize++;
	}

	// Insert newNode after node.
	public void insertAfter(final Node newNode, final Node node) {
		if (isEmpty()) {
			mHead = node;
			mTail = node;
		} else if (node == mTail) {
			insertAtend(newNode);
		} else {
			Node next = node.next;

			node.next = newNode;
			newNode.previous = node;

			next.previous = newNode;
			newNode.next = next;
		}
		mSize++;
	}

	// Delete from Start OR head.
	public void deleteHead() {
		if (isEmpty()) {
			System.err.println("Empty List");
		} else {
			Node next = mHead.next;
			mHead = next;
			mHead.previous = null;
		}
		mSize--;
	}

	// Delete from End OR Tail
	public void deleteTail() {
		if (isEmpty()) {
			System.err.println("Empty List");
		} else if (mSize == SIZE_ONE) {
			deleteHead();
		} else {
			Node previous = mTail.previous;
			mTail = previous;
			mTail.next = null;
		}
		mSize--;
	}

	private void deleteNode(Node node) {
		if (isEmpty()) {
			System.err.println("Empty List");
		} else {
			Node current = mHead;
			for (int i = 0; i < mSize; i++) {
				if (current == node) {
					Node previous = node.previous;
					Node next = node.next;

					previous.next = next;
					next.previous = previous;
				}
				if (null != current.next) {
					current = current.next;
				}
			}
		}
		mSize--;
	}

	public Node getElementAt(int index) {
		if (index > mSize) {
			return null;
		} else {
			Node current = mHead;
			for (int i = 0; i < index; i++) {
				if (null != current.next) {
					current = current.next;
				}
			}
			return current;
		}
	}

	public void print() {
		Node current = mHead;
		for (int i = 0; i < mSize; i++) {
			if (null != current) {
				System.out.print("" + current);
				current = current.next;
			}
		}
	}

	public void test() {
		Node node1 = new Node(3);
		insertAtStart(node1);

		Node node2 = new Node(2);
		insertAtStart(node2);

		Node node3 = new Node(1);
		insertAtStart(node3);

		Node node4 = new Node(4);
		insertAtend(node4);

		Node node5 = new Node(5);
		insertAfter(node5, node4);

		deleteHead();
		deleteTail();

		deleteNode(node2);
		print();

		System.out.println("");
		int index = 3;
		Node node = getElementAt(index);
		System.out.print("getElementAt(" + index + "):" + node);

	}

}
