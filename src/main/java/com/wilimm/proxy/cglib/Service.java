package com.wilimm.proxy.cglib;

import net.sf.cglib.core.Predicate;

/**
 * @Author: wilimm
 * @Date: 2019/5/2 16:33
 */
public class Service {

    /**
     *  final 方法不能被子类覆盖
     */
    public final void finalMethod() {
        System.out.println("Service.finalMethod 执行了");
    }

    public void publicMethod() {
        System.out.println("Service.publicMethod 执行了");
    }
}
