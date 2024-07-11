package cracking.coding.interview.tests;

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
}
