package com.nokia.training.d02.s01;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ParallelProcessingTest {

    private static final int PROCESSORS_COUNT = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        // the used thread pool
        final int usedCores = PROCESSORS_COUNT;

        final ExecutorService executorService = Executors.newFixedThreadPool(usedCores * 2);
        final ExecutorCompletionService<String> executorCompletionService =
                new ExecutorCompletionService<String>(executorService);

        final List<String> strings = Arrays.asList("Welcome to the asynchronous processing demo!".split(" "));

        for (String string : strings) {
            executorCompletionService.submit(new Displayer(string));
        }

        System.out.println("Using " + usedCores + " processors for parallel processing...");
        final long now = System.currentTimeMillis();

        Future<String> future;
        try {
            for (int i = 0; i < strings.size(); i++) {
                future = executorCompletionService.poll(1000, TimeUnit.MILLISECONDS);

                if (future != null && future.isDone()) {
                    System.out.println("\t" + future.get());
                }
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        System.out.println("The entire processing took " + (System.currentTimeMillis() - now) + " ms");
    }

    private static class Displayer implements Callable<String> {
        private String value;

        Displayer(final String value) {
            this.value = value;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            return Thread.currentThread().getName() + " - " +  value;
        }
    }

    private static class MyThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    }
}
