package com.wilimm.ch04;

import com.wilimm.ch02.Animal;
import com.wilimm.ch02.Cat;

/**
 * @Author: wilimm
 * @Date: 2019/5/4 13:09
 */
public class Client3 {

    public static void main(String[] args) {
        // 1. 构造目标对象
        Cat catTarget = new Cat();

        // 2. 根据目标对象生成代理对象
        JdkDynamicProxy3 proxy = new JdkDynamicProxy3();
        proxy.setTarget(catTarget);

        // 3. 添加方法拦截器
        proxy.addMethodInterceptor(new MethodInterceptor1());
        proxy.addMethodInterceptor(new MethodInterceptor2());

        // JDK 动态代理是基于接口的，所以只能转换为 Cat 实现的接口 Animal
        Animal catProxy = proxy.getProxy();

        // 调用代理对象的方法
        catProxy.eat();
    }

    private static class MethodInterceptor1 implements MyMethodInterceptor {
        @Override
        public Object invoke(MyMethodInvocation invocation) throws Throwable {
            System.out.println("MethodInterceptor1 处理开始-------------------------------");

            Object ret = invocation.proceed();

            System.out.println("MethodInterceptor1 处理完成-------------------------------");
            return ret;
        }
    }

    private static class MethodInterceptor2 implements MyMethodInterceptor {
        @Override
        public Object invoke(MyMethodInvocation invocation) throws Throwable {
            System.out.println("MethodInterceptor2 处理开始-------------------------------");

            Object ret = invocation.proceed();

            System.out.println("MethodInterceptor2 处理完成-------------------------------");
            return ret;
        }
    }
}
