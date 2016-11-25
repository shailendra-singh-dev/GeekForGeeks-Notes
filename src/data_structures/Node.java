package data_structures;

public class Node {
    // reference to the next node in the chain,
    // or null if there isn't one.
    Node next;
    // data carried by this node.
    // could be of any type you need.
    Object data;
    int _intData;

    // Node constructor
    public Node(Object _data) {
	next = null;
	data = _data;
    }

    public Node(int _data) {
	next = null;
	_intData = _data;
    }

    public int getIntData() {
        return _intData;
    }

    public void setIntData(int _intData) {
        this._intData = _intData;
    }

    // another Node constructor if we want to
    // specify the node to point to.
    public Node(Object _data, Node _next) {
	next = _next;
	data = _data;
    }

    // these methods should be self-explanatory
    public Object getData() {
	return data;
    }

    public void setData(Object _data) {
	data = _data;
    }

    public Node getNext() {
	return next;
    }

    public void setNext(Node _next) {
	next = _next;
    }

    @Override
    public String toString() {
	return "[" + data + "]";
    }
}
