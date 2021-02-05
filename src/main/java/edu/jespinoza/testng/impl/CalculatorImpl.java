package edu.jespinoza.testng.impl;

import edu.jespinoza.testng.Calculator;

public class CalculatorImpl implements Calculator {
    private static CalculatorImpl ourInstance;

    public static CalculatorImpl getInstance() {
        if(ourInstance == null) {
            ourInstance = new CalculatorImpl();
        }
        return ourInstance;
    }

    private CalculatorImpl() {
    }

    public double add(double a, double b){
        return a+b;
    }

    public double subtract(double a, double b){
        return a-b;
    }

    public double multiply(double a, double b){
        return a*b;
    }

}
