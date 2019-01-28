package data_structures;

public class Node implements Comparable<Node>{
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

	// Node constructor
	public Node(String _data) {
		next = null;
		data = _data;
	}

	@Override
	public String toString() {
		if (null == data) {
			return "[" + mData + "]";
		} else {
			return "[" + data + "]";
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		Node node = (Node) obj;
		return null == data ? node.mData == mData : node.data.equals(data);
	}

	@Override
	public int compareTo(Node node) {
		if(null == data ? node.mData == mData : node.data.equals(data)) {
			return 1;
		}
		return 0;
	}

}
