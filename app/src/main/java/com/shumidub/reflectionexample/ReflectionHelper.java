package com.shumidub.reflectionexample;

import android.support.annotation.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectionHelper {

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

    static void setNewValueForImmutableField(Object instanceClass, String declaredFieldName, Object newValue ){
        try {
            Field field = instanceClass.getClass().getDeclaredField(declaredFieldName);
            field.setAccessible(true);
            field.set(instanceClass, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public static Object invokePrivateMethod(Object instanceClass, String declaredMethodName, Object ...args){
        try {
            Method method = instanceClass.getClass().getDeclaredMethod(declaredMethodName);
            method.setAccessible(true);
            if (args==null || args.length==0)return method.invoke(instanceClass);
            else return method.invoke(instanceClass, args);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }return null;
    }


    @Nullable
    public static Class getPrivateMethodReturnType(Object instanceClass, String declaredMethodName){
        try {
            Method method = instanceClass.getClass().getDeclaredMethod(declaredMethodName);
            method.setAccessible(true);
            return method.getReturnType();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }return null;
    }


    public static ArrayList<String> getConstructors(Class clazz){
        ArrayList<String> constructorsWithArgs = new ArrayList<>();
        String constructorWithArgs;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            constructorWithArgs = constructor.toString();
            constructorsWithArgs.add(constructorWithArgs);
        }
        return constructorsWithArgs;
    }


    //todo create new class runtime
}
