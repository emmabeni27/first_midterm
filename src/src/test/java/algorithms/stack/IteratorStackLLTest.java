package algorithms.stack;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class IteratorStackLLTest {
    @Test
    public void hasNext() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertFalse(stack.iterator().hasNext());
        stack.push("object1");
        stack.push("object2");
        stack.push("object3");
        assertTrue(stack.iterator().hasNext());

        Iterator iter = stack.iterator();
        while (iter.hasNext()) {
            iter.next();
        }

        assertFalse(iter.hasNext());

    }

    @Test
    public void next() {
        LinkedListStack<String> stack = new LinkedListStack<>();

        assertThrows(NoSuchElementException.class, () -> {
            stack.iterator().next();
        });
        stack.push("object1");
        stack.push("object2");
        stack.push("object3");

        Iterator iter = stack.iterator();
        assertThat(iter.next()).isEqualTo("object3");
        assertThat(iter.next()).isEqualTo("object2");
        assertThat(iter.next()).isEqualTo("object1"); // si no almaceno no guarda el avance!!
        assertThrows(NoSuchElementException.class, () -> {
            iter.next();
        });// chequear que el next del iter (con posición almacenada, tire excepción

    }
}
