package data_structures;

public class DoubleLinkedList {

	private Node mHead;
	private Node mTail;
	private int mSize;

	public boolean isEmpty() {
		return 0 == mSize && null == mHead;
	}

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

	public void insertAfter(final Node newNode, final Node node) {
		if (isEmpty()) {
			mHead = node;
			mTail = node;
		} else {
			Node next = node.next;

			node.next = newNode;
			newNode.previous = node;

			next.previous = newNode;
			newNode.next = next;
		}
		mSize++;
	}

	public void deleteHead() {
		if (isEmpty()) {
			System.err.println("Empty List");
		} else {
			
			
		}
		mSize--;
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
		Node node1 = new Node(1);
		insertAtStart(node1);

		Node node2 = new Node(2);
		insertAtStart(node2);

		Node node3 = new Node(3);
		insertAtStart(node3);

		Node node4 = new Node(4);
		insertAtend(node4);

		Node node5 = new Node(5);
		insertAfter(node5, node2);

		print();
	}

}
