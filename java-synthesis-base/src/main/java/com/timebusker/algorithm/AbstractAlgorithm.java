package com.timebusker.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * @Description: AbstractAlgorithm
 * @Author: Administrator
 * @Date: 2020/1/17 10:54
 **/
public abstract class AbstractAlgorithm {

    protected static final int[] array = {5, 8, 7, 9, 2, 32, 65, 12, 0, 34, 1, 76};

    public static void println(Object object) {
        System.err.println(JSON.toJSONString(object));
    }

}
