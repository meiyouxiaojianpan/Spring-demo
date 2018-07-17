package com.gaozhiwen.beans.factory.support;

import com.gaozhiwen.beans.BeanDefinition;

/**
 * @author : gaozhiwen
 * @date : 2018/6/25
 */
public interface BeanDefinitionRegistry {
    /**
     * 获取 bean 定义
     * @param beanID
     * @return
     */
    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
