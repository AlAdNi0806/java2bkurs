package org.example;

// Класс Main содержит основную точку входа в программу
public class Main {
    // Основной метод, который запускает программу
    public static void main(String[] args) {
        // Создание экземпляра класса EmailPredicate
        EmailPredicate emailPredicate = new EmailPredicate();
        // Проверка, является ли строка "example@example.com" действительным адресом электронной почты
        System.out.println(emailPredicate.test("example@example.com"));
        // Проверка, является ли строка "not an email" действительным адресом электронной почты
        System.out.println(emailPredicate.test("not an email"));
    }
}

