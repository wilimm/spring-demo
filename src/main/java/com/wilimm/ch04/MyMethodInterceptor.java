package com.wilimm.ch04;

/**
 *  在到达目标方法之前拦截对方法的调用。
 *
 * @Author: wilimm
 * @Date: 2019/5/4 14:16
 */
public interface MyMethodInterceptor {

    Object invoke(MyMethodInvocation invocation) throws Throwable;
}
