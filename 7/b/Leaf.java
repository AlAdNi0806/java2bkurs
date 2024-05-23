package org.example.seven.b;

public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " operation");
    }

    @Override
    public void add(Composite c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Composite c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int i) {
        throw new UnsupportedOperationException();
    }
}
