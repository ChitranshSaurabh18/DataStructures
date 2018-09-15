package org.saurabh.stack;

/**
 * @author Saurabh, Chitransh
 */
public interface IStack<T> extends Iterable<T> {

    void push (T value);

    T pop ();

    T peek ();

    int size ();

    boolean isEmpty ();
}
