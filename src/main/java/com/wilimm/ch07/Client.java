package com.wilimm.ch07;

import com.wilimm.ch03.CglibDynamicProxy;
import com.wilimm.ch03.Service;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Author: wilimm
 * @Date: 2019/5/2 17:06
 */
public class Client {
    public static void main(String[] args) {
        // 获取当前项目的根目录
        String userDir = System.getProperty("user.dir");
        //System.setProperty("cglib.debugLocation", userDir);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, userDir);

        // 1. 构造目标对象
        Service target = new Service();

        // 2. 根据目标对象生成代理对象
        CglibDynamicProxy proxy = new CglibDynamicProxy(target);

        // 获取 CGLIB 代理类
        Service proxyObject = proxy.getProxy();


        CglibDynamicProxy proxy2 = new CglibDynamicProxy(proxyObject);

        // 生成 CGLIB 代理类的代理类，会在 enhancer.create() 调用时出现  java.lang.ClassFormatError: Duplicate method name "newInstance" 异常
        Object proxyObject2 = proxy2.getProxy();
    }
}
