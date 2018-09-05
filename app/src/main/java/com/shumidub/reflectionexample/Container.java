package com.shumidub.reflectionexample;

public class Container {
    private String privateString = "privateString";
    final boolean booleanValue;

    Container() { this.booleanValue = false; }

    Container(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    Container(boolean booleanValue, int t) {
        this.booleanValue = booleanValue;
    }

    private void firstPrivateMethod(){}

    private String secondPrivateMethod(){ return "Result from second private method";}

    private String thirdPrivateMethod(String argument){ return "The argument is - " + argument;}


}
