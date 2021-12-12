package data_structures.linkedList;

import data_structures.Node;

public class LinkedList {
	// reference to the head node.
	private Node head;
	private int size;

	// LinkedList constructor
	public LinkedList() {
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		size = 0;
	}

	public void setHead(Node node) {
		head = node;
	}

	public Node getHeadNode() {
		return head;
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
		size++;// increment the number of elements variable
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
		size++;// increment the number of elements variable
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
		size--; // decrement the number of elements variable
		return true;
	}

	public int size() {
		// post: returns the number of elements in this list.
		return size;
	}

	public String toString() {
		Node current = head;
		String output = "[";
		while (current != null) {
			output += "[" + current.data + "],";
			current = current.next;
		}
		output = output.substring(0, output.length() - 1);
		output += "]";
		return output;
	}

	public static void printList(Node node) {
		Node current = node;
		String output = "[";
		while (current != null) {
			output += "[" + current.data + "],";
			current = current.next;
		}
		output = output.substring(0, output.length() - 1);
		output += "]";
		System.out.println(output);
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
//		Node previousNode = null;
		Node current = head;
		while (current.next != null && current.data != node.data) {
//			previousNode = current;
			current = current.next;
		}
//		previousNode.next = node.next;
	}

	public  void test() {
		Node headNode = new Node(9);
		Node node1 = new Node(10);
		Node node2 = new Node(2);
		Node node3 = new Node(-1);
		Node node4 = new Node(8);
		head = headNode;

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;

		printList(head);
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
		 deleteNode(node2);
		 printList(head);
//		 System.out.println("" + this);

		// int count = getListCount();
		// int count = getListCountRecursive(head);
		// System.out.println("count:" + count);
		// head = deleteFirst(head);
		// System.out.println("" + this);
		// swapNodes(node2, node3);
		// head = reverseList();
		// head = reverseUsingRecursion(head);
		// head = reverseUsingTailRecursion(null, head);

		// Node headNode2 = new Node(10);
		// Node node21 = new Node(11);
		// Node node22 = new Node(22);
		// Node node23 = new Node(33);
		// setHead(headNode2);
		//
		// getHeadNode().next = node21;
		// node21.next = node22;
		// node22.next = node23;
		// node23.next = null;
		//
		// printList(headNode2);

		// Node mergedListNode = getMergedSortedListV2(headNode, headNode2);
		// printList(mergedListNode);

		// Node mergedListNode = mergeSortIterative(head);
		// Node mergedListNode = mergeSortUsingRecursion(head);
		// printList(mergedListNode);

//		Node reverseKNodes = reverseEveryKNodes( 2);
//		printList(reverseKNodes);
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
		if (nodeX == nodeY)
			return; // Nothing to swap as keys are same

		Node current = head;
		Node prevX = null;
		Node prevY = null;
		Node currentX = null;
		Node currentY = null;

		if (head.data == nodeX.data) {
			currentX = head;
		} else if (head.data == nodeY.data) {
			currentY = head;
		}

		while (current != null) {
			Node prev = current;
			current = current.next;

			if (null == current) {
				break;
			}
			if (current.data == nodeX.data) {
				prevX = prev;
				currentX = current;
			}

			if (current.data == nodeY.data) {
				prevY = prev;
				currentY = current;
			}
		}
		// If either x or y is not present, nothing to do
		if (currentX == null || currentY == null)
			return;

		/* Swap the next pointer and current pointers */
		System.out.println("prevX:" + prevX + ",currentX:" + currentX
				+ ",prevY:" + prevY + ",currentY:" + currentY);

		if (prevX != null) {
			prevX.next = currentY;
		} else {
			head = currentY;
		}
		if (prevY != null) {
			prevY.next = currentX;
		} else {
			head = currentX;
		}

		// Swap next pointers
		Node temp = currentY.next;
		currentY.next = currentX.next;
		currentX.next = temp;
	}

	private Node reverseList() {
		Node previus = null;
		Node next = null;
		Node current = head;
		while (current != null) {
			next = current.next;

			current.next = previus;
			previus = current;
			current = next;
		}
		return previus;
	}

	public Node reverseUsingRecursion(Node node) {
		if (node == null)// Empty List
			return null;
		if (node.next == null) // Only one element.
			return node;

		Node next = node.next;
		Node reverseRest = reverseUsingRecursion(next);
		// then we join the two lists
		next.next = node;
		// point last node to nil, (get rid of cycles)
		node.next = null;
		return reverseRest;
	}

