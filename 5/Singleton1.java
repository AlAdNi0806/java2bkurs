package org.example.kali;

public class Singleton1 {
    private Singleton1() {}

    private static class SingletonHelper {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return SingletonHelper.INSTANCE;
    }


}
