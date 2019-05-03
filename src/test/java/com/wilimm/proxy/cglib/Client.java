package com.wilimm.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.core.Predicate;

/**
 * @Author: wilimm
 * @Date: 2019/5/2 17:06
 */
public class Client {
    public static void main(String[] args) {


        // 1. 构造目标对象
        Service target = new Service();

        // 2. 根据目标对象生成代理对象
        CglibDynamicProxy proxy = new CglibDynamicProxy(target);

        // 获取 CGLIB 代理类
        Service proxyObject = proxy.getProxy();

        // 调用代理对象的方法
        proxyObject.finalMethod();
        proxyObject.publicMethod();
    }
}
