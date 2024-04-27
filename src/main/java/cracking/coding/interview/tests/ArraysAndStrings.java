package cracking.coding.interview.tests;

import cracking.coding.interview.algorithms.BinarySearch;
import cracking.coding.interview.algorithms.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysAndStrings {

    // Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    // cannot use additional data structures?
    public static boolean allCharactersAreUnique(String a) {

        // I'm sorting the string to then run a binary search to see if there's duplicated values.

        Character[] aChars = a.chars().mapToObj(c -> (char) c).toArray(Character[]::new);//

        QuickSort<Character> quickSort = new QuickSort<>(); // O(n log n) - Dominant. So this algorithm is O(N log N).
        quickSort.quickSort(aChars);

        BinarySearch<Character> binarySearch = new BinarySearch<>(); // O(log n)

        boolean allUnique = true;

        Character lastItem = aChars[aChars.length - 1];

        if (binarySearch.binarySearch(aChars, lastItem, 0, aChars.length - 2) >= 0) { // O(log N)
            return false;
        }

        for (int i = 1; i < aChars.length - 1; i++) { //O(n)
            Character item = aChars[i];

            if (binarySearch.binarySearch(aChars, item, i + 1, aChars.length - 1) >= 0) { // O(log N)
                allUnique = false;
                break;
            }
        }

        return allUnique;
    }

    //    Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    //    other.
    //            Hints: #1, #8
    // This solution is (O aChars.lenght * bChars.length).
    // This was my first approach to this problem.
    //        Character[] aChars = a.chars().mapToObj(c -> (char) c).toArray(Character[]::new);//
    //        Character[] bChars = b.chars().mapToObj(c -> (char) c).toArray(Character[]::new);//
    //
    //        QuickSort<Character> quickSort = new QuickSort<>(); // O(n log n)
    //
    //        quickSort.quickSort(aChars);
    //
    //        boolean sqs = true;
    //
    //        outer:
    //        for (int i = 0; i < bChars.length; i++) {
    //
    //            if ((bChars.length - i) < aChars.length) {
    //                sqs = false;
    //                break;
    //            }
    //
    //            Character[] tempB = Arrays.copyOfRange(bChars, i, i + aChars.length);
    //            quickSort.quickSort(tempB);
    //
    //
    //            for (int j = 0; j < aChars.length; j++) {
    //
    //                if (!aChars[j].equals(tempB[j])) {
    //                    sqs = false;
    //                    continue outer;
    //                }
    //
    //                if (j == aChars.length - 1) {
    //                    sqs = true;
    //                    break outer;
    //                }
    //            }
    //
    //
    //        }
    //
    //        return sqs;
    public static boolean checkPermutation(String a, String b) {

        Character[] aChars = a.chars().mapToObj(c -> (char) c).toArray(Character[]::new);// O(N)
        int aLength = aChars.length;
        QuickSort<Character> quickSort = new QuickSort<>();
        quickSort.quickSort(aChars);// O(n log n)

        a = Arrays.toString(aChars);// O(N)

        boolean contains = false;
        for (int i = 0; i < b.length(); i++) { // for each loop we get substring of aLength size and sort it. So its a O(b.lenght() * N log N) where N is aLength.

            if ((b.length() - i) < aLength) break;

            Character[] subChars = b.substring(i, aLength + i).chars().mapToObj(c -> (char) c).toArray(Character[]::new);// O(b.length())
            quickSort.quickSort(subChars);  // O(n log n) where N is aLength
            String sub = Arrays.toString(subChars); // O(N)

            if (a.equals(sub)) {  // O(N)
                contains = true;
                break;
            }
        }

        return contains;
    }

    // O(N) ALGORITHM
    // but this check if there's permutation along all string, not in contiguous segment.
    // i'm too lazy to fix to contiguous segment.
    public static boolean hasPermutation(String a, String b) {

        boolean hasPermutation = false;

        int size = 256;
        int[] aPlaces = new int[size];
        int[] bPlaces = new int[size];

        int biggerSize = Math.max(a.length(), b.length());

        for (int i = 0; i < biggerSize; i++) {
            if (i < a.length())
                aPlaces[a.charAt(i)] = 1;
            if (i < b.length())
                bPlaces[b.charAt(i)] = 1;
        }

        int count = 0;
        for (int i = 0; i < size; i++) {

            if (aPlaces[i] == bPlaces[i] && (aPlaces[i] > 0 && bPlaces[i] > 0)) {
                count++;
            } else {
                count = 0;
                continue;
            }


            if (count == a.length()) {
                hasPermutation = true;
                break;
            }

        }

        return hasPermutation;
    }

    //    URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
    //    has sufficient space at the end to hold the additional characters, and that you are given the utrue"
    //    length of the string. (Note: If implementing in Java, please use a character array so that you can
    //    perform this operation in place.)
    // I'll not use an array. it will be 3O(N), since I'm currently a O(N).
    public static String URLify(String s) {
        s = s.strip();

        StringBuilder b = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.valueOf(s.charAt(i)).equals(' ')) {
                b.append("%20");
            } else {
                b.append(s.charAt(i));
            }
        }

        return b.toString();
    }

    //TODO come back here one day to improve. Now,  I've spent like 3 hours and I'm stressed.
    public static boolean isPalindrome(String a) {
        int size = 256;
        int[] places = new int[size];

        // i think it can be optmized since I'm using a hashset down there
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != ' ') {
                places[a.charAt(i)]++;
            }
        }


        Map<Character, Integer> values = new HashMap<>();

        int pairs = 0;
        for (int i = 0; i < size; i++) {
            if (places[i] > 0) {
                values.put((char) i, places[i]);

                if (places[i] == 2) pairs++;
            }
        }

        if (a.length() / 2 < pairs) return false;


        List<Map.Entry<Character, Integer>> entries = values.entrySet().stream().toList();

        char[] palindrome = new char[values.values().stream().mapToInt(i -> i).sum()];
        int mapI = 0;

        boolean front = false;
        for (int i = palindrome.length; i > 0; i--) {


            if (mapI == entries.size()) break;
            Map.Entry<Character, Integer> e = entries.get(mapI++);
            char c = e.getKey();

            if (e.getValue() % 2 == 0) {
                palindrome[palindrome.length - i] = c;
                palindrome[i - 1] = c;
                front = !front;
            } else {
                int currIndex = front ? (palindrome.length / 2) + (palindrome.length - i) / 2 : (palindrome.length / 2) - (palindrome.length - i) / 2;
                front = !front;
                palindrome[currIndex] = c;

            }
        }

        for (int i = palindrome.length; i > 0; i--) {
            if (palindrome[i - 1] != palindrome[palindrome.length - i]) return false;
        }


        return true;
    }


    //    One Away: There are three types of edits that can be performed on strings: insert a character,
    //    remove a character, or replace a character. Given two strings, write a function to check if they are
    //    one edit (or zero edits) away.
    public static boolean oneAway(String a, String b) {

        int max = Math.max(a.length(), b.length());
        int min = Math.min(a.length(), b.length());

        char[] primary = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
        char[] secondary = a.length() > b.length() ? b.toCharArray() : a.toCharArray();

        int binx = 0;
        int err = 0;
        for (int i = 0; i < max; i++) {

            while (primary[i] != secondary[binx] && binx < min - 1) {
                binx++;
            }

            if (primary[i] != secondary[binx]) {
                binx = 0;
                err++;
            } else {
                binx = i;
            }

            if (err > 1) {
                return false;
            }

        }


        return true;
    }

    //    1.6 String Compression: Implement a method to perform basic string compression using the counts
    //    of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    //"compressed" string would not become smaller than the original string, your method s hou Id return
    //    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    //    Hints: #92, #110
    public static String stringCompression(String s) {
        List<StrCompr> places = new ArrayList<>();
        s = s.toLowerCase();

        char[] st = s.toCharArray();

        char previous = st[0];
        int ctrl = 0;
        for (int i = 0; i < st.length; i++) {
            char curr = st[i];
            if (places.isEmpty() || previous != curr) {
                var temp = new StrCompr();
                temp.c = curr;
                temp.count = 0;
                places.add(temp);
            }

            if (previous != curr) {
                ctrl++;
            }
            previous = curr;
            places.get(ctrl).count++;

        }

        StringBuilder b = new StringBuilder();

        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) != null && places.get(i).count > 0) {
                b.append(places.get(i).c).append(places.get(i).count);
            }
        }

        return b.length() < s.length() ? b.toString() : s;

    }

    private static class StrCompr {
        public char c;
        public int count;
    }


    //    Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
    //    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
    //    Hints:#51, #100
    public static byte[][] rotateMatrix(byte[][] matrix) {

        for (int i = matrix.length; i > 0; i--) {


            for (int j = matrix.length; j > 0; j--) {

                byte temp = matrix[matrix.length - i][matrix.length - j];
                matrix[matrix.length - i][matrix.length - j] = matrix[j - 1][matrix.length - j];
                matrix[j - 1][matrix.length - j] = temp;
            }

        }

        return matrix;
    }

    //    Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    //    column are set to 0.
    //    Hints:#17, #74, #102
    //TODO find a way to use the matrix itself to store data.
    public static int[][] zeroMatrix(int[][] matrix) {

        Map<Integer, Integer> colVal = new HashMap<>();
        outer:
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    colVal.put(i, j);
                    continue outer;
                }
            }
        }

        for (Map.Entry<Integer, Integer> e : colVal.entrySet()) {
            int[] row = matrix[e.getKey()];
            Arrays.fill(row, 0);

            for (int i = 0; i < matrix.length; i++) {
                matrix[i][e.getValue()] = 0;
            }

        }

        return matrix;
    }


}
