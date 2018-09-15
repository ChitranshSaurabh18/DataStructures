package org.saurabh.list;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author Saurabh, Chitransh
 */
public class LinkedListTest {

    @Test
    public void testSize () throws Exception {
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());

        list.addFirst(1);
        assertEquals(1, list.size());

        list.addFirst(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty () throws Exception {
        IList<Integer> list = new LinkedList<>();
        assertEquals(true, list.isEmpty());

        list.addFirst(1);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testAddFirst () throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        assertTrue(list.get(0).equals(1));

        list.addFirst(2);
        assertTrue(list.get(0).equals(2));
    }

    @Test
    public void testAddLast () throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addLast(1);
        assertTrue(list.get(0).equals(1));

        list.addLast(2);
        assertTrue(list.get(1).equals(2));

        list.addLast(3);
        assertTrue(list.get(2).equals(3));
    }

    @Test
    public void testAdd () throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(2);
        list.addLast(5);
        list.add(3, 3);
        list.add(4, 4);

        assertTrue(list.get(0).equals(0));
        assertTrue(list.get(1).equals(1));
        assertTrue(list.get(2).equals(2));
        assertTrue(list.get(3).equals(3));
        assertTrue(list.get(4).equals(4));
        assertTrue(list.get(5).equals(5));
    }

    @Test
    public void testRemoveFirst () throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(2);
        list.addLast(5);
        list.add(3, 3);
        list.add(4, 4);

        assertTrue(list.removeFirst().equals(0));
        assertTrue(list.removeFirst().equals(1));
    }

    @Test
    public void testRemove () throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(2);
        list.addLast(5);
        list.add(3, 3);
        list.add(4, 4);

        assertTrue(list.remove(2).equals(2));
        assertTrue(list.remove(2).equals(3));
    }

    @Test
    public void testReverse () throws Exception {
        IList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }

        list.reverse();
        Iterator<Integer> iterator = list.iterator();
        int i = 9;
        while (iterator.hasNext()) {
            assertTrue(iterator.next().equals(i));
            i--;
        }
    }

    @Test
    public void testReversePairWise () throws Exception {
        IList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }

        list.reversePairWise();
        Iterator<Integer> iterator = list.iterator();
        int[] pairWiseReversedElements = {1, 0, 3, 2, 5, 4, 7, 6, 9, 8};

        int i = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next().equals(pairWiseReversedElements[i]));
            i++;
        }
    }

    @Test
    public void testIterator () throws Exception {
        IList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }

        assertEquals(10, list.size());

        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next().equals(i));
            i++;
        }
    }
}