package ds.heap.with.array;

import ds.node.Node;

import java.util.Arrays;

public abstract class Heap<T extends Comparable<T>> {

    private Node<T>[] array;
    private int size = 0;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        array = new Node[capacity];
    }

    public Heap() {
        this(10);
    }

    public T peek() {
        if (size == 0) throw new IllegalStateException();
        return array[0].value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T poll() {
        if (size == 0) throw new IllegalStateException();
        Node<T> item = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
        return item.value;
    }

    public void add(T value) {
        ensureCapacity();
        Node<T> node = new Node<>();
        node.value = value;
        array[size] = node;
        size++;
        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0;
        while (getLeft(index) != -1) {
            int compare = compare(getLeft(index), getRight(index));
            int compareWithThis = compare(index, compare);
            if (compareWithThis != index) {
                swap(index, compareWithThis);
            } else {
                break;
            }
            index = compareWithThis;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (getParent(index) != -1 && compare(getParent(index), index) == index) {
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    private boolean isLeaf(int position) {
        return position > size / 2 && position < size;
    }

    private int getParent(int position) {
        if (position == 0) return -1;
        int parent = (position - 1) / 2;
        return isInBounds(parent, size) ? parent : -1;
    }

    private int getLeft(int position) {
        int left = 2 * position + 1;
        return isInBounds(left, size) ? left : -1;
    }

    private int getRight(int position) {
        int right = 2 * position + 2;
        return isInBounds(right, size) ? right : -1;
    }

    private boolean isInBounds(int index, int arraySize) {
        return index < arraySize && index >= 0;
    }

    public abstract int compare(int a, int b);

    int maxOf(int a, int b) {
        if (a < 0 && b < 0) return -1;
        if (a < 0) return b;
        if (b < 0) return a;
        int comparison = array[a].value.compareTo(array[b].value);
        return comparison >= 0 ? a : b;
    }

    int minOf(int a, int b) {
        if (a < 0 && b < 0) return -1;
        if (a < 0) return b;
        if (b < 0) return a;
        int comparison = array[a].value.compareTo(array[b].value);
        return comparison <= 0 ? a : b;
    }

    private void swap(int a, int b) {
        Node<T> temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            array = Arrays.copyOf(array, capacity * 2);
            capacity *= 2;
        }
    }
}
