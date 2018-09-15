package org.saurabh.queue;

/**
 * @author Saurabh, Chitransh
 */
public interface IQueue<T> extends Iterable<T> {

    void enqueue (T value);

    T dequeue ();

    int size ();

    boolean isEmpty ();
}
