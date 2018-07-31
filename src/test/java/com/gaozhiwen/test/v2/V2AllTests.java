package com.gaozhiwen.test.v2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author : gaozhiwen
 * @date : 2018/7/31
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTestV2.class,
        BeanDefinitionTestV2.class,
        BeanDefinitionValueResolverTest.class,
        CustomBooleanEditorTest.class,
        CustomNumberEditorTest.class,
        TypeConverterTest.class
})
public class V2AllTests {
}
