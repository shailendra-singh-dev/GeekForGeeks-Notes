package data_structures.queue;

import java.util.Stack;

public class QueueUsingTwoStacks<E> {

	private Stack<E> mStack1 = new Stack<E>();
	private Stack<E> mStack2 = new Stack<E>();;

	public void enqueue(E e) {
		mStack1.push(e);
	}

	public E dequeue() {
		if (mStack2.isEmpty()) {
			while (!mStack1.isEmpty()) {
				E item = mStack1.pop();
				mStack2.push(item);
			}
		}
		E e = mStack2.pop();
		return e;
	}

	public void print() {
		if(mStack1.isEmpty()){
			for (int i = 0; i < mStack2.size(); i++) {
				System.out.print(" " + mStack2.get(i));
			}		
		}
		if(mStack2.isEmpty()){
			for (int i = 0; i < mStack1.size(); i++) {
				System.out.print(" " + mStack1.get(i));
			}		
		}
		
	
	}

	public static void test() {
		QueueUsingTwoStacks<Integer> queueUsingTwoStacks = new QueueUsingTwoStacks<Integer>();
		queueUsingTwoStacks.enqueue(10);
		queueUsingTwoStacks.enqueue(20);
		queueUsingTwoStacks.enqueue(30);

		queueUsingTwoStacks.print();

		int dequedElement1 = queueUsingTwoStacks.dequeue();
		System.out.println();
		System.out.print("dequedElement1:" + dequedElement1);

		int dequedElement2 = queueUsingTwoStacks.dequeue();
		System.out.println();
		System.out.print("dequedElement2:" + dequedElement2);

		System.out.println();
		queueUsingTwoStacks.print();

	}
}
