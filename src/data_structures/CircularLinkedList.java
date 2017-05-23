package data_structures;

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
			mHead.next = node;
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
			mHead.next = node;
		} else {
			mTail.next = node;
			node.next = mHead;
			mTail = node;
		}
		mSize++;
	}

	public void deleteHead() {
		if (isEmpty()) {
			System.out.println("Empty List");
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

	public void deleteTail() {
		if (isEmpty()) {
			System.out.println("Empty List");
		} else {
			Node current = mHead;
			do {
				if (current.next == mTail) {
					break;
				}
			} while (current != mHead);

			Node lastNode = current;
			lastNode.next = mHead;
			mTail = lastNode;
		}
		mSize--;
	}

	public void deleteNode(Node node) {
		if (isEmpty()) {
			System.out.println("Empty List");
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
				previus.next = next;
			}
		}
		mSize--;
	}

	public void test() {
		Node head = new Node(10);
		insertAtStart(head);
		Node node1 = new Node(12);
		insertAtStart(node1);
		Node node2 = new Node(90);
		insertAtEnd(node2);
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
		deleteNode(node2);
		print();
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
