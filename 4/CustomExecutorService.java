package org.example.hali;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomExecutorService implements AutoCloseable {

    private final int numberOfThreads;
    private final BlockingQueue<Runnable> taskQueue;
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    public CustomExecutorService(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.taskQueue = new LinkedBlockingQueue<>();
        startThreads();
    }

    private void startThreads() {
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                while (!isShutdown.get() || !taskQueue.isEmpty()) {
                    try {
                        Runnable task = taskQueue.poll(100, TimeUnit.MILLISECONDS);
                        if (task != null) {
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }

    public void execute(Runnable command) {
        if (isShutdown.get()) {
            throw new IllegalStateException("ExecutorService has been shut down");
        }
        taskQueue.offer(command);
    }

    public void shutdown() {
        isShutdown.set(true);
    }

    @Override
    public void close() {
        shutdown();
    }
}
