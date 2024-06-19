package cracking.coding.interview.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StacksAndQueuesTest {

    @Test
    void givenThreeStackInASingleArray_WhenItemsAddedByArrayEnum_ThenShouldAddCorrectlyWithoutAnyProblem() {
        Integer[] arr = new Integer[9];

        StacksAndQueues.threeInOne(arr, 1, StacksAndQueues.WhichStack.A);

        Assertions.assertEquals(1, arr[0]);

        StacksAndQueues.threeInOne(arr, 2, StacksAndQueues.WhichStack.A);
        Assertions.assertEquals(2, arr[1]);

        StacksAndQueues.threeInOne(arr, 88, StacksAndQueues.WhichStack.C);
        Assertions.assertEquals(88, arr[6]);

        StacksAndQueues.threeInOne(arr, 44, StacksAndQueues.WhichStack.B);
        Assertions.assertEquals(44, arr[3]);

        StacksAndQueues.threeInOne(arr, 123, StacksAndQueues.WhichStack.A);
        Assertions.assertEquals(123, arr[2]);

        StacksAndQueues.threeInOne(arr, 1444, StacksAndQueues.WhichStack.B);
        Assertions.assertEquals(1444, arr[4]);

        StacksAndQueues.threeInOne(arr, 45646, StacksAndQueues.WhichStack.C);
        Assertions.assertEquals(45646, arr[7]);
    }

    @Test
    void givenThreeStackInASingleArray_WhenItemsAreAddedAndRemovedByArrayEnum_ThenShouldWorkWithoutAnyProblem() {
        Integer[] arr = new Integer[9];
        StacksAndQueues.threeInOne(arr, 1, StacksAndQueues.WhichStack.A);
        Assertions.assertEquals(1, StacksAndQueues.pop(arr, StacksAndQueues.WhichStack.A));

        StacksAndQueues.threeInOne(arr, 8888, StacksAndQueues.WhichStack.A);
        Assertions.assertEquals(8888, StacksAndQueues.pop(arr, StacksAndQueues.WhichStack.A));

        StacksAndQueues.threeInOne(arr, 1, StacksAndQueues.WhichStack.A);
        StacksAndQueues.threeInOne(arr, 2, StacksAndQueues.WhichStack.A);
        Assertions.assertEquals(2, StacksAndQueues.pop(arr, StacksAndQueues.WhichStack.A));

        StacksAndQueues.threeInOne(arr, 2, StacksAndQueues.WhichStack.A);
        StacksAndQueues.threeInOne(arr, 3, StacksAndQueues.WhichStack.A);
        Assertions.assertEquals(3, StacksAndQueues.pop(arr, StacksAndQueues.WhichStack.A));
        Assertions.assertNull(arr[2]);


        Assertions.assertNull(StacksAndQueues.pop(arr, StacksAndQueues.WhichStack.B));


    }
}
