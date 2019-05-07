package com.wilimm.ch07;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wilimm
 * @Date: 2019/5/7 17:09
 */
public class MyMethodInterceptor1  implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("MyMethodInterceptor1 intercept 方法执行前-------------------------------");

        System.out.println("obj = " + obj.getClass());
        System.out.println("method = " + method);
        System.out.println("proxy = " + proxy);

        Object retVal = proxy.invokeSuper(obj, args);

        System.out.println("MyMethodInterceptor1 intercept 方法执行后-------------------------------");
        return retVal;
    }
}
