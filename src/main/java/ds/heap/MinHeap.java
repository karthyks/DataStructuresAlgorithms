package ds.heap;

import ds.node.Node;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    @Override
    Node<T> chooseParent(Node<T> a, Node<T> b) {
        if (a == null && b == null) return null;
        else if (a == null) return b;
        else if (b == null) return a;
        else {
            int result = a.value.compareTo(b.value);
            switch (result) {
                case -1:
                    return a;
                case 1:
                    return b;
                default:
                    return a;
            }
        }
    }
}