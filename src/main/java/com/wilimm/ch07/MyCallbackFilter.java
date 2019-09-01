package com.wilimm.ch07;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @Author: wilimm
 * @Date: 2019/5/7 17:09
 */
public class MyCallbackFilter implements CallbackFilter {
 
    /**
     * 过滤方法
     * 返回的值为数字，代表了 Callback 数组中的索引位置，要到用的 Callback
     */
    @Override
    public int accept(Method method) {
        if(method.getName().equals("method1")){
            System.out.println("filter method1 ==0");
            return 0;
        }
        if(method.getName().equals("returnThis")){
            System.out.println("filter returnThis ==1");
            return 3;
        }
        return 0;
    }
 
}