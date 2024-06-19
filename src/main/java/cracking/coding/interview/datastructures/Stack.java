package cracking.coding.interview.datastructures;

public class Stack<T> {
    private T data;
    private Stack<T> next;
    private Stack<T> top;

    public Stack(T data) {
        this.data = data;
    }

    public void push(T value) {
        var val = new Stack<>(value);
        val.next = top; // move current top to next, since its a stack. This is LIFO - Last-in First-out.
        top = val;
    }

    public T pop() {
        if(top == null) throw new RuntimeException("Stack is empty");
        T val = top.data;
        top = top.next;
        return val;
    }

    public T peek() {
        if(top == null) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
