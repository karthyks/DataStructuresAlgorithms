package ds.node;

public class Node<T> {
    public Node<T> parent = null;
    public Node<T> left = null;
    public Node<T> right = null;
    public T value = null;

    @Override
    public String toString() {
        return value == null ? "null" : value.toString();
    }
}