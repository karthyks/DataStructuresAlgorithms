package ds.heap.with.array;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    @Override
    public int compare(int a, int b) {
        return maxOf(a, b);
    }
}