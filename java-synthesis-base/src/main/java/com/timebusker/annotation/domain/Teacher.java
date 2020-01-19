package com.timebusker.annotation.domain;

import com.timebusker.annotation.TimeBusker;

/**
 * @Description: Father
 * @Author: Administrator
 * @Date: 2020/1/19 21:45
 **/
public class Teacher extends Person {

    @TimeBusker(description = "教师类构造函数")
    public Teacher(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @TimeBusker(description = "老师应该做的事情：")
    public void teach() {
        System.out.println("教小孩子读书！");
    }
}
