package algorithms.queue;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class ReversedTestQueue {
    private static final int DEFAULT_SIZE = 20;

    @Test
    public void hasNext() {
        ArrayQueue<String> stack = new ArrayQueue<>(DEFAULT_SIZE);
        stack.enqueue("object1");
        stack.enqueue("object2");
        stack.enqueue("object3");
        //size 3
        assertTrue(stack.iterator().hasNext());
        Iterator iter = ((ArrayQueue<String>) stack).reversed();

        while (iter.hasNext()) {
            iter.next();
        }

        assertFalse(iter.hasNext());
    }

    @Test
    public void next() {
        ArrayQueue<String> parametrizedQueue = new ArrayQueue<>(DEFAULT_SIZE); //AGREGAR <STRING>!!!!!
        //pq está vacío

        assertThrows(NoSuchElementException.class, () -> {
            parametrizedQueue.reversed().next();
        });

        parametrizedQueue.enqueue("object1");
        parametrizedQueue.enqueue("object2");
        parametrizedQueue.enqueue("object3");

        Iterator iter = ((ArrayQueue<?>) parametrizedQueue).reversed();
        assertThat(iter.next()).isEqualTo("object3");
        assertThat(iter.next()).isEqualTo("object2");
        assertThat(iter.next()).isEqualTo("object1");
        assertThrows(NoSuchElementException.class, () -> {
            iter.next();
        });
    }


}
