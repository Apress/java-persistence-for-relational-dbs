package com.apress.javapersistence.chapter07;

public class IntegerSum {
    public int sum(int[] integers) {
        int result = 0;
        
        for(int i = 0; i < integers.length; i++) {
            result += integers[i];
        }
        
        return result;
    }
}