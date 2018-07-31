package com.gaozhiwen.test.v2;

import com.gaozhiwen.beans.BeanDefinition;
import com.gaozhiwen.beans.PropertyValue;
import com.gaozhiwen.beans.factory.config.RuntimeBeanReference;
import com.gaozhiwen.beans.factory.support.DefaultBeanFactory;
import com.gaozhiwen.beans.factory.xml.XmlBeanDefinitionReader;
import com.gaozhiwen.core.io.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author : gaozhiwen
 * @date : 2018/7/17
 */
public class BeanDefinitionTestV2 {
    @Test
        public void testGetBeanDefinition() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        List<PropertyValue> pvs = bd.getPropertyValues();
        Assert.assertTrue(pvs.size() == 4);

        PropertyValue pv = this.getPropertyValue("accountDao", pvs);
        Assert.assertNotNull(pv);
        Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);

        pv = this.getPropertyValue("itemDao", pvs);
        Assert.assertNotNull(pv);
        Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
    }

    private PropertyValue getPropertyValue(String name, List<PropertyValue> pvs) {
        for (PropertyValue pv : pvs) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }
}
