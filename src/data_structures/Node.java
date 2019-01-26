package data_structures;

public class Node {
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
		if (mData != -1 && null == data) {
			return "[Int:" + mData + "]";
		} else if (mData == 0 && null != data) {
			return "[" + data + "]";
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		Node node = (Node) obj;
		return node.mData == mData || node.data.equals(data);
	}

}
