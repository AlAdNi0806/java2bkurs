package org.example.six;

class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod() {
        // Implementation of the factory method to create a specific product
        return new ConcreteProduct();
    }

    @Override
    public void anOperation() {
        // Implementation of the operation for the concrete creator
    }
}
