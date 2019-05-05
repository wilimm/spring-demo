package com.wilimm.ch05;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * @Author: wilimm
 * @Date: 2019/5/5 20:13
 */
public class MyPointcut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                // 匹配所有的类
                return true;
            }
        };
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        // 继承 StaticMethodMatcher，忽略方法实参，只对方法进行动态匹配。
        return new StaticMethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                // 如果方法名称是 go，则匹配，否则不匹配
                if (method.getName().equals("go")) {
                    return true;
                }
                return false;
            }
        };
    }
}
