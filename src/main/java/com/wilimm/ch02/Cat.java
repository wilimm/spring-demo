package com.wilimm.ch02;

/**
 * @Author: wilimm
 * @Date: 2019/5/2 11:38
 */
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void go() {
        System.out.println("猫在跑");
    }
}
