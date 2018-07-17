package com.gaozhiwen.beans;
/**
*@author : gaozhiwen
*@date : 2018/6/9
*/
public interface BeanDefinition {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    String SCOPE_DEFAULT = "";

    /**
     * is singleton
     * @return
     */
    boolean isSingleton();

    /**
     * is prototype
     * @return
     */
    boolean isPrototype();

    /**
     * 获取 scope
     * @return
     */
    String getScope();

    /**
     * 设置 scope
     * @param scope
     */
    void setScope(String scope);

    /**
     * 获取 bean name
     * @return
     */
    String getBeanClassName();
}
