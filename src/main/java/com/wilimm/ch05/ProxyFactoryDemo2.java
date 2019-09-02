package com.wilimm.ch05;

import com.wilimm.ch02.Animal;
import com.wilimm.ch02.Cat;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author: wilimm
 * @Date: 2019/5/5 10:53
 */
public class ProxyFactoryDemo2 {

    public static void main(String[] args) {
        // 1. 构造目标对象
        Animal catTarget = new Cat();

        // 2. 通过目标对象，构造 ProxyFactory 对象
        ProxyFactory factory = new ProxyFactory(catTarget);
        factory.setProxyTargetClass(true);

        // 添加一个 Advice (DefaultPointcutAdvisor)
        factory.addAdvice(new MyMethodInterceptor());

        // 3. 根据目标对象生成代理对象
        Object proxy = factory.getProxy();

        Animal cat = (Animal) proxy;
     //   System.out.println(cat.getClass());
        cat.eat();

        System.out.println("---------------------------------------");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        // 2. 通过目标对象，构造 ProxyFactory 对象
        ProxyFactory factory2 = new ProxyFactory(proxy);
        factory2.setProxyTargetClass(true);

        // 添加一个 Advice (DefaultPointcutAdvisor)
        factory2.addAdvice(new MyMethodInterceptor());

        // 3. 根据目标对象生成代理对象
        Object proxy2 = factory2.getProxy();
        Animal cat2 = (Animal) proxy2;
     //   System.out.println(cat2.getClass());

        cat2.eat();
    }

    public static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            System.out.println("MyMethodInterceptor invoke 调用 before invocation.proceed");


            ReflectiveMethodInvocation reflectiveMethodInvocation = (ReflectiveMethodInvocation) invocation;
           // System.out.println(reflectiveMethodInvocation.getProxy());
            Object aThis = invocation.getThis();
            Method method = invocation.getMethod();
            System.out.println("aThis = " + aThis);
            System.out.println("method = " + method);
            System.out.println("method.getDeclaringClass() = " + method.getDeclaringClass());

            Object ret = invocation.proceed();

            System.out.println("MyMethodInterceptor invoke 调用 after invocation.proceed");
            return ret;
        }
    }
}
