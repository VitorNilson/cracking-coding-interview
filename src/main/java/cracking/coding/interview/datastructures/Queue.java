package cracking.coding.interview.datastructures;

public class Queue<T> {
    private T data;
    private Queue<T> next;
    private Queue<T> first;
    private Queue<T> last;

    public Queue(T data) {
        this.data = data;
    }

    public void add(T data) {
        var val = new Queue<>(data);
        if (last != null) {
            last.next = val;
        }
        last = val;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new RuntimeException("Queue is empty");
        T val = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return val;
    }

    public T peek() {
        if (first == null) throw new RuntimeException("Queue is empty");
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
