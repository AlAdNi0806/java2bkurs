package org.example.bali.Main;

import java.util.*;

public class SynchronizedMapExample {
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> synchronizedMap = Collections.synchronizedMap(map);

    // Constructor
    public SynchronizedMapExample() {
        // Initialization can be done here if needed
    }

    // Thread-safe method to put a key-value pair into the map
    public void put(String key, String value) {
        synchronizedMap.put(key, value);
    }

    // Thread-safe method to get a value by key from the map
    public String get(String key) {
        synchronized (synchronizedMap) {
            return synchronizedMap.get(key);
        }
    }

    // Thread-safe method to remove a key-value pair from the map
    public void remove(String key) {
        synchronizedMap.remove(key);
    }
}
