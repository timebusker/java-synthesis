package com.timebusker.generics.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @DESC:泛型类测试
 * @author:
 * @date:2018/5/14timebusker
 */
public class UserModel {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
