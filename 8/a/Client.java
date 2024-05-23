package org.example.eight.a;

// Client
public class Client {
    public void execute(Visitor visitor, Element element) {
        element.accept(visitor);
    }
}
