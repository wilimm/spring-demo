package com.wilimm.ch04;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: wilimm
 * @Date: 2019/5/4 12:44
 */
@Data
public abstract class AbstractHandler {

    /**
     * 责任链中下一个处理者
     */
    private AbstractHandler nextHandler;

    /**
     * 是否有下一个处理者
     * @return
     */
    public boolean hasNextHandler() {
        return this.nextHandler != null;
    }

    abstract Object invoke(TargetMethod targetMethod) throws Throwable;


    public final Object proceed(TargetMethod targetMethod) throws Throwable {
        // 如果没有下一个处理者，则直接调用目标对象的被代理方法
        if (!hasNextHandler()) {
           return targetMethod.getMethod().invoke(targetMethod.getTarget(), targetMethod.getArgs());
        }

        // 否则调用下一个处理者的方法
        return this.nextHandler.invoke(targetMethod);
    }

    /**
     *  第一个 Handler，不做额外处理，起驱动责任链向前调用的作用
     */
    public static class HeadHandler extends AbstractHandler {

        @Override
        Object invoke(TargetMethod targetMethod) throws Throwable {
            return null;
        }
    }
}
