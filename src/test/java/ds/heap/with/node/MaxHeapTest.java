package ds.heap.with.node;

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
        scanner.close();
        file = new File(getClass().getClassLoader().getResource("array/largeArray.txt").getFile());
        scanner = new Scanner(file);
        largerArray = new Integer[scanner.nextInt()];
        for (int i = 0; i < largerArray.length; i++) {
            largerArray[i] = scanner.nextInt();
        }
        scanner.close();
    }

    @Test
    public void checkMaxHeapWithSmallArray() {
        Heap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < smallArray.length; i++) {
            heap.addNode(smallArray[i]);
        }

        int previousValue = heap.peek();

        while (!heap.isEmpty()) {
            int current = heap.poll();
            Assert.assertTrue("Previous value " + previousValue + " should be greater than  or equals to current value " + current, previousValue >= current);
            previousValue = current;
        }
    }

    @Test
    public void checkMaxHeapWithLargeArray() {
        Heap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < largerArray.length; i++) {
            heap.addNode(largerArray[i]);
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