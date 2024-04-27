package cracking.coding.interview.datastructures;

import java.util.UUID;

public class LinkedList<T> {

    private static long idCounter = 0;
    private final T data;
    private long nodeId;
    private LinkedList<T> next;

    public LinkedList(T data) {
        this.data = data;
        this.nodeId = idCounter++;
    }

    public T getData() {
        return data;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    public void addToBottom(LinkedList<T> end) {
        LinkedList<T> n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    public void delete(LinkedList<T> toBeDeleted) {

        var temp = this;
        while (temp != null) {
            if (temp.getNext() != null && temp.getNext().getNodeId() == toBeDeleted.nodeId) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }


}
