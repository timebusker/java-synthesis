package com.timebusker.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by HP on 2019/2/23.
 */
public class ThreadPoolThreadLocalTest {

    public static void main(String[] args) {
        final ThreadLocal threadLocal = new InheritableThreadLocal<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            threadLocal.set("______A");
            System.err.println(Thread.currentThread().getName() + "\t" + threadLocal.get());
        });
        executor.execute(() -> {
            threadLocal.set("______B");
            System.err.println(Thread.currentThread().getName() + "\t" + threadLocal.get());
        });
        executor.execute(() -> {
            System.err.println(Thread.currentThread().getName() + "\t" + threadLocal.get());
        });
        executor.execute(() -> {
            System.err.println(Thread.currentThread().getName() + "\t" + threadLocal.get());
        });
    }

}
