package org.example.sixb;

import org.example.sixa.AbstractProduct;

public class ConcreteProduct implements AbstractProduct {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductA is doing something.");
    }
}
