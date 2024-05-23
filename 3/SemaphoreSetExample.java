package org.example.bali.Main;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreSetExample {
    private final Set<String> set = new HashSet<>();
    private final Semaphore semaphore = new Semaphore(1); // Ограничиваем доступ к Set одним потоком

    public void add(String element) {
        try {
            semaphore.acquire(); // Получаем разрешение от семафора
            set.add(element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Освобождаем семафор
        }
    }

    public boolean contains(String element) {
        try {
            semaphore.acquire(); // Получаем разрешение от семафора
            return set.contains(element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            semaphore.release(); // Освобождаем семафор
        }
    }
}
