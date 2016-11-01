package arrays;

public class LinkedList {
    // reference to the head node.
    private Node head;
    private int listCount;

    // LinkedList constructor
    public LinkedList() {
	// this is an empty list, so the reference to the head node
	// is set to a new node with no data
	head = new Node(null);
	listCount = 0;
    }

    public void add(Node node) {
	// post: appends the specified element to the end of this list.
	Node current = head;
	// starting at the head node, crawl to the end of the list
	while (current.getNext() != null) {
	    current = current.getNext();
	}
	// the last node's "next" reference set to our new node
	current.setNext(node);
	listCount++;// increment the number of elements variable
    }

    public void add(int index, Node node) {
	// post: inserts the specified element at the specified position in this
	// list.
	Node current = head;
	// crawl to the requested index or the last element in the list,
	// whichever comes first
	for (int i = 0; i < index; i++) {
	    if (current.getNext() != null) {
		current = current.getNext();
		continue;
	    }
	}
	// set the new node's next-node reference to this node's next-node
	// reference
	// now set this node's next-node reference to the new node
	current.setNext(node);
	listCount++;// increment the number of elements variable
    }

    public Node get(int index) {
	// post: returns the element at the specified position in this list.
	// index must be 0 or higher
	if (index < 0)
	    return null;

	Node current = head.getNext();
	for (int i = 0; i < index; i++) {
	    if (null != current.getNext()) {
		current = current.getNext();
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
	    current = current.getNext();
	}
	current.setNext(current.getNext().getNext());
	listCount--; // decrement the number of elements variable
	return true;
    }

    public int size() {
	// post: returns the number of elements in this list.
	return listCount;
    }

    public String toString() {
	Node current = head.getNext();
	String output = "[";
	while (current != null) {
	    output += "[" + current.getData().toString() + "],";
	    current = current.getNext();
	}
	output = output.substring(0, output.length() - 1);
	output += "]";
	return output;
    }

}
