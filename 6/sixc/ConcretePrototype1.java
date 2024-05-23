package org.example.sixc;

public class ConcretePrototype1 implements Prototype<ConcretePrototype1> {
    @Override
    public ConcretePrototype1 clone() {
        try {
            return (ConcretePrototype1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}