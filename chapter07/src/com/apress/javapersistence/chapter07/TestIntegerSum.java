package com.apress.javapersistence.chapter07;

import junit.framework.TestCase;

public class TestIntegerSum extends TestCase {
    public void testSum() {
        int integer0 = 10;
        int integer1 = 12;
        int integer2 = 14;
        int expected = integer0 + integer1 + integer2;
        
        int[] integers = new int[3];
        integers[0] = integer0;
        integers[1] = integer1;
        integers[2] = integer2;
        
        IntegerSum calculator = new IntegerSum();
        
        int result = calculator.sum(integers);
        
        assertEquals(expected, result);
    }
}