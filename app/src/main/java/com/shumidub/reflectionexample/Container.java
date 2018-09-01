package com.shumidub.reflectionexample;

public class Container {
    private String privateString = "privateString";
    final String finalString;

    public Container(String finalString) {
        this.finalString = finalString;
    }
}
