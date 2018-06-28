package com.timebusker;

import com.timebusker.service.IService;
import com.timebusker.service.impl.*;
import org.junit.Test;

/**
 * @DESC:Application
 * @author:timebusker
 * @date:2018/6/28
 */
public class Application {

    /**
     * 测试静态代理模式
     */
    @Test
    public void testStaticProxy() {
        IService service = new ServiceStaticProxy();
        System.out.println(service.say("timebusker"));
    }

    /**
     * 测试JDK动态代理模式
     */
    @Test
    public void testJdkProxy() {
        IService service = new ServiceJdkProxy().getService();
        System.out.println(service.say("timebusker"));
    }

    /**
     * 测试CGlib动态代理模式
     */
    @Test
    public void testCglibProxy() {
        IService service = new ServiceCglibProxy().getService();
        System.out.println(service.say("timebusker"));
    }

}
