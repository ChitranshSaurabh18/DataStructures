package org.saurabh.list;

/**
 * @author Saurabh, Chitransh
 */
public interface IList<T> extends Iterable<T> {

    int size ();

    boolean isEmpty ();

    T get (int index);

    T removeFirst ();

    T remove (int index);

    void add (T value, int index);

    void addFirst (T value);

    void addLast (T value);

    T getFirst ();

    T getLast ();

    void reverse ();

    void reversePairWise ();
}
