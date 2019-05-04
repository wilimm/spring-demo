package com.wilimm.ch04;

import lombok.Data;

import java.lang.reflect.Method;

/**
 *  被代理的方法
 *
 * @Author: wilimm
 * @Date: 2019/5/4 14:26
 */
@Data
public class TargetMethod {
    /**
     *  目标对象（也被称为被代理对象）
     */
    private Object target;

    /**
     * 目标对象中的被代理方法
     */
    private Method method;

    /**
     * 被代理方法的参数列表
     */
    private Object[] args;
}
