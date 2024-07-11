package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.Tree;

import java.util.ArrayList;
import java.util.List;

public class Trees {

    //    4.2
    //    Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
    //    algorithm to create a binary search tree with minimal height.
    //    Hints: #19, #73, #116
    public static <T extends Comparable<T>> Tree<T> createBinarySearchTree(List<T> arr) {

        int middle = arr.size() % 2 == 0 ? arr.size() / 2 : arr.size() / 2 + 1;

        Tree<T> tree = new Tree<>(new Tree.Node<>(arr.remove(middle)));

        add( tree, new ArrayList<>( arr.subList(0, middle)));
        add(tree, new ArrayList<>(arr.subList(middle , arr.size())));

        return tree;
    }

    private static <T extends Comparable<T>> void add( Tree<T> tree, List<T> arr) {
        int middle = (arr.size() / 2);
        if (!arr.isEmpty()) {
            tree.add(arr.remove(middle));
            add(tree, new ArrayList<>(arr.subList(0, middle)));
            add(tree, new ArrayList<>(arr.subList(middle, arr.size())));
        }
    }
}
