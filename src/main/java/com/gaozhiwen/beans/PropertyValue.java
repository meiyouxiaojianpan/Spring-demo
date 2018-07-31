package com.gaozhiwen.beans;

/**
 * @author : gaozhiwen
 * @date : 2018/7/17
 */
public class PropertyValue {
    private final String name;
    private final Object value;
    private Boolean converted = false;
    private Object convertedValue;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public synchronized Boolean isConverted() {
        return converted;
    }

    public synchronized void setConvertedValue(Object convertedValue) {
        this.converted = true;
        this.convertedValue = convertedValue;
    }

    public synchronized Object getConvertedValue() {
        return convertedValue;
    }
}
