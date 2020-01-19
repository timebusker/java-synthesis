package com.timebusker.reflect.domain;

import com.timebusker.annotation.TimeBusker;

/**
 * @Description: Person
 * @Author: Administrator
 * @Date: 2020/1/19 9:53
 **/
public class Person {

    /**
     * 私有字段属性
     */
    @TimeBusker
    private String name;
    private int age;

    /**
     * 公有字段属性
     */
    public int id;

    public Person() {
        System.out.println("person run");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void show(String name, int age) {
        System.out.println("show run...name=" + name + ",age=" + age);
    }

    public static void show() {
        System.out.println("static show run");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
