class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}

interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E removedElement = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removedElement;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }
}
