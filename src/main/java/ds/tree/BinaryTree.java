package ds.tree;

import ds.node.Node;
import ds.node.NodePrinter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> rootNode;

    public BinaryTree() {
        rootNode = new Node<>();
    }

    public void add(T value) {
        if (rootNode.value == null) {
            rootNode.value = value;
        } else {
            Node<T> node1 = new Node<>();
            node1.value = value;
            addNode(node1);
        }
    }

    private void addNode(Node<T> node) {
        Node<T> start = rootNode;
        while (start != null) {
            if (node.value.compareTo(start.value) <= 0) {
                if (start.left == null) {
                    node.parent = start;
                    start.left = node;
                    break;
                } else {
                    start = start.left;
                }
            } else {
                if (start.right == null) {
                    node.parent = start;
                    start.right = node;
                    break;
                } else {
                    start = start.right;
                }
            }
        }
    }

    public void stream(Consumer<Node<T>> action) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(rootNode);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            action.accept(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void print() {
        NodePrinter.print(rootNode);
    }
}

