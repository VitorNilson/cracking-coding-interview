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


    @Test
    void givenFindElement_WhenThePositionIsLessThanEqualsTotalOfElements_ThenShouldReturnItemCorrespondingToAskedPosition() {

        LinkedList<Integer> head = new LinkedList<>(1);
        head.addToBottom(new LinkedList<>(2));
        head.addToBottom(new LinkedList<>(3));
        head.addToBottom(new LinkedList<>(3));


        Assertions.assertEquals(3, LinkedLists.findElement(head, 3).getData());
        Assertions.assertEquals(2, LinkedLists.findElement(head, 1).getData());
        Assertions.assertEquals(1, LinkedLists.findElement(head, 0).getData());

    }

    @Test
    void givenDeleteMiddleElement_ThenLinkedListShouldHaveMiddleElementRemoved() {

        LinkedList<Integer> head = new LinkedList<>(1);
        head.addToBottom(new LinkedList<>(2));
        head.addToBottom(new LinkedList<>(999));//Middle
        head.addToBottom(new LinkedList<>(3));

        LinkedLists.deleteMiddleNode(head);

        Assertions.assertEquals(3, head.getLength());
        countDuplicatesAndValidateSequentialLinkedList(head);


        LinkedList<Integer> head2 = new LinkedList<>(1);
        head2.addToBottom(new LinkedList<>(2));
        head2.addToBottom(new LinkedList<>(999));//Middle
        head2.addToBottom(new LinkedList<>(3));
        head2.addToBottom(new LinkedList<>(4));

        LinkedLists.deleteMiddleNode(head2);

        Assertions.assertEquals(4, head2.getLength());
        countDuplicatesAndValidateSequentialLinkedList(head2);

        LinkedList<Integer> head3 = new LinkedList<>(1);
        head3.addToBottom(new LinkedList<>(2));
        head3.addToBottom(new LinkedList<>(3));
        head3.addToBottom(new LinkedList<>(999));//Middle
        head3.addToBottom(new LinkedList<>(4));
        head3.addToBottom(new LinkedList<>(5));

        LinkedLists.deleteMiddleNode(head3);

        Assertions.assertEquals(5, head3.getLength());
        countDuplicatesAndValidateSequentialLinkedList(head3);


        LinkedList<Integer> head4 = new LinkedList<>(1);
        head4.addToBottom(new LinkedList<>(2));
        head4.addToBottom(new LinkedList<>(3));
        var middle = new LinkedList<>(999);
        head4.addToBottom(middle);//Middle
        head4.addToBottom(new LinkedList<>(4));
        head4.addToBottom(new LinkedList<>(5));

        LinkedLists.deleteMiddleNode(middle);

        Assertions.assertEquals(5, head4.getLength());
        countDuplicatesAndValidateSequentialLinkedList(head2);


    }

    @Test
    void givenPartition_ThenShouldReturnAPartitionedLinkedList() {
        LinkedList<Integer> head = new LinkedList<>(3);
        head.addToBottom(new LinkedList<>(5));
        head.addToBottom(new LinkedList<>(8));
        head.addToBottom(new LinkedList<>(5));
        head.addToBottom(new LinkedList<>(10));
        head.addToBottom(new LinkedList<>(2));
        head.addToBottom(new LinkedList<>(1));


        var result = LinkedLists.partition(head, 5);

        Assertions.assertEquals(1, LinkedLists.findElement(result, 0).getData());
        Assertions.assertEquals(2, LinkedLists.findElement(result, 1).getData());
        Assertions.assertEquals(3, LinkedLists.findElement(result, 2).getData());
        Assertions.assertEquals(5, LinkedLists.findElement(result, 3).getData());
        Assertions.assertEquals(8, LinkedLists.findElement(result, 4).getData());
        Assertions.assertEquals(5, LinkedLists.findElement(result, 5).getData());
        Assertions.assertEquals(10, LinkedLists.findElement(result, 6).getData());
    }

    @Test
    void givenReverseSum_WhenTwoNonNullLinkedListsArePassed_ThenShouldReturnALinkedListWithReverseCharsSum() {
        LinkedList<Integer> a = new LinkedList<>(0);
        a.addToBottom(new LinkedList<>(0));
        a.addToBottom(new LinkedList<>(3));

        LinkedList<Integer> b = new LinkedList<>(0);
        b.addToBottom(new LinkedList<>(0));
        b.addToBottom(new LinkedList<>(5));

        var result = LinkedLists.reverseSum(a, b);

        Assertions.assertEquals(0, LinkedLists.findElement(result, 0).getData());
        Assertions.assertEquals(0, LinkedLists.findElement(result, 1).getData());
        Assertions.assertEquals(8, LinkedLists.findElement(result, 2).getData());


    }

    @Test
    void givenIsPalindrome_WhenAPalindromeLinkedListIsPassed_ThenShouldReturnTrue() {
        LinkedList<String> head = new LinkedList<>("b");
        head.addToBottom(new LinkedList<>("o"));
        head.addToBottom(new LinkedList<>("b"));

        Assertions.assertTrue(LinkedLists.isPalindrome(head));

        LinkedList<String> head2 = new LinkedList<>("o");
        head2.addToBottom(new LinkedList<>("c"));
        head2.addToBottom(new LinkedList<>("t"));
        head2.addToBottom(new LinkedList<>("o"));
        head2.addToBottom(new LinkedList<>("c"));
        head2.addToBottom(new LinkedList<>("a"));
        head2.addToBottom(new LinkedList<>("t"));


        Assertions.assertTrue(LinkedLists.isPalindrome(head2));
    }

    @Test
    void givenIsPalindrome_WhenANonPalindromeStringIsPassed_ThenShouldReturnFalse() {
        LinkedList<String> head = new LinkedList<>("s");
        head.addToBottom(new LinkedList<>("a"));
        head.addToBottom(new LinkedList<>("t"));
        head.addToBottom(new LinkedList<>("a"));

        Assertions.assertFalse(LinkedLists.isPalindrome(head));

    }

    @Test
    void givenIntersection_WhenTheresAnIntersection_ThenShouldReturnTheIntersectionNode() {

        LinkedList<Integer> intersectionNode = new LinkedList<>(3);
        intersectionNode.addToBottom(new LinkedList<>(88));
        intersectionNode.addToBottom(new LinkedList<>(725));
        intersectionNode.addToBottom(new LinkedList<>(1263));

        LinkedList<Integer> a = new LinkedList<>(1);
        a.addToBottom(new LinkedList<>(2));
        a.addToBottom(intersectionNode);


        LinkedList<Integer> b = new LinkedList<>(1);
        b.addToBottom(new LinkedList<>(2));
        b.addToBottom(new LinkedList<>(82));
        b.addToBottom(new LinkedList<>(99));
        b.addToBottom(new LinkedList<>(123));
        b.addToBottom(new LinkedList<>(23101));

        b.addToBottom(intersectionNode);

        Assertions.assertEquals(intersectionNode, LinkedLists.intersection(a, b));

    }

    @Test
    void givenIntersection_WhenTheresNoIntersection_ThenShouldReturnNull() {

        LinkedList<Integer> a = new LinkedList<>(1);
        a.addToBottom(new LinkedList<>(2));

        LinkedList<Integer> b = new LinkedList<>(1);
        b.addToBottom(new LinkedList<>(2));
        b.addToBottom(new LinkedList<>(82));
        b.addToBottom(new LinkedList<>(99));
        b.addToBottom(new LinkedList<>(123));
        b.addToBottom(new LinkedList<>(23101));

        Assertions.assertNull(LinkedLists.intersection(a, b));

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
