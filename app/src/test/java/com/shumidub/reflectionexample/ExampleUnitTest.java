package com.shumidub.reflectionexample;

import org.junit.Test;

import java.util.Arrays;

import static com.shumidub.reflectionexample.ReflectionHelper.getConstructors;
import static com.shumidub.reflectionexample.ReflectionHelper.getPrivateField;
import static com.shumidub.reflectionexample.ReflectionHelper.getPrivateMethodReturnType;
import static com.shumidub.reflectionexample.ReflectionHelper.invokePrivateMethod;
import static com.shumidub.reflectionexample.ReflectionHelper.setNewValueForImmutableField;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Container container = new Container();

    @Test
    public void getPrivateFieldMethod_workCorrect() {
        assertEquals("privateString",
                getPrivateField(container, "privateString"));
    }

    @Test
    public void setNewValueForImmutableField_workCorrect() {
        boolean oldValue = container.booleanValue;
        boolean newValue = !container.booleanValue;
        setNewValueForImmutableField(container, "booleanValue", newValue);
        assertNotEquals(oldValue, container.booleanValue);
        assertEquals(newValue, container.booleanValue);
    }

    @Test
    public void invokePrivateMethod_workCorrect() {
        //void method return null
        assertNull(invokePrivateMethod(container, "firstPrivateMethod", null));

        //"Result from second private method" expected as result from container.secondPrivateMethod();
        assertEquals("Result from second private method",
                invokePrivateMethod(container, "secondPrivateMethod", null));
    }


    @Test
    public void getPrivateMethodReturnType_workCorrect() {
        //void method return null
        assertEquals("void", getPrivateMethodReturnType(container,
                "firstPrivateMethod").toString());

        //String.class is expected return type from container.secondPrivateMethod();
        assertEquals(String.class,
                getPrivateMethodReturnType(container, "secondPrivateMethod"));
    }


    @Test
    public void getConstructors_workCorrect() {
        System.out.println(Arrays.toString(getConstructors(Container.class).toArray()));
        assertEquals(3, getConstructors(Container.class).size());
    }
}