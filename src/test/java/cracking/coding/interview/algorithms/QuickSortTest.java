package cracking.coding.interview.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class QuickSortTest {

    @Test
    void givenSortCharacterArray_WhenAnUnsortedArrayIsProvided_ThenShouldReturnASortedArray() {
        String a = "dcba";
        Character[] aChars = a.chars().mapToObj(c -> (char) c).toArray(Character[]::new);


        QuickSort<Character> quickSort = new QuickSort<>();
        quickSort.quickSort(aChars);

        Assertions.assertEquals("[a, b, c, d]", Arrays.toString(aChars));
    }

    @Test
    void givenSortIntegerArray_WhenAnUnsortedArrayIsProvided_ThenShouldReturnASortedArray() {
        Integer[] arr = new Integer[]{9, 10, 545, 33, 9192, 123, 55, 67, 22};

        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.quickSort(arr);

        Assertions.assertEquals("[9, 10, 22, 33, 55, 67, 123, 545, 9192]", Arrays.toString(arr));

    }
}
