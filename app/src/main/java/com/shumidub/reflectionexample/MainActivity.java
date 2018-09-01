package com.shumidub.reflectionexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Container container = new Container("finalString");
        String privateString = "";
        String oldFinalString = "";

        try {
            Field field = container.getClass().getDeclaredField("privateString");
            field.setAccessible(true);
            privateString = (String) field.get(container);

            field = container.getClass().getDeclaredField("finalString");
            oldFinalString = (String) field.get(container);
            Field modifiersField = Field.class.getDeclaredField("modifiers");

            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            String newValue = "NewValue";
            field.set(null, newValue);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Log.d("DTAG", "onCreate: " + privateString + " " + oldFinalString + " " + container.finalString);//output 0default
    }
}
