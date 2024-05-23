package org.example.seven.a;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightMap.get(key);
        if (flyweight == null) {
            // Decide whether to create a ConcreteFlyweight or UnsharedConcreteFlyweight based on the key
            if (key.equals("shared")) {
                flyweight = new ConcreteFlyweight("shared intrinsic state");
            } else {
                flyweight = new UnsharedConcreteFlyweight("unique allState");
            }
            flyweightMap.put(key, flyweight);
        }
        return flyweight;
    }
}
