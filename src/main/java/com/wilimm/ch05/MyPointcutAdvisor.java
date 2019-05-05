package com.wilimm.ch05;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.AbstractPointcutAdvisor;

import java.awt.*;

/**
 * @Author: wilimm
 * @Date: 2019/5/5 16:11
 */
public class MyPointcutAdvisor implements PointcutAdvisor {

    private Pointcut pointcut = new MyPointcut();

    private Advice advice;

    public MyPointcutAdvisor(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}