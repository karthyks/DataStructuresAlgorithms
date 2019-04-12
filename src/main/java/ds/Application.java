package ds;

import ds.heap.Heap;
import ds.heap.MaxHeap;
import ds.heap.MinHeap;
import ds.node.NodePrinter;

import java.util.Random;

public class Application {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{13, 11, 16, 9, 6, 5, 12, 20, 10, 7, 8, 4, 3, 1, 16};
        Heap<Integer> minHeap = new MinHeap<>();
        Heap<Integer> maxHeap = new MaxHeap<>();
        for (Integer i : array) {
            minHeap.addNode(i);
            maxHeap.addNode(i);
        }

        for (int i = 0; i < 100000; i++) {
            System.out.print(new Random().nextInt(100000) + " ");
        }
//        processMinHeap(minHeap);
//        processMaxHeap(maxHeap);
    }



    private static void processMinHeap(Heap<Integer> minHeap) {
        while (!minHeap.isEmpty()) {
            Integer nextMin = minHeap.poll();
            System.out.println(nextMin);
//            printHeap(minHeap);
        }
    }

    private static void processMaxHeap(Heap<Integer> maxHeap) {
        printHeap(maxHeap);
        maxHeap.removeNode(7);
        printHeap(maxHeap);
        maxHeap.addNode(12);
        maxHeap.addNode(18);
        printHeap(maxHeap);
    }

    private static <T> void printHeap(Heap<T> heap) {
        System.out.println(" ----------------------------------------------------------------------------------------");
        NodePrinter.print(heap.get());
    }
}
