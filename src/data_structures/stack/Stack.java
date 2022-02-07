package data_structures.stack;

public class Stack<E> {
	private static final int MAX_SIZE = 1000;
	private int mTop = 0;
	private int mSize = 0;
	private E[] mArray;
	
	public Stack(int capacity) {
		mTop = -1;
		mSize = capacity <= 0 ? MAX_SIZE : capacity;
		mArray = (E[]) new Object[capacity];
	}

	public void push(E e) {
		if (mTop == mSize - 1) {
			throw new RuntimeException("StackOverflow Exception");
		} else {
			mArray[++mTop] = e;
		}
	}

	public E pop() {
		if (isEmpty()) {
			throw new RuntimeException("StackUnderflow Exception");
		} else {
			return mArray[mTop--];
		}
	}

	public E peek() {
		if (isEmpty()) {
			throw new RuntimeException("StackUnderflow Exception");
		} else {
			return mArray[mTop];
		}
	}

	public void print() {
		for (E e : mArray) {
			System.out.print(e + " ");
		}
	}
	public boolean isEmpty() {
		return mTop == -1;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer("[");
		while (!isEmpty()) {
			stringBuffer.append(pop() + " ");
		}
		stringBuffer.append("]");
		return stringBuffer.toString();
	}

	private static final class StackException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		private String exceptionEessage;

		private StackException(String message) {
			exceptionEessage = message;
		}
	}


}
