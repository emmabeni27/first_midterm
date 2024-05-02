package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleTest {
    @Test
    public void isStrictly(){
        Double check = new Double(.5,.9999999);
        assertTrue(check.isStrictly());
    }
    @Test
    public void isNotStrictly(){
        Double check = new Double(1234567890,.9999999);
        assertFalse(check.isStrictly());
    }
}
