package com.gaozhiwen.beans.factory.config;

/**
 * @author : gaozhiwen
 * @date : 2018/7/17
 */
public class RuntimeBeanReference {
    private final String name;

    public RuntimeBeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
