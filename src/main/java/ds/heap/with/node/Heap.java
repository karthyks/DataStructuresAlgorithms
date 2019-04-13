package ds.heap.with.node;

import ds.node.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Heap<T> {

    private Node<T> root;

    Heap() {
        root = new Node<>();
    }

    public void addNode(T value) {
        if (root.value == null) {
            root.value = value;
            return;
        }
        Node<T> node = new Node<>();
        node.value = value;
        Node<T> openNode = getOpenPosition();
        if (openNode != null) {
            node.parent = openNode;
            if (openNode.left == null) {
                openNode.left = node;
            } else {
                openNode.right = node;
            }
        }
        heapify(node);
    }

    private boolean isLeaf(Node<T> node) {
        return node.left == null && node.right == null;
    }

    private void removeNode(Node<T> node) {
        if (isLeaf(node)) {
            if (node.parent == null) root = null;
            else {
                if (node.parent.left != null && node.parent.left.value == node.value) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            }
        } else {
            Node<T> chosenParent = chooseParent(node.left, node.right);
            Node<T> finalNode = node;
            while (chosenParent != null) {
                swap(chosenParent, finalNode);
                finalNode = chosenParent;
                chosenParent = chooseParent(chosenParent.left, chosenParent.right);
            }
            if (finalNode.parent.left != null && finalNode.parent.left.value == finalNode.value) {
                finalNode.parent.left = null;
            } else {
                finalNode.parent.right = null;
            }
        }
    }

    public T poll() {
        if (isEmpty()) return null;
        Node<T> node = get();
        removeNode(node.value);
        return node.value;
    }

    public T peek() {
        if (isEmpty()) return null;
        return get().value;
    }

    public boolean isEmpty() {
        return get() == null || get().value == null;
    }

    public void removeNode(T value) {
        depthFirstSearch(node1 -> node1.value == value, this::removeNode);
    }

    private void heapify(Node<T> node) {
        if (node.parent == null) return;
        Node<T> chosenParent = chooseParent(node, node.parent);
        if (chosenParent.value != node.value) {
            return;
        }
        swap(node, node.parent);
        heapify(node.parent);
    }

    abstract Node<T> chooseParent(Node<T> a, Node<T> b);

    private void swap(Node<T> a, Node<T> b) {
        T temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public Node<T> get() {
        return root;
    }

    private void breadthFirstSearch(Predicate<Node<T>> predicate, Consumer<Node<T>> action) {
        Queue<Node<T>> queue = new LinkedList<>();
        HashSet<Node<T>> seen = new HashSet<>();
        queue.offer(get());
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if (seen.add(node)) {
                /**
                 * Not seen
                 */
                if (predicate.test(node)) {
                    action.accept(node);
                    return;
                }
            }
            if (node.left != null) {
                if (!seen.contains(node.left)) {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!seen.contains(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
    }

    private Node<T> getOpenPosition() {
        AtomicReference<Node<T>> toReturn = new AtomicReference<>();
        breadthFirstSearch(node -> node.left == null || node.right == null, node -> {
            if (node.left == null || node.right == null) {
                toReturn.set(node);
            }
        });
        return toReturn.get();
    }

    private void depthFirstSearch(Predicate<Node<T>> predicate, Consumer<Node<T>> action) {
        Stack<Node<T>> stack = new Stack<>();
        HashSet<Node<T>> seen = new HashSet<>();
        stack.push(get());
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            if (seen.add(node)) {
                /**
                 * Not seen
                 */
                if (predicate.test(node)) {
                    action.accept(node);
                    return;
                }
            }
            if (node.left != null) {
                if (!seen.contains(node.left)) {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                if (!seen.contains(node.right)) {
                    stack.push(node.right);
                }
            }
        }
    }
}