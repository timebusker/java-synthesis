package com.timebusker.service.impl;

import com.timebusker.service.IService;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @DESC:ServiceCglibProxy
 * @author:timebusker
 * @date:2018/6/29
 */
public class ServiceCglibProxy implements MethodInterceptor {

    /**
     * 可采用多种方式初始化具体功能的实现类,基于构造函数初始化实例，
     * 可实现对多个实例接口进行代理
     */
    private IService service = new ServiceImpl();
//    private ServiceImpl service = new ServiceImpl();

    public IService getService() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(service.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return (IService) en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("say".equals(method.getName())) {
            System.out.println("说话前！");
            // 代理类调用父类的方法
            Object Object = methodProxy.invokeSuper(o, args);
            // 代理类调用父类的方法
            Object res = method.invoke(service, args);
            System.out.println("说话后！");
            return res;
        }
        return null;
    }
}
