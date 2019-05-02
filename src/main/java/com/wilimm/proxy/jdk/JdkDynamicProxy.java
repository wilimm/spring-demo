package com.wilimm.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wilimm
 * @Date: 2019/5/2 11:39
 */
public class JdkDynamicProxy implements InvocationHandler {
    /**
     *  目标对象（也被称为被代理对象）
     *
     *      Java 代理模式的一个必要要素就是代理对象要能拿到被代理对象的引用
     */
    private Object target;

    public JdkDynamicProxy(Object target){
        this.target=target;
    }

    /**
     * 回调方法
     * @param proxy JDK 生成的代理对象
     * @param method 被代理的方法（也就是需要增强的方法）
     * @param args  被代理方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JdkDynamicProxy invoke 方法执行前-------------------------------");
        Object object= method.invoke(target,args);
        System.out.println("JdkDynamicProxy invoke 方法执行后-------------------------------");
        return object;
    }

    /**
     * 获取被代理接口实例对象
     *
     *      通过 Proxy.newProxyInstance 可以获得一个代理对象，它实现了 target.getClass().getInterfaces() 接口
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}