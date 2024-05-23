package org.example.hali;

public class Main {

    public static void main(String[] args) {
        try ( // Пример использования
              CustomExecutorService executorService = new CustomExecutorService(4)
        ) {
            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                executorService.execute(() -> {
                    System.out.println(
                            "Task " +
                                    taskId +
                                    " executed by thread: " +
                                    Thread.currentThread().getName()
                    );
                });
            }
            executorService.shutdown();
        }
    }
}
