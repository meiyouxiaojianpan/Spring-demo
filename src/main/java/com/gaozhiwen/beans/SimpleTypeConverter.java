package com.gaozhiwen.beans;

import com.gaozhiwen.beans.propertyeditors.CustomBooleanEditor;
import com.gaozhiwen.beans.propertyeditors.CustomNumberEditor;
import com.gaozhiwen.util.ClassUtils;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
*@author : gaozhiwen
*@date : 2018/7/31
*/
public class SimpleTypeConverter implements TypeConverter {
    private Map<Class<?>, PropertyEditor> defaultEditor;

    public SimpleTypeConverter() {
    }

    public <T> T convertIfNecessary(Object value, Class<T> requireType) throws TypeMismatchException {
        if (ClassUtils.isAssignableValue(requireType, value)) {
            return (T) value;
        } else {
            if (value instanceof String) {
                PropertyEditor editor = findDefaultEditor(requireType);
                try {
                    editor.setAsText((String) value);
                } catch (IllegalArgumentException e) {
                    throw new TypeMismatchException(value, requireType);
                }
                return (T) editor.getValue();
            } else {
                throw new RuntimeException("Todo: can't convert value: " + value + " to Type: " + requireType);
            }
        }
    }

    private PropertyEditor findDefaultEditor(Class<?> requireType) {
        PropertyEditor editor = this.getDefaultEditor(requireType);
        if (editor == null) {
            throw new RuntimeException("Editor for " + requireType + " has not been implemented");
        }
        return editor;
    }

    public PropertyEditor getDefaultEditor(Class<?> requireType) {
        if (this.defaultEditor == null) {
            createDefaultEditor();
        }
        return this.defaultEditor.get(requireType);
    }

    private void createDefaultEditor() {
        this.defaultEditor = new HashMap<Class<?>, PropertyEditor>(64);

        this.defaultEditor.put(boolean.class, new CustomBooleanEditor(false));
        this.defaultEditor.put(Boolean.class, new CustomBooleanEditor(true));

        this.defaultEditor.put(int.class, new CustomNumberEditor(Integer.class, false));
        this.defaultEditor.put(Integer.class, new CustomNumberEditor(Integer.class, true));
    }
}
