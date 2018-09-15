package org.saurabh.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Saurabh, Chitransh
 */
public class LinkedList<T> implements IList<T> {

    private Node first;
    private int size;

    private class Node {
        T value;
        Node next;

        public Node (T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedList () {
        this.first = null;
        this.size = 0;
    }

    @Override
    public int size () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return size() == 0;
    }

    @Override
    public void addFirst (T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node oldFirst = first;
            first = new Node(value, oldFirst);
        }
        size++;
    }

    @Override
    public void addLast (T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }

            // temp now points to the last node
            temp.next = new Node(value, null);
        }
        size++;
    }

    @Override
    public void add (T value, int index) {
        if (index > size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index == 0) {
            addFirst(value);
        } else {
            Node previous = null;
            Node current = first;

            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }

            assert previous != null;
            previous.next = new Node(value, current);
            size++;
        }
    }

    @Override
    public T getFirst () {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        return first.value;
    }

    @Override
    public T getLast () {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }

        // temp now points to the last node
        return temp.value;
    }

    @Override
    public T get (int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (index > size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }

    @Override
    public T removeFirst () {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T value = first.value;
        first = first.next;
        size--;
        return value;
    }

    @Override
    public T remove (int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (index > size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index == 0) {
            return removeFirst();
        }

        Node previous = null;
        Node current = first;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        T value = current.value;
        size--;

        assert previous != null;
        previous.next = current.next;
        return value;
    }

    @Override
    public void reverse () {
        Node a = null;
        Node b = first;
        Node c = first;

        // cn, cbn, bna, ab, bc, fa
        while (c != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        first = a;
    }

    @Override
    public void reversePairWise () {
        Node node = first;

        while (node != null && node.next != null) {
            T firstNodeVal = node.value;
            node.value = node.next.value;
            node.next.value = firstNodeVal;

            node = node.next.next;
        }
    }

    @Override
    public Iterator<T> iterator () {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

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
