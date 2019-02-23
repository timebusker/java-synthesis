package com.timebusker.threadlocal;

/**
 * Created by HP on 2019/2/23.
 */
public class SingleThreadLocalTest {

    public static void main(String[] args) {
        SingleThreadLocalTest test = new SingleThreadLocalTest();
        test.thread1();
        test.thread2();
    }

    private void thread1() {
        ThreadLocal<Object> localObject = new ThreadLocal();
        localObject.set("++++++++++++++++++++++++");
        System.err.println(Thread.currentThread().getName() + "\t" + localObject.get());
    }

    private void thread2() {
        ThreadLocal<Object> localObject = new ThreadLocal();
        localObject.set("-------------------------");
        System.err.println(Thread.currentThread().getName() + "\t" + localObject.get());
    }
}
