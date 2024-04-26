package cracking.coding.interview.algorithms;

import java.util.Comparator;

public class QuickSort<T extends Comparable<T>> {

    public void quickSort(T[] arr) {
        quickSort(arr, new NaturalComparator<>(), 0, arr.length - 1);
    }

    public void quickSort(T[] arr, Comparator<T> comparator) {
        quickSort(arr, comparator, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, Comparator<T> comparator, int init, int end) {
        if (init < end) {
            int pi = partition(arr, init, end, comparator);

            quickSort(arr, comparator, init, pi - 1);
            quickSort(arr, comparator, pi + 1, end);
        }
    }

    private int partition(T[] arr, int start, int end, Comparator<T> comparator) {

        T pivot = arr[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {

            if (comparator.compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, end);
        return i + 1;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }

}
