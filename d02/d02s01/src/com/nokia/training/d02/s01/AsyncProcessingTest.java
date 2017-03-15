package com.nokia.training.d02.s01;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class AsyncProcessingTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorCompletionService<Integer> executorCompletionService =
                new ExecutorCompletionService<>(executorService);

        List<Integer> integers = Arrays.asList(10, 20, 30, 25, 45, 65, 76, 34);
        for (Integer integer : integers) {
            executorCompletionService.submit(new NumberProcessor(integer));
            executorCompletionService.submit(new AnotherNumberProcessor(integer));
        }

        Future<Integer> result;
        try {
            for (int i = 0; i < integers.size(); i++) {
                result = executorCompletionService.poll(1000, TimeUnit.MILLISECONDS);

                if (result != null & result.isDone()) {
                    System.out.println(result.get());
                }
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        executorService.shutdown();
    }

    private static class NumberProcessor implements Callable<Integer> {
        private Integer integer;

        NumberProcessor(Integer integer) {
            this.integer = integer;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(300);
            return integer * integer;
        }
    }

    private static class AnotherNumberProcessor implements Callable<Integer> {
        private Integer integer;

        AnotherNumberProcessor(Integer integer) {
            this.integer = integer;
        }

        @Override
        public Integer call() throws Exception {
            return integer * 2;
        }
    }
}
