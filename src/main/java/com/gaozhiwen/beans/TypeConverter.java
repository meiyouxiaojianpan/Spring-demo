package com.gaozhiwen.beans;
/**
*@author : gaozhiwen
*@date : 2018/7/31
*/
public interface TypeConverter {
    <T> T convertIfNecessary(Object value, Class<T> requireType) throws TypeMismatchException   ;
}
