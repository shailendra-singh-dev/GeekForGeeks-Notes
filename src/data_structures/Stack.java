package data_structures;

public class Stack<E> {
    private int top = 0;
    private int stackSize = 0;
    private E[] elements;

    public Stack(int capacity) {
	stackSize = capacity;
	top = -1;
	elements = (E[]) new Object[stackSize];
    }

    public void push(E e) {
	if (top == stackSize) {
	    throw new StackException("StackOverFlow. Stack is full");
	}
	top++;
	elements[top] = e;
    }

    public E pop() {
	if (top == -1) {
	    throw new StackException("StackUnderFlow.Stack is empty");
	}
	top--;
	return elements[top];
    }

    public E peek() {
	if (top == -1) {
	    throw new StackException("StackUnderFlow.Stack is empty");
	}
	return elements[top];
    }

    public boolean isEmpty() {
	return top == -1;
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
