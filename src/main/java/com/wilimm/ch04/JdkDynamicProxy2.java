package com.wilimm.ch04;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wilimm
 * @Date: 2019/5/4 13:07
 */
@AllArgsConstructor
public class JdkDynamicProxy2 implements InvocationHandler {

    /**
     * 目标对象（也被称为被代理对象）
     */
    private Object target;

    /**
     * 责任链第一个处理 Handler
     */
    private AbstractHandler firstHandler;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TargetMethod targetMethod = new TargetMethod();
        targetMethod.setTarget(target);
        targetMethod.setMethod(method);
        targetMethod.setArgs(args);

        return firstHandler.proceed(targetMethod);
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
