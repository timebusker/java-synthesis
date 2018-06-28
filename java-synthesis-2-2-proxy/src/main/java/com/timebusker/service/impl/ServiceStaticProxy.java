package com.timebusker.service.impl;

import com.timebusker.service.IService;
import com.timebusker.service.impl.ServiceImpl;

/**
 * @DESC:IServiceProxy:静态代理类
 * @author:timebusker
 * @date:2018/6/28
 */
public class ServiceStaticProxy implements IService {

    /**
     * 可采用多种方式初始化具体功能的实现类,基于构造函数初始化实例，
     * 可实现对多个实例接口进行代理
     */
    IService service = new ServiceImpl();

    public ServiceStaticProxy() {
    }

    @Override
    public String say(String word) {
        System.out.println("说话前！");
        String res = service.say(word);
        System.out.println("说话后！");
        return res;
    }
}
