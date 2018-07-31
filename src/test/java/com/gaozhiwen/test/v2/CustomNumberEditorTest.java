package com.gaozhiwen.test.v2;

import com.gaozhiwen.beans.propertyeditors.CustomNumberEditor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
*@author : gaozhiwen
*@date : 2018/7/30
*/
public class CustomNumberEditorTest {

    @Test
    public void testConvertString() {
        CustomNumberEditor editor = new CustomNumberEditor(Integer.class, true);
        editor.setAsText("3");
        Object value = editor.getValue();
        assertTrue(value instanceof Integer);
        assertEquals(3, ((Integer)editor.getValue()).intValue());

        editor.setAsText("");
        assertTrue(editor.getValue() == null);

        try {
            editor.setAsText("3.1");
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }
}
