package com.timebusker.annotation.domain;

import com.timebusker.annotation.TimeBusker;

/**
 * @Description: Child
 * @Author: Administrator
 * @Date: 2020/1/19 21:41
 **/
// 可覆盖父类上的内容（本注解可以从父类继承）
@TimeBusker(description = "学生类")
public class Student extends Person {

    @TimeBusker(description = "学生类构造函数")
    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @TimeBusker(description = "学生需要做的事情：")
    public void study() {
        System.out.println("--->学生要多读书！");
    }

}
