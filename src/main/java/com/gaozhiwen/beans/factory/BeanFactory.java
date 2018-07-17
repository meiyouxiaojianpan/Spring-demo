package com.gaozhiwen.beans.factory;


/**
*@author : gaozhiwen
*@date : 2018/6/9
*/
public interface BeanFactory {
    /**
     * 获取一个实例
     * @param beanId
     * @return
     */
    Object getBean(String beanId);
}
