package com.wilimm.ch04;

import com.wilimm.ch02.Animal;
import com.wilimm.ch02.Cat;

/**
 * @Author: wilimm
 * @Date: 2019/5/4 13:09
 */
public class Client2 {

    public static void main(String[] args) {
        // 1. 构造目标对象
        Cat catTarget = new Cat();

        // 2. 构造 Handler 对象
        AbstractHandler headHandler = new AbstractHandler.HeadHandler();

        AbstractHandler handler1 = new Handler1();
        headHandler.setNextHandler(handler1);

        Handler2 handler2 = new Handler2();
        handler1.setNextHandler(handler2);

        // 3. 根据目标对象生成代理对象
        JdkDynamicProxy2 proxy = new JdkDynamicProxy2(catTarget, headHandler);

        // JDK 动态代理是基于接口的，所以只能转换为 Cat 实现的接口 Animal
        Animal catProxy = proxy.getProxy();

        // 调用代理对象的方法
        catProxy.eat();
    }

    private static class Handler1 extends AbstractHandler {

        @Override
        Object invoke(TargetMethod targetMethod) throws Throwable {
            System.out.println("Handler1 处理开始-------------------------------");

            Object ret = super.proceed(targetMethod);

            System.out.println("Handler1 处理完成-------------------------------");
            return ret;
        }
    }

    private static class Handler2 extends AbstractHandler {

        @Override
        Object invoke(TargetMethod targetMethod) throws Throwable {
            System.out.println("Handler2 处理开始-------------------------------");

            Object ret = super.proceed(targetMethod);

            System.out.println("Handler2 处理完成-------------------------------");
            return ret;
        }
    }
}
