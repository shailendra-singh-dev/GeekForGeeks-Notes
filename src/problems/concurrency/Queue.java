package problems.concurrency;
import java.util.Stack;

public class Queue<E> {

	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();

	public void queue(E e) {
		inbox.push(e);
	}

	public E deQueue() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
}
