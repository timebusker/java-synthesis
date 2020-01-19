package com.timebusker.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * @Description: AbstractAlgorithm
 * @Author: Administrator
 * @Date: 2020/1/17 10:54
 **/
public abstract class AbstractAlgorithm {

    protected static final int[] array = {5, 8, 7, 9, 2, 32, 65, 12, 0, 34, 1, 76};

    protected static final int des = 1;

    public static void println(Object object) {
        System.err.println(JSON.toJSONString(object));
    }

    protected static final Node root = new Node(0);

    static {
        Node left = new Node(1);
        Node right = new Node(2);
        Node sub1 = new Node(3);
        Node sub2 = new Node(4);
        right.setLeft(sub1);
        right.setRight(sub2);
        Node sub11 = new Node(5);
        Node sub12 = new Node(6);
        Node sub21 = new Node(7);
        Node sub22 = new Node(8);
        sub1.setLeft(sub11);
        sub1.setRight(sub12);
        sub2.setLeft(sub21);
        sub2.setRight(sub22);
        root.setLeft(left);
        root.setRight(right);
    }
}
