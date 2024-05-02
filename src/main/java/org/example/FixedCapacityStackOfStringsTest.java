package org.example;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class FixedCapacityStackOfStringsTest {
    @Test
    public void isFull(){
        FixedCapacityStackOfStrings myStack = new FixedCapacityStackOfStrings(2);
        myStack.push("Hola");
        myStack.push("Mundo");
        assertTrue(myStack.isFull());
    }
}
