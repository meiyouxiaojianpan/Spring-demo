package com.gaozhiwen.context.support;

import com.gaozhiwen.beans.factory.support.DefaultBeanFactory;
import com.gaozhiwen.beans.factory.xml.XmlBeanDefinitionReader;
import com.gaozhiwen.context.ApplicationContext;
import com.gaozhiwen.core.io.Resource;
import com.gaozhiwen.util.ClassUtils;

/**
*@author : gaozhiwen
*@date : 2018/7/6
*/
public abstract class AbstractApplicationContext implements ApplicationContext{
    private DefaultBeanFactory factory;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinition(resource);
        factory.setBeanClassLoader(this.getBeanClassLoader());
    }

    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }

    protected abstract Resource getResourceByPath(String path);

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
