package com.wilimm.ch05;

import com.wilimm.ch02.Animal;
import com.wilimm.ch02.Cat;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @Author: wilimm
 * @Date: 2019/5/5 10:53
 */
public class ProxyFactoryDemo {

    public static void main(String[] args) {
        // 1. 构造目标对象
        Animal catTarget = new Cat();

        // 2. 通过目标对象，构造 ProxyFactory 对象
        ProxyFactory factory = new ProxyFactory(catTarget);

        // 添加一个 Advice (DefaultPointcutAdvisor)
        factory.addAdvice(new MyMethodInterceptor());

        // 添加一个 PointcutAdvisor
        MyPointcutAdvisor myPointcutAdvisor = new MyPointcutAdvisor(new MyMethodInterceptor());
        factory.addAdvisor(myPointcutAdvisor);

        // 3. 根据目标对象生成代理对象
        Object proxy = factory.getProxy();

        Animal cat = (Animal) proxy;
        System.out.println(cat.getClass());
        cat.eat();

        System.out.println("---------------------------------------");

        cat.go();
    }

    public static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            System.out.println("MyMethodInterceptor invoke 调用 before invocation.proceed");

            Object ret = invocation.proceed();

            System.out.println("MyMethodInterceptor invoke 调用 after invocation.proceed");
            return ret;
        }
    }

    public static class MyMethodBeforeAdvice implements MethodBeforeAdvice {

        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("MyMethodBeforeAdvice before 调用");

                System.out.println(method.getName());
        }
    }
}
