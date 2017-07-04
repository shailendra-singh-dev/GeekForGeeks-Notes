package data_structures;

public class StackTemp<E> {
	private static final int MAX_SIZE = 1000;
	private int mSize;
	private E[] mArray;
	private int mTop;

	public StackTemp(int size) {
		mTop = -1;
		mSize = size <= 0 ? MAX_SIZE : size;
		mArray = (E[]) new Object[size];
	}

	public boolean isEmpty() {
		return mTop == -1;
	}

	public E push(E e) {
		if (mTop == mSize - 1) {
			throw new RuntimeException("StackOverflow Exception");
		} else {
			mArray[++mTop] = e;
			return e;
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
}
