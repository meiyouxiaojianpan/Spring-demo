package com.gaozhiwen.test.v1;

import com.gaozhiwen.beans.BeanDefinition;
import com.gaozhiwen.beans.factory.BeanCreationException;
import com.gaozhiwen.beans.factory.BeanDefinitionStoreException;
import com.gaozhiwen.beans.factory.support.DefaultBeanFactoryDefault;
import com.gaozhiwen.beans.factory.xml.XmlBeanDefinitionReader;
import com.gaozhiwen.core.io.ClassPathResource;
import com.gaozhiwen.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
*@author : gaozhiwen
*@date : 2018/6/9
*/
public class BeanFactoryTest {

    DefaultBeanFactoryDefault factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactoryDefault();
        reader = new XmlBeanDefinitionReader(factory);
    }
    @Test
    public void testGetBean() {
        reader.loadBeanDefinition(new ClassPathResource("petstore-v1.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertTrue(bd.isSingleton());
        assertFalse(bd.isPrototype());
        assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());

        assertEquals("com.gaozhiwen.service.v1.PetStoreService",bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService)factory.getBean("petStore");
        assertNotNull(petStore);

        PetStoreService petStore1 = (PetStoreService) factory.getBean("petStore");
        assertTrue(petStore.equals(petStore1));
    }

    @Test
    public void testInvalidBean() {
        reader.loadBeanDefinition(new ClassPathResource("petstore-v1.xml"));
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }
        Assert.fail("expect beanCreationException");
    }

    @Test
    public void testInvalidXML() {
        try {
            reader.loadBeanDefinition(new ClassPathResource("xxx.xml"));
        } catch (BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("expect beanDefinitionStoreException");
    }
}
