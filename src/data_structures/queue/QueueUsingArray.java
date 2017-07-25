package data_structures.queue;

public class QueueUsingArray<E extends Object> {

	private static final int MAX_SIZE = 1000;
	private int mSize;
	private E[] mArray;
	private int mFront;
	private int mRear;

	public QueueUsingArray(int capacity) {
		mSize = capacity < 0 ? MAX_SIZE : capacity;
		mArray = (E[]) new Object[mSize];
	}

	public boolean isEmpty() {
		return -1 == mFront && -1 == mRear;
	}

	public void enqueue(E e) {
		if (mFront == ((mRear + 1) % mSize)) { // Full
			return;
		} else if (isEmpty()) {
			mFront = mRear = 0;
		} else {
			mRear = (mRear + 1) % mSize;
		}
		mArray[mRear] = e;
	}

	public E dequeue() {
		if(isEmpty()){
			
		}
		
	}

}
