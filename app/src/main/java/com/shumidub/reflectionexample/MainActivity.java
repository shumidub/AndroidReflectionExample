package com.shumidub.reflectionexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import static com.shumidub.reflectionexample.ReflectionHelper.getPrivateField;
import static com.shumidub.reflectionexample.ReflectionHelper.setNewValueForImmutableField;

@EActivity
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.text_view)
    TextView textView;

    Container container = new Container(false);
    String privateString;
    String firstPrivateMethodReturnType;
    String secondPrivateMethodReturnType;
    Boolean realBooleanValue;
    Boolean modifiedBooleanValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = new Container(false);

        privateString = (String) getPrivateField(container, "privateString");
        realBooleanValue = container.booleanValue;

        setNewValueForImmutableField(container, "booleanValue", true);
        modifiedBooleanValue = container.booleanValue;

//        firstPrivateMethodReturnType = getPrivateMethodReturnType(container, "firstPrivateMethod");
//        secondPrivateMethodReturnType = getPrivateMethodReturnType(container, "secondPrivateMethod");

        textView.setText(String.format(getString(R.string.result_text),
                privateString, realBooleanValue.toString(), modifiedBooleanValue.toString(),
                firstPrivateMethodReturnType, secondPrivateMethodReturnType));
    }
}
