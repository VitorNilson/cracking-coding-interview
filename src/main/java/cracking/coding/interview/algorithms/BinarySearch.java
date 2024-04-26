package cracking.coding.interview.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch<T extends Comparable<T>> {

    public int binarySearch(T[] arr, T search) {
        return binarySearch(arr, search, new NaturalComparator<>(), 0, arr.length - 1);
    }

    public int binarySearch(T[] arr, T search, int init, int end) {
        return binarySearch(arr, search, new NaturalComparator<>(), init, end);
    }

    public int binarySearch(T[] arr, T search, Comparator<T> comparator, int init, int end) {

        while (init <= end) {

            int middle = init + ((end - init) / 2);

            if (arr[middle].equals(search)) {
                return middle;
            } else if (comparator.compare(arr[middle], search) < 0) {
                init = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;

    }

    static class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }
}
