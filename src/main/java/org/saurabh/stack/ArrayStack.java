package org.saurabh.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Saurabh, Chitransh
 */
@SuppressWarnings("unchecked")
public class ArrayStack<T> implements IStack<T> {

    private T[] array;      // last index element is the top most stack element
    private int n;          // n is the actual number of elements in the stack

    public ArrayStack () {
        this.array = (T[]) new Object[2];
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
    public void push (T value) {
        if (array.length == n) {
            resize(2 * n);
        }

        array[n] = value;
        n++;
    }

    @Override
    public T pop () {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }

        T value = array[n - 1];
        array[n - 1] = null;
        n = n - 1;

        if (n != 0 && array.length == 4 * n) {
            resize(array.length / 2);
        }

        return value;
    }

    @Override
    public T peek () {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }

        return array[n - 1];
    }

    private void resize (int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public Iterator<T> iterator () {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        private int index = n - 1;

        @Override
        public boolean hasNext () {
            return index >= 0;
        }

        @Override
        public T next () {
            T value = array[index];
            index = index - 1;
            return value;
        }
    }
}
