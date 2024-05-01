package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.LinkedList;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LinkedLists {

    //    2.1 Remove dups: Write code to remove duplicates from an unsorted linked list.
    //    FOLLOW UP
    //    How would you solve this problem if a temporary buffer is not allowed? - I did it. Its O(N^2).
    //    Hints: #9, #40
    public static void removeDuplicates(LinkedList<Integer> linkedList) {
        LinkedList<Integer> curr = linkedList;

        while (curr != null) {

            LinkedList<Integer> next = linkedList.getNext();

            while (next != null) {
                if (next.getNodeId() != curr.getNodeId() && next.getData().equals(curr.getData())) {
                    linkedList.delete(next);
                }
                next = next.getNext();
            }

            curr = curr.getNext();
        }
    }

    //    2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
    //            Hints:#8, #25, #41, #67, #126
    public static <T> LinkedList<T> findElement(LinkedList<T> head, long pos) {
        int currentIndex = 0;
        LinkedList<T> curr = head;

        while (curr != null) {
            if (currentIndex++ == pos) {
                return curr;
            }

            curr = curr.getNext();
        }
        return null;
    }

    //    2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    //            the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
    //    that node.
    //    EXAMPLE
    //    Input: the node c from the linked list a->b->c->d->e->f
    //    Result: nothing is returned, but the new linked list looks like a->b->d->e->f
    //    Hints:#72
    public static void deleteMiddleNode(LinkedList<Integer> head) {
        head.delete(findElement(head, head.getLength() / 2));
    }


    //    2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
    //    before all nodes greater than or equal to x. If xis contained within the list, the values of x only need
    //    to be after the elements less than x (see below). The partition element x can appear anywhere in the
    //"right partition"; it does not need to appear between the left and right partitions.
    //    EXAMPLE
    //    Input:
    //    Output:
    //            3 - > 5 - > 8 - > 5 - > 10 - > 2 - > 1 [partition = S]
    //            3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
    //    Hints: #3, #24
    public static LinkedList<Integer> partition(LinkedList<Integer> head, Integer pivot) {
        LinkedList<Integer> result = null;
        LinkedList<Integer> temp = head;

        while (temp != null) {

            if (result == null) {
                result = new LinkedList<>(temp.getData());
            } else if (temp.getData() > pivot || pivot.equals(temp.getData())) {
                result.addToBottom(new LinkedList<>(temp.getData()));
            } else {
                var rs = new LinkedList<>(temp.getData());
                result.addToStart(rs);
                result = rs;
            }

            temp = temp.getNext();
        }

        return result;
    }


    //    2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single
    //    digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
    //    function that adds the two numbers and returns the sum as a linked list.
    //    EXAMPLE
    //    lnput:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
    //    Output: 2 -> 1 -> 9. That is, 912.
    //    FOLLOW UP
    //    Suppose the digits are stored in forward order. Repeat the above problem.
    //    EXAMPLE
    //    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
    //    Output: 9 -> 1 -> 2. That is, 912.
    //    Hints: #7, #30, #71, #95, #109
    public static LinkedList<Integer> reverseSum(LinkedList<Integer> a, LinkedList<Integer> b) {

        if (a.getLength() != b.getLength()) {
            var zero = new LinkedList<>(0);
            if (a.getLength() > b.getLength()) {
                a.addToStart(zero);
                a = zero;
            } else {
                b.addToStart(zero);
                b = zero;
            }
        }

        long ind = 0;
        int ttl = 0;

        while (a != null && b != null) {
            ttl += a.getData() * Math.pow(10, ind);
            ttl += b.getData() * Math.pow(10, ind++);

            a = a.getNext();
            b = b.getNext();

        }

        LinkedList<Integer> result = null;

        for (int i = 0; i < Integer.toString(ttl).length(); i++) {
            int value = Integer.parseInt(String.valueOf(Integer.toString(ttl).charAt(i)));

            if (result == null) {
                result = new LinkedList<>(value);
            } else {
                var rs = new LinkedList<>(value);
                result.addToStart(rs);
                result = rs;
            }

        }

        return result;

    }


    //    2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
    //    Hints:#5, #13, #29, #61, #101
    public static boolean isPalindrome(LinkedList<String> a) {

        long size = a.getLength();

        Map<String, Integer> frequency = buildFrequency(a);

        if (frequency == null) return false;

        String[] sorted = sort(frequency);

        for (int i = sorted.length; i > 0; i--) {
            if (!sorted[i - 1].equals(sorted[(int) (size - i)])) {
                return false;
            }
        }

        return true;

    }

    //    2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth
    //    node of the first linked list is the exact same node (by reference) as the jth node of the second
    //    linked list, then they are intersecting.
    //            Hints:#20, #45, #55, #65, #76, #93, #111, #120, #129
    public static LinkedList<Integer> intersection(LinkedList<Integer> a, LinkedList<Integer> b) {

        if (a.getLength() != b.getLength()) {
            if (a.getLength() > b.getLength()) {
                for (int i = 0; i < a.getLength() - b.getLength(); i++) {
                    var rs = new LinkedList<>(i);
                    b.addToStart(rs);
                    b = rs;
                }
            } else {
                for (int i = 0; i < b.getLength() - a.getLength(); i++) {
                    var rs = new LinkedList<>(i);
                    a.addToStart(rs);
                    a = rs;
                }
            }
        }

        var tempA = a;
        var tempB = b;
        while (tempA != null && tempB != null) {

            if (tempA.equals(tempB)) {
                return tempA;
            }

            tempA = tempA.getNext();
            tempB = tempB.getNext();

        }

        return null;
    }

    private static Map<String, Integer> buildFrequency(LinkedList<String> a) {
        Map<String, Integer> frequency = new HashMap<>();
        var temp = a;
        long size = a.getLength();
        while (temp != null) {
            frequency.merge(temp.getData(), 1, Integer::sum);
            temp = temp.getNext();
        }

        int pairs = 0;

        for (Map.Entry<String, Integer> v : frequency.entrySet()) {
            if (v.getValue() % 2 == 0) pairs++;
        }


        if (size / 2 < pairs) {
            return null;
        }

        return frequency.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

    }

    private static String[] sort(Map<String, Integer> frequency) {
        int size = frequency.entrySet().stream().map(Map.Entry::getValue).reduce((prev, c) -> prev + c).get();

        String[] s = new String[size];
        var entries = frequency.entrySet().stream().toList();
        int mapI = 0;

        boolean front = true;
        for (int i = size; i > 0; i--) {
            if (mapI == entries.size()) break;

            Map.Entry<String, Integer> v = entries.get(mapI++);

            if (v.getValue() % 2 == 0) {
                s[size - i] = v.getKey();
                s[i - 1] = v.getKey();
                front = !front;
            } else {
                int index = front ? (size / 2) + (size - i) / 2 : (size / 2) - (size - i) / 2;
                front = !front;

                if (s[index] != null) {
                    if (s[index - 1] == null) {
                        index -= 1;
                    } else if (s[index + 1] == null) {
                        index += 1;
                    }
                }
                s[index] = v.getKey();
            }

        }

        return s;


    }

}
