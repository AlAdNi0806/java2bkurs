package org.example.sixa;

public class ConcreteProduct implements AbstractProduct {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductA is doing something.");
    }
}
