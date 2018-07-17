package com.gaozhiwen.test.v1;

import com.gaozhiwen.context.ApplicationContext;
import com.gaozhiwen.context.support.ClassPathXmlApplicationContext;
import com.gaozhiwen.context.support.FileSystemApplicationContext;
import com.gaozhiwen.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : gaozhiwen
 * @date : 2018/6/28
 */
public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }

    @Test
    public void testGetBeanFromFileSystemContext() {
        ApplicationContext ctx = new FileSystemApplicationContext("C:\\000\\myspring\\src\\test\\resources\\petstore-v1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }
}
