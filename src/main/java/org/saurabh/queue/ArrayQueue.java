package org.saurabh.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Saurabh, Chitransh
 */
@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements IQueue<T> {

    private T[] array;
    private int front;          // front is pointing at the index of the first element
    private int rear;           // rear is pointing one index ahead of the last element
    private int n;              // n is the actual number of elements in the queue

    public ArrayQueue () {
        this.array = (T[]) new Object[2];
        this.front = 0;
        this.rear = 0;
        this.n = 0;
    }

    @Override
    public int size () {
        return n;
    }

    @Override
    public boolean isEmpty () {
        return n == 0;
    }

    @Override
    public void enqueue (T value) {
        if (array.length == n) {
            resize(2 * n);
        }

        array[rear] = value;
        rear++;
        n++;

        if (rear == array.length) {
            rear = 0;   // wrap around when rear index overflows at the end
        }

    }

    @Override
    public T dequeue () {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T value = array[front];
        array[front] = null;
        n--;
        front++;

        if (front == array.length) {
            front = 0;  // wrap around when front index overflows at the end
        }

        if (n > 0 && array.length == 4 * n) {
            resize(array.length / 2);
        }

        return value;
    }

    private void resize (int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            int actualIndex = (front + i) % array.length;
            temp[i] = array[actualIndex];
        }

        array = temp;
        front = 0;
        rear = n;
    }

    @Override
    public Iterator<T> iterator () {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

        private int i = 0;

        @Override
        public boolean hasNext () {
            return i < n;
        }

        @Override
        public T next () {
            T value = array[(front + i) % array.length];
            i++;
            return value;
        }
    }
}
