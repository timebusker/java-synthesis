package com.timebusker.threadlocal;

/**
 * Created by HP on 2019/2/23.
 */
public class InheritableThreadLocalsTest {

    private static ThreadLocal<Object> localObject = new InheritableThreadLocal<>();

    /**
     * 父子线程控制
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int key = i;
            if (i == 0) {
                localObject.set("B______" + key);
            }
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.err.println(Thread.currentThread().getName() + "\t" + localObject.get().toString());
                    localObject.set("A______" + key);
                    System.err.println(Thread.currentThread().getName() + "\t" + localObject.get().toString());
                }
            });
            t.start();
        }
    }
}
