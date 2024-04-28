package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.LinkedList;

import java.util.Objects;

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
    public static LinkedList<Integer> findElement(LinkedList<Integer> head, long pos) {
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

}
