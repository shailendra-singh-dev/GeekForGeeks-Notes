package data_structures.linkedList;

import data_structures.Node;

public class CircularLinkedList {

	private Node mHead;
	private Node mTail;
	private int mSize;

	public Node getHead() {
		return mHead;
	}

	public void setHead(Node mHead) {
		this.mHead = mHead;
	}

	public Node getTail() {
		return mTail;
	}

	public void setTail(Node mTail) {
		this.mTail = mTail;
	}

	public int getSize() {
		return mSize;
	}

	public boolean isEmpty() {
		return 0 == mSize && null == mHead;
	}

	public void setSize(int mSize) {
		this.mSize = mSize;
	}

	public void insertAtStart(Node node) {
		if (isEmpty()) {
			mHead = node;
			mTail = node;
			mTail.next = node;
		} else {
			mTail.next = node;
			node.next = mHead;
			mHead = node;
		}
		mSize++;
	}

	public void insertAtEnd(Node node) {
		if (isEmpty()) {
			mHead = node;
			mTail = node;
			mTail.next = node;
		} else {
			mTail.next = node;
			node.next = mHead;
			mTail = node;
		}
		mSize++;
	}

	// Delete from Start
	public void deleteHead() {
		if (isEmpty()) {
			System.err.println("Empty List");
		} else {
			Node temp = mHead.next;
			mTail.next = temp;
			mHead = temp;
		}
		mSize--;
		if (0 == mSize) {
			mHead = null;
		}
	}

	// Delete from End
	public void deleteTail() {
		if (isEmpty()) {
			System.err.println("Empty List");
		} else {
			Node current = mHead;
			do {
				current = current.next;
				if (current.next == mTail) {
					break;
				}
			} while (current != mHead);

			Node lastNode = current;
			lastNode.next = mHead;
			mTail = lastNode;
		}
		mSize--;
		if (0 == mSize) {
			mTail = null;
		}
	}

	public void deleteNode(Node node) {
		if (isEmpty()) {
			System.err.println("Empty List");
		} else {
			Node current = mHead;
			Node previus = null;
			Node next = null;
			if (node == mHead) {
				deleteHead();
			} else if (node == mTail) {
				deleteTail();
			} else {
				do {
					if (current.next == node) {
						previus = current;
						next = current.next.next;
						break;
					}
				} while (current != mHead);
				current.next = next;
			}
		}
		mSize--;
	}

	private static void remove(Node head,Node node) {
		Node current = head;
		while(current !=null) {
			if(current.next == node) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
		}
	}
	
	public void test() {
		Node head = new Node(10);
		insertAtStart(head);
		Node node1 = new Node(12);
		insertAtStart(node1);
		Node node2 = new Node(90);
		insertAtStart(node2);
		Node node3 = new Node(100);
		insertAtEnd(node3);
		Node node4 = new Node(20);
		insertAtEnd(node4);
		print();
		// System.out.println("\n-----deleteHead()------");
		// deleteHead();
		// print();
		// System.out.println("\n-----deleteTail()-----");
		// deleteTail();
		// print();
		// System.out.println("\n-----deleteHead()------");
		// deleteHead();
		// print();
		 System.out.println("\n-----deleteNode(node2)------");
		 deleteNode(head);
		 print();

		System.out.println("\n-----getElement(3)------");
		Node foundNode = getElement(5);
		System.out.println("foundNode():" + foundNode);
	}

	public Node getElement(int index) {
		Node current = mHead;
		if (index >= mSize) {
			return null;
		}
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;

	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Empty List");
		} else {
			Node current = mHead;
			do {
				if (null != current) {
					System.out.print(current + " ");
					current = current.next;
				}
			} while (null != current && current != mHead);
		}
	}

}
