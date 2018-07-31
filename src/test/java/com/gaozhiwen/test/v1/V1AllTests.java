package com.gaozhiwen.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author : gaozhiwen
 * @date : 2018/7/31
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class
})
public class V1AllTests {
}
