package com.wilimm.ch04;

import com.wilimm.ch02.Animal;
import com.wilimm.ch02.Cat;

/**
 * @Author: wilimm
 * @Date: 2019/5/4 11:41
 */
public class Client1 {
    public static void main(String[] args) {
        // 1. 构造目标对象
        Cat catTarget = new Cat();

        // 2. 根据目标对象生成代理对象
        JdkDynamicProxy1 proxy = new JdkDynamicProxy1(catTarget);
        proxy.setTag("第一个代理类");

        // JDK 动态代理是基于接口的，所以只能转换为 Cat 实现的接口 Animal
        Animal catProxy = proxy.getProxy();

        // 3. 根据第一个代理对象生成代理对象
        JdkDynamicProxy1 proxy2 = new JdkDynamicProxy1(catProxy);
        proxy2.setTag("第二个代理类");

        // JDK 动态代理是基于接口的，所以只能转换为 Cat 实现的接口 Animal
        Animal catProxy2 = proxy2.getProxy();

        // 调用代理对象的方法
        catProxy2.eat();
    }
}
