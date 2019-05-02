package com.wilimm.proxy.jdk;

/**
 * @Author: wilimm
 * @Date: 2019/5/2 11:38
 */
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
