package com.nokia.training.d02.s01;

public class ThreadsTests {

    public static void main(String[] args) {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(getThreadName(Thread.currentThread()) +
                        " - A new thread");
            }
        };

        final Thread thread = new Thread(runnable);

        final Thread currentThread = Thread.currentThread();
        System.out.println("Before start - " + getThreadState(currentThread));
        thread.start();
        System.out.println("After start - " + getThreadState(currentThread));

        System.out.println("Current thread is " + getThreadName(currentThread));
    }

    private static String getThreadName(final Thread thread) {
        return thread.getName();
    }

    private static Thread.State getThreadState(final Thread thread) {
        return thread.getState();
    }
}
