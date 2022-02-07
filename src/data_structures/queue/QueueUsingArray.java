package data_structures.queue;

import java.util.Arrays;

public class QueueUsingArray<E extends Object> {

	private static final int MAX_SIZE = 1000;
	private int mSize;
	private E[] mArray;
	private int mFront;
	private int mRear;

	public QueueUsingArray(int capacity) {
		mSize = capacity <= 0 ? MAX_SIZE : capacity;
		mArray = (E[]) new Object[mSize];
		mFront = -1;
		mRear = -1;
	}

	public boolean isEmpty() {
		return (-1 == mFront && -1 == mRear);
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
		System.out.println("enqueue(),mRear:" + mRear + ",e:" + e);
	}

	public E dequeue() {
		E e = null;
		if (isEmpty()) {
			return null;
		} else if (mFront == mRear) {
			mFront = mRear = -1;
		} else {
			e = mArray[mFront];
			System.out.println("dequeue(),mFront:" + mFront + ",e:" + e);
			mFront = (mFront + 1) % mSize;
		}
		return e;
	}

	public E getFront() {
		return mArray[mFront];
	}

	public E getRear() {
		return mArray[mRear];
	}

	public void print() {
		String array=Arrays.toString(mArray);
		System.out.println(array);
	}

	public static void test() {
		QueueUsingArray<Integer> queueUsingArray = new QueueUsingArray<Integer>(
				5);
		queueUsingArray.enqueue(10);
		queueUsingArray.enqueue(20);
		queueUsingArray.enqueue(30);
		queueUsingArray.enqueue(40);
		queueUsingArray.enqueue(50);
		queueUsingArray.enqueue(60);

		queueUsingArray.print();

		System.out.println();

		int dequedElemet = queueUsingArray.dequeue();
		System.out.print("dequedElemet:" + dequedElemet);
		System.out.println();
		queueUsingArray.print();

		System.out.println();
		int dequedElemet1 = queueUsingArray.dequeue();
		System.out.print("dequedElemet1:" + dequedElemet1);
		System.out.println();
		queueUsingArray.print();

		System.out.println();
		int dequedElemet2 = queueUsingArray.dequeue();
		System.out.print("dequedElemet2:" + dequedElemet2);
		System.out.println();

		queueUsingArray.print();
		System.out.println();

		queueUsingArray.enqueue(70);
		queueUsingArray.enqueue(80);

		queueUsingArray.print();
	}
}
