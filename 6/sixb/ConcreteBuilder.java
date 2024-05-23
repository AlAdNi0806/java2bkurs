package org.example.sixb;

public class ConcreteBuilder implements Builder<ConcreteProduct> {

    @Override
    public void buildPart() {
        System.out.println("building...");
    }

    @Override
    public ConcreteProduct getResult() {
        ConcreteProduct concrete = new ConcreteProduct();
        return concrete;
    }
}
