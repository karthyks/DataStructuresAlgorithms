package ds.heap;

import ds.node.Node;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    @Override
    Node<T> chooseParent(Node<T> a, Node<T> b) {
        int result = a.value.compareTo(b.value);
        switch (result) {
            case -1:
                return b;
            case 1:
                return a;
            default:
                return a;
        }
    }
}