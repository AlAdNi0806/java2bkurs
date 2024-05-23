package org.example;

// Импортируем класс Predicate и класс Pattern для работы с регулярными выражениями
import java.util.function.Predicate;
import java.util.regex.Pattern;

// Класс EmailPredicate реализует интерфейс Predicate для проверки корректности email
public class EmailPredicate implements Predicate<String> {
    // Паттерн для проверки email. Соответствует стандарту RFC  5322
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Za-z0-9.-]$";
    // Объект Pattern для компиляции регулярного выражения
    private Pattern pattern;

    // Конструктор класса EmailPredicate, инициализирует объект Pattern с заданным паттерном
    public EmailPredicate() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    // Переопределение метода test интерфейса Predicate для проверки, соответствует ли строка заданному паттерну email
    @Override
    public boolean test(String s) {
        // Возвращает true, если строка соответствует паттерну email, иначе false
        return pattern.matcher(s).matches();
    }
}
