package com.gaozhiwen.beans.propertyeditors;

import com.gaozhiwen.util.NumberUtils;
import com.gaozhiwen.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.NumberFormat;

/**
*@author : gaozhiwen
*@date : 2018/7/30
*/
public class CustomNumberEditor extends PropertyEditorSupport{
    private final Class<? extends Number> numberClass;
    private final NumberFormat numberFormat;
    private final boolean allowEmpty;

    public CustomNumberEditor(Class<? extends Number> numberClass, NumberFormat numberFormat, boolean allowEmpty) {
        if (numberClass == null || !Number.class.isAssignableFrom(numberClass)) {
            throw new IllegalArgumentException("Property class must be a subclass of Number");
        }
        this.numberClass = numberClass;
        this.numberFormat = numberFormat;
        this.allowEmpty = allowEmpty;
    }


    public CustomNumberEditor(Class<Integer> numberClass, boolean allowEmpty) {
        this(numberClass, null, allowEmpty);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && !StringUtils.hasText(text)) {
            setValue(null);
        } else if (this.numberFormat != null) {
            setValue(NumberUtils.parseNumber(text, this.numberClass, this.numberFormat));
        } else {
            setValue(NumberUtils.parseNumber(text, this.numberClass));
        }
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Number) {
            super.setValue(NumberUtils.convertNumberToTargetClass((Number) value, this.numberClass));
        } else {
            super.setValue(value);
        }
    }
}
