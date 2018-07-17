package com.gaozhiwen.core.io;

import com.gaozhiwen.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : gaozhiwen
 * @date : 2018/7/3
 */
public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    public InputStream getInputStream() throws IOException {
        InputStream is = this.classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(path + "cannot be open");
        }
        return is;
    }

    public String getDescription() {
        return this.path;
    }
}
