class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}

interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E removedElement = top.data;
        top = top.next;
        size--;
        return removedElement;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }
}
