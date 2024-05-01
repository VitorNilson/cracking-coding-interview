package cracking.coding.interview.datastructures;

public class LinkedList<T> {

    private long length = 1;
    private static long idCounter = 0;
    private T data;
    private final long nodeId;
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

    public long getLength() {
        return length;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    public synchronized void addToStart(LinkedList<T> start) {
        start.setNext(this);
        start.length = this.length++; //TODO this is not working. Come back here later.
    }

    public void add(LinkedList<T> head, LinkedList<T> item, int pos) {
        var temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }

        var n = temp.getNext();
        temp.setNext(item);
        item.setNext(n);

    }

    public synchronized void addToBottom(LinkedList<T> end) {
        LinkedList<T> n = this;

        while (n.next != null) {
            n = n.next;
        }

        this.length++;

        n.next = end;
    }

    public void delete(LinkedList<T> toBeDeleted) {

        var temp = this;
        while (temp != null) {
            if (temp.getNext() != null && temp.getNext().getNodeId() == toBeDeleted.nodeId) {
                temp.setNext(temp.getNext().getNext());
                this.length--;
                break;
            }
            temp = temp.getNext();
        }
    }


}
