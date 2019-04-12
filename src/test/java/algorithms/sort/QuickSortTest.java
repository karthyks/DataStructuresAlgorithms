package algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

public class QuickSortTest {
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
    public void checkSmallArrayIfSorted() {
        QuickSort.of(smallArray, 0, smallArray.length - 1);
        assertArrayIfSorted(smallArray);
    }

    @Test
    public void checkLargeArrayIfSorted() {
        QuickSort.of(largerArray, 0, largerArray.length - 1);
        assertArrayIfSorted(largerArray);
    }

    private void assertArrayIfSorted(Integer[] array) {
        int previousElement = array[0];
        for (Integer integer : array) {
            System.out.println(previousElement);
            int current = integer;
            Assert.assertTrue("Previous value " + previousElement + " should be lesser than  or equals to current value " + current, previousElement <= current);
            previousElement = current;
        }
    }
}