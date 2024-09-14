package datastructures;
import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Method to add an element to the list
    public void add(T element) {
        // Check if resizing is needed
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    // Method to get an element by index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    // Method to remove an element at a specific index
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        @SuppressWarnings("unchecked")
        T element = (T) elements[index];

        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Clear the last element and reduce size
        return element;
    }

    // Method to get the current size of the list
    public int size() {
        return size;
    }

    // Method to resize the array when it reaches capacity
    private void resize() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // Method to print all elements in the list (for testing purposes)
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test the MyArrayList implementation
        MyArrayList<String> myList = new MyArrayList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Java");
        myList.printList(); // Output: Hello World Java

        // Access elements
        System.out.println("Element at index 1: " + myList.get(1)); // Output: World

        // Remove an element
        myList.remove(1);
        myList.printList(); // Output: Hello Java

        // Get the size of the list
        System.out.println("Size of the list: " + myList.size()); // Output: 2
    }
}
