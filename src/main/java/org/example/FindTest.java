package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindTest {
    @Test
    public void areEqual(){
    Find find= new Find(1,2,3);
    assertEquals(find.equals(), "They are not equal :(");
    }
    @Test
    public void areNotEqual(){
        Find find = new Find(2,2,2);
        assertEquals(find.equals(), "They are equal :)"); // el .equals() retorna un string
    }
}
