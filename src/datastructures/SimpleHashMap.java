package datastructures;
import java.util.LinkedList;

public class SimpleHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Node<K, V>>[] table;

    public SimpleHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        bucket.add(new Node<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        Node<K, V> toRemove = null;
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                toRemove = node;
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove);
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % table.length;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println(map.get("One")); // Outputs: 1
        System.out.println(map.get("Two")); // Outputs: 2
        System.out.println(map.get("Three")); // Outputs: 3

        map.remove("Two");
        System.out.println(map.get("Two")); // Outputs: null
    }
}
