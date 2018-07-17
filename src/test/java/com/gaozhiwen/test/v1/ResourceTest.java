package com.gaozhiwen.test.v1;

import com.gaozhiwen.core.io.ClassPathResource;
import com.gaozhiwen.core.io.FileSystemResource;
import com.gaozhiwen.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
*@author : gaozhiwen
*@date : 2018/7/3
*/
public class ResourceTest {

    @Test
    public void testClassPathResource() throws Exception {
        Resource r = new ClassPathResource("petstore-v1.xml");
        InputStream is = null;
        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        }finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws Exception {
        Resource r = new FileSystemResource("C:\\000\\myspring\\src\\test\\resources\\petstore-v1.xml");
        InputStream is = null;
        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        }finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
