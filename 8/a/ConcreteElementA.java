package org.example.eight.a;

// Concrete ElementA
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }

    // Additional methods or properties for ConcreteElementA
}
