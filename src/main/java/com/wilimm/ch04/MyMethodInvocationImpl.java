package com.wilimm.ch04;;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: wilimm
 * @Date: 2019/5/4 14:21
 */
@Data
public class MyMethodInvocationImpl implements MyMethodInvocation {

    /**
     * 拦截器链
     */
    private List<MyMethodInterceptor> interceptorList;

    /**
     * 被代理的目标方法
     */
    private TargetMethod targetMethod;

    /**
     * 当前调用的拦截器索引
     */
    private int currentInterceptorIndex = 0;

    @Override
    public Object proceed() throws Throwable {
        /**
         *  索引值从 0 开始递增，所以如果 currentInterceptorIndex 等于拦截器集合大小，说明所有的拦截器都执行完毕了
         */
        if (this.currentInterceptorIndex == this.interceptorList.size()) {
            // 调用目标方法
            return targetMethod.getMethod().invoke(targetMethod.getTarget(), targetMethod.getArgs());
        }

        // 获取下一个拦截器，并调用其 invoke 方法
        MyMethodInterceptor methodInterceptor =
                this.interceptorList.get(this.currentInterceptorIndex++);

        return methodInterceptor.invoke(this);
    }
}