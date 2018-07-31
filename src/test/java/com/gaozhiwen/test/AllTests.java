package com.gaozhiwen.test;

import com.gaozhiwen.test.v1.V1AllTests;
import com.gaozhiwen.test.v2.V2AllTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author : gaozhiwen
 * @date : 2018/7/31
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        V1AllTests.class,
        V2AllTests.class
})
public class AllTests {
}
