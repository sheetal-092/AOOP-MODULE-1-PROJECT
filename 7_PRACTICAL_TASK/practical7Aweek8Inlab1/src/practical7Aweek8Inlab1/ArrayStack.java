package practical7Aweek8Inlab1;

public class ArrayStack<T> implements Stack<T> {
	private T[] stack;
    private int top;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        stack = (T[]) new Object[INITIAL_CAPACITY];
        top = -1;
    }

    @Override
    public void push(T item) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
