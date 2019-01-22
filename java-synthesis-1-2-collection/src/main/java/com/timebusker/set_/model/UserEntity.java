package com.timebusker.set_.model;

/**
 * @DESC:UserEntity
 * @author:timebusker
 * @date:2019/1/22
 */
public class UserEntity implements Comparable {
    private String name;
    private int age;

    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public int compareTo(Object o) {
        if (o instanceof UserEntity) {
            UserEntity user = (UserEntity) o;
            return this.getAge() - user.getAge();
        } else {
            return 0;
        }
    }
}
