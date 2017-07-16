package data_structures;

public class Node {
	// reference to the next node in the chain,
	// or null if there isn't one.
	public Node next;
	public Node previous;
	// data carried by this node.
	// could be of any type you need.
	public int mData;

	// Node constructor
	public Node(int _data) {
		next = null;
		mData = _data;
	}

	@Override
	public String toString() {
		return "[" + mData + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		Node node = (Node) obj;
		return node.mData == mData;
	}

}
