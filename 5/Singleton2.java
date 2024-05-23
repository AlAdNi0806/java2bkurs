package org.example.kali;

public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {}

    private static class SingletonBuilder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonBuilder.INSTANCE;
    }

}
