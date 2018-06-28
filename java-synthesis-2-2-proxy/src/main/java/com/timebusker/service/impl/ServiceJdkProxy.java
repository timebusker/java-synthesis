package com.timebusker.service.impl;

import com.timebusker.service.IService;

import java.lang.reflect.*;

/**
 * @DESC:ServiceJdkProxy
 * @author:timebusker
 * @date:2018/6/28
 */
public class ServiceJdkProxy {

    /**
     * 可采用多种方式初始化具体功能的实现类,基于构造函数初始化实例，
     * 可实现对多个实例接口进行代理
     */
    IService service = new ServiceImpl();

    public ServiceJdkProxy() {
    }

    public IService getService() {
        return (IService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 指定特定功能进行增强
                if ("say".equals(method.getName())) {
                    System.out.println("说话前！");
                    Object res = method.invoke(args);
                    System.out.println("说话后！");
                    return res;
                }
                return null;
            }
        });
    }
}
