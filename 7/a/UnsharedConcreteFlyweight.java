package org.example.seven.a;

import org.example.seven.a.Flyweight;

public class UnsharedConcreteFlyweight implements Flyweight {
    private String allState;

    public UnsharedConcreteFlyweight(String allState) {
        this.allState = allState;
    }

    @Override
    public void operation(String extrinsicState) {
        // Implementation of the operation method using allState and extrinsic state
    }
}
