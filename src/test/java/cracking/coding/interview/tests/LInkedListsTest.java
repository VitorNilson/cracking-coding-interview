package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LInkedListsTest {

    @Test
    void givenDeleteDuplicates_WhenWeProvideListsWithDuplicatesAndListsWithoutDuplicates_ThenShouldFinishAndDoNotContainsAnyDuplicate() {
        LinkedList<Integer> head = new LinkedList<>(1);
        head.addToBottom(new LinkedList<>(2));
        head.addToBottom(new LinkedList<>(3));
        head.addToBottom(new LinkedList<>(3));

        LinkedLists.removeDuplicates(head);

        Assertions.assertEquals(0, countDuplicatesAndValidateSequentialLinkedList(head));

        // Testing in the middle.
        LinkedList<Integer> head2 = new LinkedList<>(1);
        head2.addToBottom(new LinkedList<>(2));
        head2.addToBottom(new LinkedList<>(2));
        head2.addToBottom(new LinkedList<>(3));
        head2.addToBottom(new LinkedList<>(4));


        LinkedLists.removeDuplicates(head2);

        Assertions.assertEquals(0, countDuplicatesAndValidateSequentialLinkedList(head2));


        // Testing with no duplicates;
        LinkedList<Integer> head3 = new LinkedList<>(1);
        head3.addToBottom(new LinkedList<>(2));
        head3.addToBottom(new LinkedList<>(3));
        head3.addToBottom(new LinkedList<>(4));
        head3.addToBottom(new LinkedList<>(5));

        LinkedLists.removeDuplicates(head3);

        Assertions.assertEquals(0, countDuplicatesAndValidateSequentialLinkedList(head2));
    }

    // We will use this only for sequential linkedlist, because there's an assertion validating this.
    private int countDuplicatesAndValidateSequentialLinkedList(LinkedList<Integer> head) {
        int duplicates = 0;
        int tempInx = 1;
        var temp = head;
        while (temp != null) {
            if (temp.getNext() != null && temp.getData().equals(temp.getNext().getData())) {
                duplicates++;
            }

            // Since we provided a sequential linked list, we can validate this way
            Assertions.assertEquals((int) temp.getData(), tempInx++);

            temp = temp.getNext();
        }

        return duplicates;
    }
}
