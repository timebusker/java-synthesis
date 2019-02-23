package com.timebusker.generics;

import com.timebusker.generics.model.UserModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
        GenericsClassTest test1 = new GenericsClassTest();
        test1.setKey(ii);
        System.out.println(test1.getKey().toString());

        // 获取泛型class
        GenericsClassTest test2 = new GenericsClassTest<UserModel>();
        test2.paras();
    }

    public void paras() {
        // 获取泛型class
        Class clazz = getClass();
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            System.err.println(Object.class.getName());
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (0 >= params.length || 0 < 0) {
            System.err.println(Object.class.getName());
        }
        if (!(params[0] instanceof Class)) {
            System.err.println(Object.class.getName());
        }
        System.err.println(clazz.getName());
    }
}
