package com.gaozhiwen.util;
/**
*@author : gaozhiwen
*@date : 2018/7/3
*/
public abstract class Assert {
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
