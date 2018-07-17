package com.gaozhiwen.context.support;

import com.gaozhiwen.core.io.ClassPathResource;
import com.gaozhiwen.core.io.Resource;

/**
 * @author : gaozhiwen
 * @date : 2018/6/28
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path, this.getBeanClassLoader());
    }
}
