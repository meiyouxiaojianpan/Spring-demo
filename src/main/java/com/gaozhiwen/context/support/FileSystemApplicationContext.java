package com.gaozhiwen.context.support;

import com.gaozhiwen.core.io.FileSystemResource;
import com.gaozhiwen.core.io.Resource;

/**
*@author : gaozhiwen
*@date : 2018/7/6
*/
public class FileSystemApplicationContext extends AbstractApplicationContext{

    public FileSystemApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
