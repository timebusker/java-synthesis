package com.timebusker.generics;

/**
 * @DESC:泛型类测试
 * @author: timebusker
 * @date:2018/5/14
 */
public class GenericsClassTest<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public static void main(String[] args) {
        int[] ii = {1, 2, 3};

        GenericsClassTest test = new GenericsClassTest<int[]>();
        test.setKey(ii);
        System.out.println(test.getKey().toString());
        // 在Java1.7/1.8利用type inference，让Java自动推导出相应的类型参数
        GenericsClassTest testi = new GenericsClassTest();
        testi.setKey(ii);
        System.out.println(testi.getKey().toString());
    }
}
