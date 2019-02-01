package data_structures;

public class Node implements Comparable<Node> {
	// reference to the next node in the chain,
	// or null if there isn't one.
	public Node next;
	public Node previous;
	// data carried by this node.
	// could be of any type you need.
	public int mData;
	public String data;

	// Node constructor
	public Node(int _data) {
		next = null;
		mData = _data;
	}

	public Node(String _data) {
		next = null;
		data = _data;
	}

	@Override
	public String toString() {
		if (null != data) {
			return "[" + data + "]";
		} else {
			return "[" + mData + "]";
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		Node node = (Node) obj;
		if (null != data) {
			return data.equals(node.data);
		} else {
			return mData == node.mData;
		}
	}

	@Override
	public int compareTo(Node obj) {
		if (null == obj)
			return 0;
		Node node = (Node) obj;
		if (null != data) {
			return data.compareTo(node.data);
		} else {
			return mData - node.mData;
		}
	}

}
