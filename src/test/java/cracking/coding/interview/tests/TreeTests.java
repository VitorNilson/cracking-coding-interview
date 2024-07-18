package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TreeTests {

    @Test
    void givenCreateBinarySearchTreeFromArray_WhenEverythingIsOk_ThenShouldReturnABinarySearchTree() {
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));

        var result = Trees.createBinarySearchTree(arr);

        Assertions.assertEquals(1, result.root.left.left.left.data);
        Assertions.assertEquals(2, result.root.left.left.data);
        Assertions.assertEquals(3, result.root.left.left.right.data);
        Assertions.assertEquals(4, result.root.left.data);
        Assertions.assertEquals(5, result.root.left.right.left.data);
        Assertions.assertEquals(6, result.root.left.right.data);
        Assertions.assertEquals(7, result.root.data);
        Assertions.assertEquals(8, result.root.right.left.left.data);
        Assertions.assertEquals(9, result.root.right.left.data);
        Assertions.assertEquals(10, result.root.right.data);
        Assertions.assertEquals(11, result.root.right.right.data);



    }

    @Test
    void givenGetListOfNodes_ThenShouldReturnAMatrixOfNLevels() {
        Tree<Integer> tree = new Tree<>(new Tree.Node<>(5));
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(6);
        tree.add(8);

        var matrix = Trees.getListOfNodes(tree);
        Assertions.assertEquals(3, matrix.size());
        Assertions.assertEquals(1, matrix.get(0).size());
        Assertions.assertEquals(5, matrix.get(0).get(0).data);

        Assertions.assertEquals(2, matrix.get(1).size());
        Assertions.assertEquals(3, matrix.get(1).get(0).data);
        Assertions.assertEquals(7, matrix.get(1).get(1).data);

        Assertions.assertEquals(3, matrix.get(2).size());
        Assertions.assertEquals(2, matrix.get(2).get(0).data);
        Assertions.assertEquals(6, matrix.get(2).get(1).data);
        Assertions.assertEquals(8, matrix.get(2).get(2).data);

    }

    @Test
    void givenIsABalancedHeightTree_WhenABalancedHeithTreeIsProvided_ThenShouldReturnTrue() {
        Tree<Integer> tree = new Tree<>(new Tree.Node<>(3));
        tree.add(2);
        tree.add(1);
        tree.add(5);
        tree.add(6);

        Assertions.assertTrue(Trees.isABalancedHeightTree(tree));
    }


    @Test
    void givenIsABalancedHeightTree_WhenAnUnbalancedHeithTreeIsProvided_ThenShouldReturnFalse() {
        Tree<Integer> tree = new Tree<>(new Tree.Node<>(3));
        tree.add(2);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);

        Assertions.assertFalse(Trees.isABalancedHeightTree(tree));
    }

    @Test
    void givenCheckIfIsABinarySearchTree_WhenABinarySearchTreeIsPassedThenShouldReturnTrue() {
        Tree<Integer> tree = new Tree<>(new Tree.Node<>(3));
        tree.add(2);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);

        Assertions.assertTrue(Trees.isABinarySearchTree(tree));
    }

    @Test
    void givenCheckIfIsABinarySearchTree_WhenANonBinarySearchTreeIsPassedThenShouldReturnFalse() {
        Tree<Integer> tree = new Tree<>(new Tree.Node<>(3));
        tree.add(2);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);

        tree.root.left.right = new Tree.Node<>(18);

        Assertions.assertFalse(Trees.isABinarySearchTree(tree));
    }
}
