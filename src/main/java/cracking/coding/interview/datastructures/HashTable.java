package cracking.coding.interview.datastructures;

public class HashTable<T> {


    private int hash(T key) {
        return  key.hashCode();
    }
}
