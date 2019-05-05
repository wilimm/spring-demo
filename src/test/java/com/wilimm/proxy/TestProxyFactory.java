package com.wilimm.proxy;

import com.wilimm.ch02.Animal;
import com.wilimm.ch02.Cat;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @Author: wilimm
 * @Date: 2019/5/3 15:09
 */
public class TestProxyFactory {

    public static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            System.out.println("MyMethodInterceptor invoke 调用 before invocation.proceed");

            Object ret = invocation.proceed();

            System.out.println("MyMethodInterceptor invoke 调用 after invocation.proceed");
            return ret;
        }
    }

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new Cat());
        factory.addAdvice(new MyMethodInterceptor());

        Animal cat = (Animal) factory.getProxy();
        cat.eat();
    }
}
