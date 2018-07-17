package com.gaozhiwen.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
*@author : gaozhiwen
*@date : 2018/7/3
*/
public interface Resource {
    InputStream getInputStream() throws IOException;

    String getDescription();
}
