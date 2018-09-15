package org.saurabh.list;

import java.util.Iterator;

/**
 * @author Saurabh, Chitransh
 */
public class DoublyLinkList<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        T value;
        Node prev;
        Node next;

        public Node (T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkList () {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return size() == 0;
    }

    public void addFirst (T value) {
        if (isEmpty()) {
            Node node = new Node(value, null, null);
            this.first = node;
            this.last = node;
        } else {
            Node newFirstNode = new Node(value, null, this.first);
            this.first.prev = newFirstNode;
            this.first = newFirstNode;
        }
        size++;
    }

    public void addLast (T value) {
        if (isEmpty()) {
            Node node = new Node(value, null, null);
            this.first = node;
            this.last = node;
        } else {
            Node newLastNode = new Node(value, this.last, null);
            this.last.next = newLastNode;
            this.last = newLastNode;
        }
        size++;
    }

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
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            Node prev = node.prev;
            Node newNode = new Node(value, prev, node);
            prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    @Override
    public Iterator<T> iterator () {
        return new DoublyLinkListIterator();
    }

    private class DoublyLinkListIterator implements Iterator<T> {

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
