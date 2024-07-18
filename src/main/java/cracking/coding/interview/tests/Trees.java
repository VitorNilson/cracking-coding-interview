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

    //    4.4
    //    Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
    //    this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
    //    node never differ by more than one.
    //            Hints; #21, #33, #49, #105, #124
    public static <T extends Comparable<T>> boolean isABalancedHeightTree(Tree<T> tree) {

        final Tree.Node<T> root = tree.root;
        Map<Tree.Node<T>, Tree.Node<T>> parents = new HashMap<>(); // put a node parent here.
        Map<Tree.Node<T>, Integer> sum = new HashMap<>(); // put a node parent here.
        List<List<Tree.Node<T>>> matrix = new ArrayList<>();
        List<Tree.Node<T>> rootLevel = new ArrayList<>(Arrays.asList(root));


        matrix.add(rootLevel);

        int count = 0;
        boolean hasNext = true;

        while (hasNext) {
            List<Tree.Node<T>> nodeList = matrix.get(count);

            List<Tree.Node<T>> tempL = new ArrayList<>();
            for (Tree.Node<T> node : nodeList) {
                Boolean increased = false;
                increased = putOnMap(increased, node, node.left, tempL, parents, sum);
                increased = putOnMap(increased, node, node.right, tempL, parents, sum);

                if (node.left != null || node.right != null) {
                    increaseParentCount(parents, sum, node);
                }
            }

            if (!tempL.isEmpty()) {
                matrix.add(tempL);
                count++;
            } else {
                hasNext = false;
            }

        }

        for (var list : matrix) {

            for (int i = 0; i < list.size(); i++) {
                Tree.Node<T> node = list.get(i);
                for (int y = 0; y < list.size(); y++) {
                    System.out.printf("Node x %d, depth x %d | Node y %d, depth y %d", node.data, sum.get(node), list.get(y).data, sum.get(list.get(y)));
                    System.out.println();
                    if (sum.get(node) == null || sum.get(list.get(y)) == null) {
                        continue;
                    }
                    if (Math.abs(Math.max(sum.get(node), sum.get(list.get(y))) - Math.min(sum.get(node), sum.get(list.get(y)))) > 1) {
                        return false;
                    }

                }
            }
        }

        return true;
    }


    private static <T extends Comparable<T>> Boolean putOnMap(Boolean increased, Tree.Node<T> parent, Tree.Node<T> node, List<Tree.Node<T>> tempL, Map<Tree.Node<T>, Tree.Node<T>> parents, Map<Tree.Node<T>, Integer> sum) {

        if (node != null) {
            parents.put(node, parent);
            if (!increased) {
                sum.put(parent, sum.get(parent) != null ? sum.get(parent) + 1 : 1);
                increased = true;
            }
            tempL.add(node);
            return increased;
        }
        return increased;
    }

    private static <T extends Comparable<T>> void increaseParentCount(Map<Tree.Node<T>, Tree.Node<T>> parents, Map<Tree.Node<T>, Integer> sum, Tree.Node<T> root) {
        var temp = parents.get(root);
        if (temp != null) {
            sum.put(temp, sum.get(temp) + 1);
            increaseParentCount(parents, sum, temp);
        }
    }

    enum Side {L, R}

    //    4.5
    //    Validate BST: Implement a function to check if a binary tree is a binary search tree.
    //    Hints: #35, #57, #86, #113, #128
    public static <T extends Comparable<T>> boolean isABinarySearchTree(Tree<T> tree) {
        return validateBinarySearchTree(tree.root, null, null);
    }

    private static <T extends Comparable<T>> boolean validateBinarySearchTree(Tree.Node<T> node, T minVal, T maxVal) {
        if(node == null) {
            return true;
        }

        if((minVal != null && node.data.compareTo(minVal) <=0) || maxVal != null && node.data.compareTo(maxVal) > 0) {
            return false;
        }

        return validateBinarySearchTree(node.left, minVal, node.data) &&  validateBinarySearchTree(node.right, node.data, maxVal);
    }

}
