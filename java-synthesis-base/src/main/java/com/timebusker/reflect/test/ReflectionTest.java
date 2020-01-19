package com.timebusker.reflect.test;

import com.timebusker.reflect.domain.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * @Description: ReflectionTest
 * <p>
 * 动态的获取指定的类以及动态的调用类中的内容
 * @Author: Administrator
 * @Date: 2020/1/19 9:54
 **/
public class ReflectionTest {

    /*
     * 要想获取字节码文件中的成员，必须要先获取字节码文件对象。获取字节码文件对象的方式：
     * 1，通过Object类中的getClass方法。虽然通用，但是前提必须有指定类，并对该类进行对象的创建，才可以调用getClass方法。
     * 2，使用的任意数据类的一个静态成员class，所有的数据类型都具备的一个属性。好处：不用new对象。但是，还需要使用具体的类。
     * 3，使用Class类中的forName方法。通过给定类名来获取对应的字节码文件对象。
     *
     * 第3种方式很爽，只要知道类的名字就可以了。获取对应的字节码文件直接由forName方法自动完成。
     * 这就是反射技术使用的获取字节码文件对象的方式。
     */

    /**
     * getFields()与getDeclaredFields()区别:
     * getFields()只能访问类中声明为公有的字段,私有的字段它无法访问，能访问从其它类继承来的公有方法.
     * getDeclaredFields()能访问类中所有的字段,与public,private,protect无关，不能访问从其它类继承来的方法
     *
     *  getMethods()与getDeclaredMethods()区别:
     *  getMethods()只能访问类中声明为公有的方法,私有的方法它无法访问,能访问从其它类继承来的公有方法.
     *  getDeclaredFields()能访问类中所有的字段,与public,private,protect无关,不能访问从其它类继承来的方法
     *
     *
     * getConstructors()与getDeclaredConstructors()区别:
     * getConstructors()只能访问类中声明为public的构造函数.
     * getDeclaredConstructors()能访问类中所有的构造函数,与public,private,protect无关
     */

    /**
     * 使用无参构造函数初始化
     *
     * @throws Exception
     */
    @Test
    public void initClass() throws Exception {
        String className = "com.timebusker.reflect.domain.Person";
        // 通过给定的类名称，加载对应的字节码文件，并封装成字节码文件对象Class.
        Class clazz = Class.forName(className);
        System.out.println(clazz);
        // 通过newInstance()就可以创建字节码对象所表示的类的实例（直接调用无参构造函数初始化）。
        Person person = (Person) clazz.newInstance();
        System.out.println(person);
    }

    /**
     * 使用有参参构造函数初始化
     *
     * @throws Exception
     */
    @Test
    public void initByConstructor() throws Exception {
        String className = "com.timebusker.reflect.domain.Person";
        Class clazz = Class.forName(className);
        // 获取指定的构造器。获取Person类中两个参数string,int的构造函数。
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        // 有了构造器对象后，通过构造器对象来初始化给类对象。
        Person person = (Person) constructor.newInstance("wangwu", 23);
        System.out.println(person);
    }

    /**
     * 反射执行方法
     *
     * @throws Exception
     */
    @Test
    public void getMethod() throws Exception {
        String className = "com.timebusker.reflect.domain.Person";
        Class clazz = Class.forName(className);
        String methodName = "show";
        Method method = clazz.getMethod(methodName, String.class, int.class);
        Object obj = clazz.newInstance();
        method.invoke(obj, "wangcai", 20);

        // 执行静态方法
        method = clazz.getMethod(methodName, null);
        method.invoke(null, null);
    }

    /**
     * 反射获取属性
     *
     * @throws Exception
     */
    @Test
    public void getFields() throws Exception {
        String className = "com.timebusker.reflect.domain.Person";
        Class clazz = Class.forName(className);
        // 对其进行值的设置，必须先有对象
        Object object = clazz.newInstance();
        // 反射对象属性赋值
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", "time busker");
        params.put("age", 30);
        invoke(object, params);
        System.out.println(object);

        // 所有声明的字段，不包括继承得到的字段。
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.err.println("可访问私有封装（private修饰）的字段  " + field.getName());
            // 获取字段属性值
            // 取消权限检查，暴力访问(一般不访问私有)。
            field.setAccessible(true);
            System.err.println("字段属性值：" + field.getName() + " ：" + field.get(object));
            // 获取对象注释
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        }
        // Class对应对象能访问到的所有pubic字段，包括继承得到的
        fields = clazz.getFields();
        for (Field field : fields) {
            System.err.println("只能访问公有封装（public修饰）的字段  " + field.getName());
        }
    }


    /**
     * 时间格式设置
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 反射设置对象属性
     *
     * @param instance
     * @param params
     */
    public static void invoke(Object instance, HashMap<String, Object> params) {
        try {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                // 取消权限检查，暴力访问(一般不访问私有)。
                field.setAccessible(true);
                String name = field.getName();
                if (params.containsKey(name)) {
                    String value = params.get(name).toString();
                    if (field.getType().getName().equals("java.math.BigDecimal")) {
                        if (StringUtils.isNotBlank(value)) {
                            BigDecimal column = new BigDecimal(value);
                            field.set(instance, column);
                        }
                    } else if (field.getType().getName().equals("java.lang.Integer")) {
                        if (StringUtils.isNotBlank(value)) {
                            Integer column = new Integer(value);
                            field.set(instance, column);
                        }
                    } else if (field.getType().getName().equals("java.lang.Long")) {
                        if (StringUtils.isNotBlank(value)) {
                            Long column = new Long(value);
                            field.set(instance, column);
                        }
                    } else if (field.getType().getName().equals("java.lang.Double")) {
                        if (StringUtils.isNotBlank(value)) {
                            Double column = new Double(value);
                            field.set(instance, column);
                        }
                    } else if (field.getType().getName().equals("java.time.LocalDateTime")) {
                        if (StringUtils.isNotBlank(value)) {
                            LocalDateTime column = LocalDateTime.parse(value, formatter);
                            field.set(instance, column);
                        }
                    } else if (field.getType().getName().equals("int")) {
                        if (StringUtils.isNotBlank(value)) {
                            int column = Integer.parseInt(value);
                            field.set(instance, column);
                        }
                    } else if (field.getType().getName().equals("long")) {
                        if (StringUtils.isNotBlank(value)) {
                            long column = Long.parseLong(value);
                            field.set(instance, column);
                        }
                    } else if (field.getType().getName().equals("boolean")) {
                        if (StringUtils.isNotBlank(value)) {
                            boolean column = Boolean.parseBoolean(value);
                            field.set(instance, column);
                        }
                    } else {
                        field.set(instance, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
