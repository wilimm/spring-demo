package com.wilimm.ch07;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.io.Serializable;


/**
 * @Author: wilimm
 * @Date: 2019/5/7 17:01
 */
public class CglibDemo {

    public static class SerializableNoOp implements NoOp, Serializable {
    }

    /**
     * 直接用 loadObject 返回的对象调用被 CallbackFilter accept 的方法
     */
    public static class StaticDispatcher implements Dispatcher, Serializable {
        @Override
        public Object loadObject() {
            Service service = new Service();
            service.setTag("StaticDispatcher");
            return service;
        }
    }


    public static void main(String[] args) {
        // 获取当前项目的根目录
        String userDir = System.getProperty("user.dir");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, userDir);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);

        MyMethodInterceptor1 myMethodInterceptor1 = new MyMethodInterceptor1();
        MyMethodInterceptor2 myMethodInterceptor2 = new MyMethodInterceptor2();

        Callback[] callbacks =  new Callback[] {
                myMethodInterceptor1,
                myMethodInterceptor2,
                new SerializableNoOp(),
                new StaticDispatcher()
        };

        enhancer.setCallbacks(callbacks);

        MyCallbackFilter myCallbackFilter = new MyCallbackFilter();
        enhancer.setCallbackFilter(myCallbackFilter);

        Service service = (Service) enhancer.create();


        service.method1();
        service.method2();
        service.returnThis();

    }

}
