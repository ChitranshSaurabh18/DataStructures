package org.saurabh.stack;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.saurabh.queue.ArrayQueue;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author Saurabh, Chitransh
 */
public class ArrayStackTest {

    @Test
    public void testSize () throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertEquals(0, stack.size());

        stack.push(10);
        assertEquals(1, stack.size());

        stack.push(20);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void testIsEmpty () throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertEquals(true, stack.isEmpty());

        stack.push(10);
        assertEquals(false, stack.isEmpty());

        stack.push(20);
        assertEquals(false, stack.isEmpty());

        stack.pop();
        assertEquals(false, stack.isEmpty());

        stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testPushAndPop () throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(10);
        assertTrue(stack.pop().equals(10));

        stack.push(20);
        assertTrue(stack.pop().equals(20));

        assertEquals(0, stack.size());
    }

    @Test
    public void testPushAndPeek () throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(10);
        assertTrue(stack.peek().equals(10));

        stack.push(20);
        assertTrue(stack.peek().equals(20));

        assertEquals(2, stack.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPeek () throws Exception {
        new ArrayStack<>().peek();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPop () throws Exception {
        new ArrayStack<>().pop();
    }

    @Test
    public void testIterator () throws Exception {
        List<Integer> compareList = Lists.newArrayList(10, 20, 30, 40);
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (Integer compareListElement : compareList) {
            stack.push(compareListElement);
        }

        assertEquals(stack.size(), compareList.size());

        Iterator<Integer> iterator = stack.iterator();
        int index = compareList.size() - 1;
        while (iterator.hasNext()) {
            assertEquals(compareList.get(index--), iterator.next());
        }
    }
}