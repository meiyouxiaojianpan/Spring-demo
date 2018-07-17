package com.gaozhiwen.core.io;

import com.gaozhiwen.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : gaozhiwen
 * @date : 2018/7/3
 */
public class FileSystemResource implements Resource {
    private String path;
    private File file;

    public FileSystemResource(String path) {
        Assert.NotNull(path, "path not be null!");
        this.path = path;
        this.file = new File(path);
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getDescription() {
        return "file [" + this.file.getAbsolutePath() + "]";
    }
}
