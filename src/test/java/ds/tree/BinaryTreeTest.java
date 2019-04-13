package ds.tree;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

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
    public void checkBinaryTreePropertyWithSmallArray() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (Integer integer : smallArray) {
            tree.add(integer);
        }
        tree.stream(node -> {
            if (node.left != null) {
                assertTrue("Left should be lesser than " + node.value, node.left.value.compareTo(node.value) <= 0);
            }
            if (node.right != null) {
                assertTrue("Right should be greater than " + node.value, node.right.value.compareTo(node.value) >= 0);
            }
        });
    }

    @Test
    public void checkBinaryTreePropertyWithLargeArray() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (Integer integer : largerArray) {
            tree.add(integer);
        }
        tree.stream(node -> {
            if (node.left != null) {
                assertTrue("Left should be lesser than " + node.value, node.left.value.compareTo(node.value) <= 0);
            }
            if (node.right != null) {
                assertTrue("Right should be greater than " + node.value, node.right.value.compareTo(node.value) >= 0);
            }
        });
    }
}