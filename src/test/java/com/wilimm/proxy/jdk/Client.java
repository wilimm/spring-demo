package com.wilimm.proxy.jdk;

/**
 * @Author: wilimm
 * @Date: 2019/5/2 11:40
 */
public class Client {
    public static void main(String[] args) {
        // 设置此系统属性,让 JVM 生成的 Proxy 类写入文件.保存路径为项目的根目录
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 1. 构造目标对象
        Cat catTarget = new Cat();

        // 2. 根据目标对象生成代理对象
        JdkDynamicProxy proxy = new JdkDynamicProxy(catTarget);

        // JDK 动态代理是基于接口的，所以只能转换为 Cat 实现的接口 Animal
        Animal catProxy = proxy.getProxy();

        // 调用代理对象的方法
        catProxy.eat();
    }
}
