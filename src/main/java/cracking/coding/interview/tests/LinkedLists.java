package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.LinkedList;

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
    public static LinkedList<Integer> findElement(LinkedList<Integer> head, int pos) {
        int currentIndex = 0;
        LinkedList<Integer> curr = head;

        while (curr != null) {
            if (currentIndex++ == pos) {
                return curr;
            }

            curr = curr.getNext();
        }
        return null;
    }
}
