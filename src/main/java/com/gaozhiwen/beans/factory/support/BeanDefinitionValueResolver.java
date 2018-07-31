package com.gaozhiwen.beans.factory.support;

import com.gaozhiwen.beans.factory.config.RuntimeBeanReference;
import com.gaozhiwen.beans.factory.config.TypedStringValue;

/**
 * @author : gaozhiwen
 * @date : 2018/7/19
 */
public class BeanDefinitionValueResolver {
    private final DefaultBeanFactory factory;

    public BeanDefinitionValueResolver(DefaultBeanFactory factory) {
        this.factory = factory;
    }


    public Object resolverValueIfNecessary(Object value) {
        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference reference = (RuntimeBeanReference) value;
            String refName = reference.getName();
            Object bean = this.factory.getBean(refName);
            return bean;
        } else if (value instanceof TypedStringValue) {
            return ((TypedStringValue) value).getValue();
        } else {
            throw new RuntimeException("the value " + value + " has not implemented");
        }
    }
}
