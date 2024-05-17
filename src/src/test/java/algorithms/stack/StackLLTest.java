package algorithms.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class StackLLTest {
    @Test
    public void push(){
        LinkedListStack<String> stack= new LinkedListStack<>();
        stack.push("hola!");
        stack.push("adiós!");
        assertThat(stack.size()).isEqualTo(2);
    }
    @Test
    public void pop() {
        LinkedListStack<String> stack= new LinkedListStack<>();
        stack.push("Lo que el viento se llevó");
        stack.push("Margaret Mitchell");
        stack.pop();
        assertThat(stack.pop()).isEqualTo("Lo que el viento se llevó");
        assertTrue(stack.isEmpty());
    }
    @Test
    public void underflow() {
        LinkedListStack<String> stack= new LinkedListStack<>();
        assertThrows(NoSuchElementException.class, stack::pop);
    }
    @Test
    public void trueEmpty(){
        LinkedListStack<String> stack= new LinkedListStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void falseEmpty(){
        LinkedListStack<String> stack= new LinkedListStack<>();
        stack.push("Gracias por la música");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void size(){
        LinkedListStack<String> stack= new LinkedListStack<>();
        stack.push("Gracias por la música");
        stack.push("Thank you for the music");
        assertThat(stack.size()).isEqualTo(2);
    }
}


