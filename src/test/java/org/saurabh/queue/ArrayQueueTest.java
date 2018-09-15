package org.saurabh.queue;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author Saurabh, Chitransh
 */
public class ArrayQueueTest {

    @Test
    public void testSize () throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        assertEquals(0, queue.size());

        queue.enqueue(10);
        assertEquals(1, queue.size());

        queue.enqueue(20);
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testIsEmpty () throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        assertEquals(true, queue.isEmpty());

        queue.enqueue(10);
        assertEquals(false, queue.isEmpty());

        queue.enqueue(20);
        assertEquals(false, queue.isEmpty());

        queue.dequeue();
        assertEquals(false, queue.isEmpty());

        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testEnqueueAndDequeue () throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        queue.enqueue(10);
        assertTrue(queue.dequeue().equals(10));

        queue.enqueue(20);
        queue.enqueue(30);
        assertTrue(queue.dequeue().equals(20));
        assertTrue(queue.dequeue().equals(30));

        assertEquals(0, queue.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyDequeue () throws Exception {
        new ArrayQueue<>().dequeue();
    }

    @Test
    public void testIterator () throws Exception {
        List<Integer> compareList = Lists.newArrayList(10, 20, 30, 40);
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (Integer compareListElement : compareList) {
            queue.enqueue(compareListElement);
        }

        assertEquals(queue.size(), compareList.size());

        Iterator<Integer> iterator = queue.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(compareList.get(index++), iterator.next());
        }
    }
}