package cracking.coding.interview.datastructures;

import java.util.Comparator;

public class Tree<T extends Comparable<T>> {
    public Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public void add(T val) {
        add(val, root, new NaturalComparator<>());
    }

    public void printTree() {
        printTree(root);
    }

    public void printTree(Node<T> node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }
    }

    public Node<T> add(T val, Node<T> current, Comparator<T> comparator) {
        if (current == null) {
            return new Node<>(val);
        }

        if (comparator.compare(val, current.data) < 0) {
            current.left = add(val, current.left, comparator);
        } else if (comparator.compare(val, current.data) > 0) {
            current.right = add(val, current.right, comparator);
        }

        return current;

    }

    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
        }


    }

    public Integer compare(T val1, T val2) {
        var naturalComparator =  new NaturalComparator<T>();
        return naturalComparator.compare(val1, val2);
    }

    static class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }
}
