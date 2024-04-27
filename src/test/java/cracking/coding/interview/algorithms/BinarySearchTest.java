package cracking.coding.interview.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void givenBinarySearch_WhenElementExists_ThenShouldReturnTrue() {
        Integer[] arr = new Integer[]{9, 10, 545, 33, 9192, 123, 55, 67, 22}; // sorted [9, 10, 22, 33, 55, 67, 123, 545, 9192]

        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.quickSort(arr);

        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        int index = binarySearch.binarySearch(arr, 33);;
        Assertions.assertEquals(3, index);
    }

    @Test
    void givenBinarySearch_WhenElementDoesNotExists_ThenShouldReturnFalse() {
        Integer[] arr = new Integer[]{9, 10, 545, 33, 9192, 123, 55, 67, 22}; // sorted [9, 10, 22, 33, 55, 67, 123, 545, 9192]

        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.quickSort(arr);

        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        int index = binarySearch.binarySearch(arr, 1);;
        Assertions.assertEquals(-1, index);


        int index2 = binarySearch.binarySearch(arr, 41540454);
        Assertions.assertEquals(-1, index2);

    }


}
