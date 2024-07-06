package cracking.coding.interview.datastructures;

public class Tree<T> {
    public Node<T> root;

    public class Node<T> {
        public T data;
        public Node<T>[] children;
    }
}
