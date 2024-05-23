package org.example.seven.b;

public interface Component {
    void operation();
    void add(Composite c);
    void remove(Composite c);
    Component getChild(int i);
}

