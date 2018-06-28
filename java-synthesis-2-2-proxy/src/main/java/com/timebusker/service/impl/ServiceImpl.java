package com.timebusker.service.impl;

import com.timebusker.service.IService;

/**
 * @DESC:ServiceImpl
 * @author:timebusker
 * @date:2018/6/28
 */
public class ServiceImpl implements IService {
    @Override
    public String say(String word) {
        System.out.println("我直接说的话是：" + word);
        return System.currentTimeMillis() + "";
    }
}
