package org.saurabh.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Saurabh, Chitransh
 */
public class LinkedStack<T> implements IStack<T> {

    private Node first;
    private int  size;

    private class Node {
        private T value;
        private Node next;

        public Node (T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedStack () {
        this.first = null;
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
    public void push (T value) {
        Node oldFirst = first;
        first = new Node(value, oldFirst);
        size++;
    }

    @Override
    public T pop () {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }

        T value = first.value;
        first = first.next;
        size--;
        return value;
    }

    @Override
    public T peek () {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }

        return first.value;
    }

    @Override
    public Iterator<T> iterator () {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        private Node current = first;

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