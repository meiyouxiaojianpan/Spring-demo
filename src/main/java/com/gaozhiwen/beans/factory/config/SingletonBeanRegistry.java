package com.gaozhiwen.beans.factory.config;
/**
*@author : gaozhiwen
*@date : 2018/7/11
*/
public interface SingletonBeanRegistry {
    /**
     * register singleton
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取 singleton
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
