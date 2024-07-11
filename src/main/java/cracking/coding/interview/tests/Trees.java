package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.Tree;

import java.util.*;

public class Trees {

    //    4.2
    //    Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
    //    algorithm to create a binary search tree with minimal height.
    //    Hints: #19, #73, #116
    public static <T extends Comparable<T>> Tree<T> createBinarySearchTree(List<T> arr) {

        int middle = arr.size() % 2 == 0 ? arr.size() / 2 : arr.size() / 2 + 1;

        Tree<T> tree = new Tree<>(new Tree.Node<>(arr.remove(middle)));

        add(tree, new ArrayList<>(arr.subList(0, middle)));
        add(tree, new ArrayList<>(arr.subList(middle, arr.size())));

        return tree;
    }

    // 4.2
    private static <T extends Comparable<T>> void add(Tree<T> tree, List<T> arr) {
        int middle = (arr.size() / 2);
        if (!arr.isEmpty()) {
            tree.add(arr.remove(middle));
            add(tree, new ArrayList<>(arr.subList(0, middle)));
            add(tree, new ArrayList<>(arr.subList(middle, arr.size())));
        }
    }


    //    4.3
    //    List of Depths: Given a binary tree, design an algorithm which creates a linked listof all the nodes
    //    at each depth (e.g., if you have a tree with depth D, youll have D linked lists).
    //    Hints: #107,#123, #135
    public static <T extends Comparable<T>> List<LinkedList<Tree.Node<T>>> getListOfNodes(Tree<T> tree) {

        LinkedList<LinkedList<Tree.Node<T>>> matrix = new LinkedList<>();

        LinkedList<Tree.Node<T>> rootList = new LinkedList<>();
        rootList.add(tree.root);
        matrix.add(rootList);

        ListIterator<LinkedList<Tree.Node<T>>> matrixIterator = (ListIterator) matrix.iterator();

        boolean hasNext = true;
        int index = 0;
        while (hasNext) {
            var list = matrix.get(index);
            LinkedList<Tree.Node<T>> tempL = new LinkedList<>();
            for (Tree.Node<T> node : list) {
                if (node.left != null) {
                    tempL.add(node.left);
                }
                if (node.right != null) {
                    tempL.add(node.right);
                }
            }

            if (!tempL.isEmpty()) {
                index++;
                matrix.add(tempL);
            } else {
                hasNext = false;
            }

        }

        return matrix;
    }
}
