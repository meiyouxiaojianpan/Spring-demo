package com.gaozhiwen.test.v2;

import com.gaozhiwen.beans.SimpleTypeConverter;
import com.gaozhiwen.beans.TypeConverter;
import com.gaozhiwen.beans.TypeMismatchException;
import org.junit.Assert;
import org.junit.Test;

/**
*@author : gaozhiwen
*@date : 2018/7/31
*/
public class TypeConverterTest {
    @Test
    public void testConvertStringToInt() throws TypeMismatchException {
        TypeConverter converter = new SimpleTypeConverter();
        Integer i = converter.convertIfNecessary("3", Integer.class);
        Assert.assertEquals(3, i.intValue());

        try {
            converter.convertIfNecessary("3.1", Integer.class);
        } catch (TypeMismatchException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void testConvertStringToBoolean() throws TypeMismatchException {
        TypeConverter converter = new SimpleTypeConverter();
        Boolean b = converter.convertIfNecessary("true", Boolean.class);
        Assert.assertEquals(true, b.booleanValue());

        try {
            converter.convertIfNecessary("abc", Boolean.class);
        } catch (TypeMismatchException e) {
            return;
        }
        Assert.fail();
    }
}
