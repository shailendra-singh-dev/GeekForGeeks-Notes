package problems.concurrency;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {

	private static final int CAPACITY = 10;
	private Random mRandom = new Random();
	private Lock mLock = new ReentrantLock();
	private Condition mBufferNotEmpty = mLock.newCondition();
	private Condition mBufferNotFull = mLock.newCondition();
	private Queue<Integer> mQueue = new LinkedList<Integer>();

	public void put() {
		mLock.lock();
		try {
			while (mQueue.size() == CAPACITY) {
				try {
					mBufferNotEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int element = mRandom.nextInt();
			boolean isAdded = mQueue.offer(element);
			if (isAdded) {
				System.out.println("Added element:" + element);
				mBufferNotFull.signalAll();
			}
		} finally {
			mLock.unlock();
		}
	}

	public int get() {
		mLock.lock();
		int element = -1;
		try {
			while (mQueue.size() == 0) {
				try {
					mBufferNotFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			element = mQueue.poll();
			System.out.println("Removed element:" + element);
			mBufferNotEmpty.signalAll();
		} finally {
			mLock.unlock();
		}
		return element;
	}
	
	
}
