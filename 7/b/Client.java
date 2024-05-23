package org.example.seven.b;

import org.example.eight.a.Element;
import org.example.eight.a.Visitor;

// Client
public class Client {
    public void execute(Visitor visitor, Element element) {
        element.accept(visitor);
    }
}
