package com.timebusker.annotation.domain;

import com.timebusker.annotation.TimeBusker;

/**
 * @Description: Person
 * @Author: Administrator
 * @Date: 2020/1/19 21:36
 **/
@TimeBusker(description = "抽象父类")
public abstract class Person {

    @TimeBusker(description = "父类构造函数")
    public Person() {
    }

    @TimeBusker(description = "姓名")
    public String name;

    @TimeBusker(description = "性别")
    public String sex;

    @TimeBusker(description = "年龄")
    public int age;

    @TimeBusker(description = "自我介绍")
    public void sayHello() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", sex='" + sex + '\'' + ", age=" + age + '}';
    }
}
