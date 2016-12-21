package data_structures;

public class LinkedList {
	// reference to the head node.
	private Node head;
	private int listCount;

	// LinkedList constructor
	public LinkedList() {
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		listCount = 0;
	}

	public void add(Node node) {
		// post: appends the specified element to the end of this list.
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while (current.next != null) {
			current = current.next;
		}
		// the last node's "next" reference set to our new node
		current.next = node;
		listCount++;// increment the number of elements variable
	}

	public void add(int index, Node node) {
		// post: inserts the specified element at the specified position in this
		// list.
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for (int i = 0; i < index; i++) {
			if (current.next != null) {
				current = current.next;
			}
		}
		// set the new node's next-node reference to this node's next-node
		// reference
		// now set this node's next-node reference to the new node
		current.next = node;
		listCount++;// increment the number of elements variable
	}

	public Node get(int index) {
		// post: returns the element at the specified position in this list.
		// index must be 0 or higher
		if (index < 0)
			return null;

		Node current = head.next;
		for (int i = 0; i < index; i++) {
			if (null != current.next) {
				current = current.next;
			}
		}
		return current;
	}

	public boolean remove(int index) {
		// post: removes the element at the specified position in this list.
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.next = current.next.next;
		listCount--; // decrement the number of elements variable
		return true;
	}

	public int size() {
		// post: returns the number of elements in this list.
		return listCount;
	}

	public String toString() {
		Node current = head;
		String output = "[";
		while (current != null) {
			output += "[" + current.data.toString() + "],";
			current = current.next;
		}
		output = output.substring(0, output.length() - 1);
		output += "]";
		return output;
	}

	public void addAtFront(final Node node) {
		if (null == head) {
			head = node;
		}
		node.next = head;
		head = node;
	}

	public void insertAfter(final Node existingNode, Node newNode) {
		if (null == existingNode || null == newNode) {
			System.out.print("Error in insertAfter(");
			return;
		}
		newNode.next = existingNode.next;
		existingNode.next = newNode;
	}

	public void insertAtEnd(Node node) {
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;
	}

	public void deleteNode(final Node node) {
		if (head == null) {
			System.out.println("Error ,List is empty");
		}
		Node previousNode = null;
		Node current = head;
		while (current.next != null && current.data != node.data) {
			previousNode = current;
			current = current.next;
		}
		previousNode.next = node.next;
	}

	public void test() {
		Node headNode = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		head = headNode;

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;

		System.out.println("" + this);
		//
		// Node addAtFrontNode = new Node(-1);
		// addAtFront(addAtFrontNode);
		// System.out.println("" + this);
		//
		// Node insertAfterNode = new Node(2.5);
		// insertAfter(node2, insertAfterNode);
		// System.out.println("" + this);
		//
		// Node insertAtEndNode = new Node(4);
		// insertAtEnd(insertAtEndNode);
		// System.out.println("" + this);
		//
		// deleteNode(node2);
		// System.out.println("" + this);

		// int count = getListCount();
		// int count = getListCountRecursive(head);
		// System.out.println("count:" + count);
		// head = deleteFirst(head);
		// System.out.println("" + this);
		swapNodes2(node2, node3);
		System.out.println("" + this);
	}

	private void deleteFirst() {
		if (null == head) {
			System.out.print("List is empty");
		}
		Node node = head.next;
		head = node;
	}

	private Node deleteFirst(Node head) {
		if (null == head) {
			System.out.print("List is empty");
		}
		Node node = head.next;
		return node;
	}

	public int getListCount() {
		if (null == head) {
			return 0;
		}
		int count = 0;
		Node node = head;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	public int getListCountRecursive(Node node) {
		if (null == head) {
			return 0;
		}
		if (null != node) {
			return 1 + getListCountRecursive(node.next);
		}
		return 0;
	}

	private void swapNodes(final Node nodeX, Node nodeY) {
		if (nodeX.data == nodeY.data) {
			return; // Nothing to swap ,they are same.
		}
		Node current = head;
		Node previuosX = null;
		Node currentX = null;
		Node previuosY = null;
		Node currentY = null;

		if (current.data == nodeX.data) {
			currentX = nodeX;
		} else if (current.data == nodeX.data) {
			currentY = nodeY;
		}

		while (current != null) {
			Node previous = current;
			current = current.next;// null if last node..

			if (null == current) {
				break;
			}

			if (current.data == nodeX.data) {
				previuosX = previous;
				currentX = current;
			}

			if (current.data == nodeY.data) {
				previuosY = previous;
				currentY = current;
			}
		}

		Node temp = currentX.next;
		currentX.next = currentY.next;
		currentY.next = temp;

		previuosX.next = currentY;
		previuosY.next = currentX;

		System.out.print("");
	}

	public void swapNodes2(final Node nodeX, Node nodeY) {
		if (nodeX == nodeY)
			return; // Nothing to swap as keys are same
		Node current = head;
		Node prevX = null;
		Node prevY = null;
		Node currentX = null;
		Node currentY = null;

		if (head.data == nodeX) { // Throwing null point exception.
			currentX = head;
		} else if (head.data == nodeY) {
			currentY = head;
		}
		while (current != null) {
			Node prev = current;
			current = current.next;

			if(null == current){
				break;
			}
			if (current.data == nodeX) {
				prevX = prev;
				currentX = current;
			}

			if (current.data == nodeY) {
				prevY = prev;
				currentY = current;
			}
			if (current == null)
				return; // reached end of the loop
		}// end of while
		/* Swap the next pointer and current pointers */
		Node temp = currentX.next;
		currentX.next = currentY.next;
		currentY.next = temp;

		prevX.next = currentY;
		prevY.next = currentX;
	}
}
