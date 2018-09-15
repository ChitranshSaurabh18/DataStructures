package org.saurabh.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Saurabh, Chitransh
 */
public class LinkedQueue<T> implements IQueue<T> {

    private Node rear;
    private Node front;
    private int size;

    private class Node {
        private T value;
        private Node next;

        public Node (T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedQueue () {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public int size () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return size == 0;
    }

    @Override
    public void enqueue (T value) {
        Node newNode = new Node(value, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue () {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T value = front.value;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return value;
    }

    @Override
    public Iterator<T> iterator () {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

        private Node current = front;

        @Override
        public boolean hasNext () {
            return current != null;
        }

        @Override
        public T next () {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
