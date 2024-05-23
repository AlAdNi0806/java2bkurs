package org.example.seven.a;

public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("shared");
        Flyweight flyweight2 = factory.getFlyweight("shared");
        Flyweight unsharedFlyweight = factory.getFlyweight("unique");

        // Use the flyweights with extrinsic state
        flyweight1.operation("extrinsic state 1");
        flyweight2.operation("extrinsic state 2");
        unsharedFlyweight.operation("extrinsic state 3");

        // Check if the flyweights are the same instance
        System.out.println("flyweight1 == flyweight2: " + (flyweight1 == flyweight2)); // true
        System.out.println("flyweight1 == unsharedFlyweight: " + (flyweight1 == unsharedFlyweight)); // false
    }
}