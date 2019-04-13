package ds.heap.with.array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

public class MaxHeapTest {

    Integer[] smallArray;
    Integer[] largerArray;

    @Before
    public void setUp() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("array/defaultArray.txt").getFile());
        Scanner scanner = new Scanner(file);
        smallArray = new Integer[scanner.nextInt()];
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = scanner.nextInt();
        }

        file = new File(getClass().getClassLoader().getResource("array/largeArray.txt").getFile());
        scanner = new Scanner(file);
        largerArray = new Integer[scanner.nextInt()];
        for (int i = 0; i < largerArray.length; i++) {
            largerArray[i] = scanner.nextInt();
        }
    }

    @Test
    public void checkMinHeapWithSmallArray() {
        Heap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < smallArray.length; i++) {
            heap.add(smallArray[i]);
        }

        int previousValue = heap.peek();

        while (!heap.isEmpty()) {
            int current = heap.poll();
            Assert.assertTrue("Previous value " + previousValue + " should be greater than  or equals to current value " + current, previousValue >= current);
            previousValue = current;
        }
    }

    @Test
    public void checkMinHeapWithLargeArray() {
        Heap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < largerArray.length; i++) {
            heap.add(largerArray[i]);
        }

        int previousValue = heap.peek();

        while (!heap.isEmpty()) {
            int current = heap.poll();
            Assert.assertTrue("Previous value " + previousValue + " should be greater than  or equals to current value " + current, previousValue >= current);
            previousValue = current;
        }
    }

    @After
    public void tearDown() throws Exception {
        smallArray = null;
        largerArray = null;
    }
}