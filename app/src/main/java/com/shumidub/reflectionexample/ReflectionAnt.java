package com.shumidub.reflectionexample;

import android.support.annotation.Nullable;

import java.lang.reflect.Field;

public class ReflectionAnt {
    @Nullable
    static Object getPrivateField(Object instanceClass ,String declaredFieldName ){
        try {
            Field field = instanceClass.getClass().getDeclaredField(declaredFieldName);
            field.setAccessible(true);
            return field.get(instanceClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    static void setNewValueForImmutableField(Object instanceClass , String declaredFieldName, Object newValue ){
        try {
            Field field = instanceClass.getClass().getDeclaredField(declaredFieldName);
            field.setAccessible(true);
            field.set(instanceClass, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
