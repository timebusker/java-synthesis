package com.timebusker.annotation;

import com.timebusker.annotation.domain.Person;
import com.timebusker.annotation.domain.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: AnnotationProcess
 * @Author: Administrator
 * @Date: 2020/1/19 21:32
 **/
public class AnnotationProcess {

    public static void process(Object object) throws Exception {
        if (object != null) {
            Class clazz = object.getClass();
            // 获取类上的注解(如果注解存在便进行处理)
            if (clazz.isAnnotationPresent(TimeBusker.class)) {
                TimeBusker busker = (TimeBusker) clazz.getAnnotation(TimeBusker.class);
                System.err.println("类上的描述信息是：" + busker.description());
            }
            // 获取构造函数上的注解
            Constructor constructor = clazz.getConstructor(String.class, String.class, int.class);
            if (constructor.isAnnotationPresent(TimeBusker.class)) {
                TimeBusker busker = (TimeBusker) constructor.getAnnotation(TimeBusker.class);
                System.err.println("构造函数上的描述信息是：" + busker.description());
            }
            // 获取属性对象信息的注解
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                TimeBusker busker = field.getAnnotation(TimeBusker.class);
                System.err.println("属性对象上的描述信息是：" + busker.description());
            }
            // 获取方法上的注解
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(TimeBusker.class)) {
                    TimeBusker busker = method.getAnnotation(TimeBusker.class);
                    System.err.println("对象方法上的描述信息是：" + busker.description());
                }
            }
            System.out.println(object.toString());
        } else {
            throw new RuntimeException("无法向下转型到指定类");
        }
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("tom", "男", 21);
        AnnotationProcess.process(student);
    }
}
