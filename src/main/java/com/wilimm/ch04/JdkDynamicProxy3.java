package com.wilimm.ch04;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wilimm
 * @Date: 2019/5/4 13:07
 */
@Data
public class JdkDynamicProxy3 implements InvocationHandler {

    /**
     * 目标对象（也被称为被代理对象）
     */
    private Object target;

    /**
     * 拦截器链
     */
    private List<MyMethodInterceptor> interceptorList = new ArrayList<>();

    public void addMethodInterceptor(MyMethodInterceptor methodInterceptor) {
        this.interceptorList.add(methodInterceptor);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TargetMethod targetMethod = new TargetMethod();
        targetMethod.setTarget(target);
        targetMethod.setMethod(method);
        targetMethod.setArgs(args);

        MyMethodInvocationImpl methodInvocation = new MyMethodInvocationImpl();
        methodInvocation.setTargetMethod(targetMethod);
        methodInvocation.setInterceptorList(interceptorList);

        return methodInvocation.proceed();
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