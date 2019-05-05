package com.wilimm.ch05;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;

/**
 * @Author: wilimm
 * @Date: 2019/5/5 16:11
 */
public class MyPointcutAdvisor extends AbstractPointcutAdvisor {

    @Override
    public Pointcut getPointcut() {
        return null;
    }

    @Override
    public Advice getAdvice() {
        return null;
    }
}
