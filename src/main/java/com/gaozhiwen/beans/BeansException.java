package com.gaozhiwen.beans;

/**
 * @author : gaozhiwen
 * @date : 2018/6/9
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
