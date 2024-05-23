package org.example.sixa;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        ConcreteProduct productA = factory.createProductA();
        ConcreteProduct productB = factory.createProductB();

        productA.doSomething();
        productB.doSomething();

        System.out.println("ConcreteProductB is doing something.");
        System.out.println("Everything built!");

    }
}
