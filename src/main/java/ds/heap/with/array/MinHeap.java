package ds.heap.with.array;

public class MinHeap<T extends Comparable<T>> extends Heap<T>  {

    @Override
    public int compare(int a, int b) {
        return minOf(a, b);
    }
}
