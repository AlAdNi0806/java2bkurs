package org.example.sixa;

public class ConcreteFactory implements AbstractFactory {
    @Override
    public ConcreteProduct createProductA() {
        return new ConcreteProduct();
    }

    @Override
    public ConcreteProduct createProductB() {
        return new ConcreteProduct();
    }
}
