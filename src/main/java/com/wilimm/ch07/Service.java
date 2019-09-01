package com.wilimm.ch07;

import lombok.Data;

@Data
public class Service {

    public String tag = "default";

    public void method1() {
        System.out.println(this.tag + "-------------------------Service.method1 执行了");
    }

    public void method2() {
        System.out.println(this.tag + "-------------------------Service.method2 执行了");
    }

    public Service returnThis() {
        System.out.println(this.tag + "-------------------------Service.returnThis 执行了");
        return this;
    }
}