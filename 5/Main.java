package org.example.kali;

public class Main {

    public static void main(String[] args) {
        // Тестирование Singleton1
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println("Singleton1: " + singleton1);

        // Тестирование Singleton2
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println("Singleton2: " + singleton2);

        // Тестирование Singleton3
        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println("Singleton3: " + singleton3);
    }
}
