package com.gaozhiwen.beans.factory.config;

import com.gaozhiwen.beans.factory.BeanFactory;

/**
*@author : gaozhiwen
*@date : 2018/7/6
*/
public interface ConfigurableBeanFactory extends BeanFactory{
    void setBeanClassLoader(ClassLoader beanClassLoader);

    ClassLoader getBeanClassLoader();
}
