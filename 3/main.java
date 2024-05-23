package org.example.bali.Main;

public class main {

    public static void main(String[] args) {
        // Testing SemaphoreSetExample
        SemaphoreSetExample semaphoreSetExample = new SemaphoreSetExample();

        // Adding elements to the set
        semaphoreSetExample.add("element1");
        semaphoreSetExample.add("element2");

        // Checking if elements exist in the set
        System.out.println("Contains element1: " + semaphoreSetExample.contains("element1")); // Should print true
        System.out.println("Contains element3: " + semaphoreSetExample.contains("element3")); // Should print false

        // Testing SynchronizedMapExample
        SynchronizedMapExample synchronizedMapExample = new SynchronizedMapExample();

        // Adding key-value pairs to the map
        synchronizedMapExample.put("key1", "value1");
        synchronizedMapExample.put("key2", "value2");

        // Retrieving values by key from the map
        System.out.println("Value for key1: " + synchronizedMapExample.get("key1")); // Should print "value1"
        System.out.println("Value for key3: " + synchronizedMapExample.get("key3")); // Should print null

        // Removing a key-value pair from the map
        synchronizedMapExample.remove("key1");
        System.out.println("Value for key1 after removal: " + synchronizedMapExample.get("key1")); // Should print null
    }
}
