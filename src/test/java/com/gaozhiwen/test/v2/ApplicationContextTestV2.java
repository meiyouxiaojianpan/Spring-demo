package com.gaozhiwen.test.v2;

import com.gaozhiwen.context.ApplicationContext;
import com.gaozhiwen.context.support.ClassPathXmlApplicationContext;
import com.gaozhiwen.dao.v2.AccountDao;
import com.gaozhiwen.dao.v2.ItemDao;
import com.gaozhiwen.service.v2.PetStoreService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
*@author : gaozhiwen
*@date : 2018/7/17
*/
public class ApplicationContextTestV2 {
    @Test
    public void testGetBeanProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v2.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");

        assertNotNull(petStore.getAccountDao());
        assertNotNull(petStore.getItemDao());

        assertTrue(petStore.getAccountDao() instanceof AccountDao);
        assertTrue(petStore.getItemDao() instanceof ItemDao);

        assertEquals("gaozhiwen", petStore.getOwner());
        assertEquals(2, petStore.getVersion());
    }
}
