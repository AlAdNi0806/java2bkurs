package org.example.sixc;

public class ConcretePrototype2 implements Prototype<ConcretePrototype2> {
    @Override
    public ConcretePrototype2 clone() {
        try {
            return (ConcretePrototype2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}