	// A Simpler and Tail Recursive Method
	private Node reverseUsingTailRecursion(Node previous, Node current) {
		Node next = current.next;
		current.next = previous;
		System.out.println("previous:" + previous + ",current:" + current);

		return next == null ? current
				: reverseUsingTailRecursion(current, next);
	}

	// Taken from
	// https://discuss.leetcode.com/category/29/merge-two-sorted-lists
	private Node getMergedSortedListUsingIteration(Node firstListNode,
			Node secondListNode) {
		if (null == firstListNode && null == secondListNode) {
			return null;
		}
		if (null == firstListNode) {
			return secondListNode;
		}
		if (null == secondListNode) {
			return firstListNode;
		}
		Node head = new Node(-1);
		Node current = head;
		while (firstListNode != null && secondListNode != null) {
			if (firstListNode.data <= secondListNode.data) {
				current.next = firstListNode;
				firstListNode = firstListNode.next;
			} else {
				current.next = secondListNode;
				secondListNode = secondListNode.next;
			}
			current = current.next;
		}
		if (null != firstListNode) {
			current.next = firstListNode;
		}
		if (null != secondListNode) {
			current.next = secondListNode;
		}
		return head.next;
	}

	// Taken from
	// https://discuss.leetcode.com/category/29/merge-two-sorted-lists
	private Node getMergedSortedListRecursion(Node firstListNode,
			Node secondListNode) {
		if (null == firstListNode && null == secondListNode) {
			return null;
		}
		if (null == firstListNode) {
			return secondListNode;
		}
		if (null == secondListNode) {
			return firstListNode;
		}
		Node head = new Node(-1);
		if (firstListNode.data <= secondListNode.data) {
			head = firstListNode;
			head.next = getMergedSortedListRecursion(firstListNode.next,
					secondListNode);
		} else {
			head = secondListNode;
			head.next = getMergedSortedListRecursion(firstListNode,
					secondListNode.next);
		}
		return head;
	}

	private Node getMiddle(Node head) {
		Node slowNode = head;
		Node fastNode = head;

		while (fastNode != null && fastNode.next != null
				&& fastNode.next.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}

		return slowNode;
	}

	// Taken from
	// http://javabypatel.blogspot.mx/2015/12/merge-sort-linked-list.html
	private Node mergeSortUsingIteration(Node startNode) {
		// Break the list until list is null or only 1 element is present in
		// List.
		if (startNode == null || startNode.next == null) {
			return startNode;
		}

		// Break the linklist into 2 list.
		// Finding Middle node and then breaking the Linled list in 2 parts.
		// Now 2 list are, 1st list from start to middle and 2nd list from
		// middle+1 to last.

		Node middle = getMiddle(startNode);
		Node nextOfMiddle = middle.next;
		middle.next = null;

		// Again breaking the List until there is only 1 element in each list.
		Node left = mergeSortUsingIteration(startNode);
		Node right = mergeSortUsingIteration(nextOfMiddle);

		// Once complete list is divided and contains only single element,
		// Start merging left and right half by sorting them and passing Sorted
		// list further.
		Node sortedList = getMergedSortedListUsingIteration(left, right);
		return sortedList;
	}

	// Taken from
	// http://javabypatel.blogspot.mx/2015/12/merge-sort-linked-list.html
	private Node mergeSortUsingRecursion(Node startNode) {
		// Break the list until list is null or only 1 element is present in
		// List.
		if (startNode == null || startNode.next == null) {
			return startNode;
		}

		// Break the linklist into 2 list.
		// Finding Middle node and then breaking the Linked list in 2 parts.
		// Now 2 list are, 1st list from start to middle and 2nd list from
		// middle+1 to last.

		Node middle = getMiddle(startNode);
		Node nextOfMiddle = middle.next;
		middle.next = null;

		// Again breaking the List until there is only 1 element in each list.
		Node left = mergeSortUsingRecursion(startNode);
		Node right = mergeSortUsingRecursion(nextOfMiddle);

		// Once complete list is divided and contains only single element,
		// Start merging left and right half by sorting them and passing Sorted
		// list further.
		Node sortedList = getMergedSortedListRecursion(left, right);
		return sortedList;
	}

	private Node reverseEveryKNodes(int k) {
		Node current = head;
		Node previous = null;
		Node next = null;

		int count = 0;
		while (count < k && null != current) {
			current = current.next;

			current.next = previous;
			previous = current;
			current = next;
		}

		if (null != current) {
		   head.next = reverseEveryKNodes(k);  		
		}

		return previous;
	}

}
