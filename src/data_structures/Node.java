package data_structures;

public class Node {
	// reference to the next node in the chain,
	// or null if there isn't one.
	Node next;
	// data carried by this node.
	// could be of any type you need.
	Object data;

	// Node constructor
	public Node(Object _data) {
		next = null;
		data = _data;
	}

	// another Node constructor if we want to
	// specify the node to point to.
	public Node(Object _data, Node _next) {
		next = _next;
		data = _data;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}
}
