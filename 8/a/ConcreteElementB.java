package org.example.eight.a;

// Concrete ElementB
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }

    // Additional methods or properties for ConcreteElementB
}
