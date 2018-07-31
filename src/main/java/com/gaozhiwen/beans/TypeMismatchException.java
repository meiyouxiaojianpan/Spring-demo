package com.gaozhiwen.beans;

/**
 * @author : gaozhiwen
 * @date : 2018/7/31
 */
public class TypeMismatchException extends Exception {
    private transient Object value;
    private Class<?> requireType;

    public TypeMismatchException(Object value, Class<?> requireType) {
        super("Failed to convert value: " + value + " to type: " + requireType);
        this.value = value;
        this.requireType = requireType;
    }

    public Object getValue() {
        return value;
    }

    public Class<?> getRequireType() {
        return requireType;
    }
}
