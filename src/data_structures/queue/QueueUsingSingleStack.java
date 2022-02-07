package data_structures.queue;

import java.util.Stack;

public class QueueUsingSingleStack<E> {

	private Stack<E> mStack = new Stack<E>();

	public void enqueue(E e) {
		mStack.push(e);
	}

	public E deQueue() {
		E deqeuedElement = null;
		if (1 == mStack.size()) {
			return mStack.pop();
		} else {
			/* pop an item from the stack */
			E popedElement = mStack.pop();
			/* store the last dequeued item */
			deqeuedElement = deQueue();
			/* push everything back to stack */
			mStack.push(popedElement);
		}
		return deqeuedElement;
	}

	public void print() {
		for (int i = 0; i < mStack.size(); i++) {
			System.out.print(" " + mStack.get(i));
		}
	}

	public static void test() {
		QueueUsingSingleStack<Integer> queueUsingSingleStack = new QueueUsingSingleStack<Integer>();
		queueUsingSingleStack.enqueue(10);
		queueUsingSingleStack.enqueue(20);
		queueUsingSingleStack.enqueue(30);

		queueUsingSingleStack.print();
		
		System.out.println();
		int dequedElement1 = queueUsingSingleStack.deQueue();
		System.out.print("dequedElement1:" + dequedElement1);

		System.out.println();
		queueUsingSingleStack.print();
		
		System.out.println();
		int dequedElement2 = queueUsingSingleStack.deQueue();
		System.out.print("dequedElement2:" + dequedElement2);

		System.out.println();
		queueUsingSingleStack.print();

		System.out.println();
		System.out.print("enqueue(40)");
		queueUsingSingleStack.enqueue(40);
		System.out.println();
		queueUsingSingleStack.print();
		
		System.out.println();
		int dequedElement3 = queueUsingSingleStack.deQueue();
		System.out.print("dequedElement3:" + dequedElement3);

		System.out.println();
		queueUsingSingleStack.print();
	}

}
