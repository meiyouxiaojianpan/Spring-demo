package com.gaozhiwen.test.v2;

import com.gaozhiwen.beans.factory.config.RuntimeBeanReference;
import com.gaozhiwen.beans.factory.config.TypedStringValue;
import com.gaozhiwen.beans.factory.support.BeanDefinitionValueResolver;
import com.gaozhiwen.beans.factory.support.DefaultBeanFactory;
import com.gaozhiwen.beans.factory.xml.XmlBeanDefinitionReader;
import com.gaozhiwen.core.io.ClassPathResource;
import com.gaozhiwen.dao.v2.AccountDao;
import org.junit.Assert;
import org.junit.Test;

/**
*@author : gaozhiwen
*@date : 2018/7/19
*/
public class BeanDefinitionValueResolverTest {
    @Test
    public void testResolverRunTimeBeanReference() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));

        BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);

        RuntimeBeanReference reference = new RuntimeBeanReference("accountDao");
        Object value = resolver.resolverValueIfNecessary(reference);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof AccountDao);
    }

    @Test
    public void testResolverTypedStringValue() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));

        BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);

        TypedStringValue stringValue = new TypedStringValue("test");
        Object value = resolver.resolverValueIfNecessary(stringValue);

        Assert.assertNotNull(value);
        Assert.assertEquals("test", value);
    }
}
