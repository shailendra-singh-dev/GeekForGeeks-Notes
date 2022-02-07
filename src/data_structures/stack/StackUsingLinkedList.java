package data_structures.stack;

import data_structures.Node;

public class StackUsingLinkedList<E extends Node> {

	private static final int MAX_SIZE = 1000;
	private E mTop;
	private int mSize;

	public StackUsingLinkedList(int capacity) {
		mSize = capacity;
		mTop = null;
	}

	public boolean isEmpty() {
		return null == mTop;
	}

	public E push(E e) {
		E element = null;
		if (mSize == MAX_SIZE) {
			throw new RuntimeException("Stack Overflow");
		} else {
			if (null == mTop) {
				mTop = e;
			} else {
				e.next = mTop;
				mTop = e;
			}
			element = mTop;
		}
		mSize++;
		return element;
	}

	public E pop() {
		E element = null;
		if (isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		} else {
			E next = (E) mTop.next;
			element = mTop;
			mTop = next;
		}
		return element;
	}
	
	public E peek(){
		E element = null;
		if (isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		} else {
			element = mTop;
		}
		return element;
	}
	

}
