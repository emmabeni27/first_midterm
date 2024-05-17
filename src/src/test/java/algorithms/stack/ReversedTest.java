package algorithms.stack;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class ReversedTest {
    private static final int DEFAULT_SIZE = 20;

    @Test
    public void hasNext() {
        Stack<String> stack = new ArrayStack<>(DEFAULT_SIZE);
        stack.push("object1");
        stack.push("object2");
        stack.push("object3");
        assertTrue(stack.iterator().hasNext());
        Iterator iter = ((ArrayStack<String>) stack).reversed();

        while (iter.hasNext()) {
            iter.next();
        }

        assertFalse(iter.hasNext());
    }

    @Test
    public void next() {
        ArrayStack parametrizedStack = new ArrayStack<>(DEFAULT_SIZE);

        assertThrows(NoSuchElementException.class, () -> {
            ((ArrayStack<?>) parametrizedStack).reversed().next();
        });
        parametrizedStack.push("object1");
        parametrizedStack.push("object2");
        parametrizedStack.push("object3");

        Iterator iter = ((ArrayStack<?>) parametrizedStack).reversed();
        assertThat(iter.next()).isEqualTo("object1");
        assertThat(iter.next()).isEqualTo("object2");
        assertThat(iter.next()).isEqualTo("object3");
        assertThrows(NoSuchElementException.class, () -> {
            iter.next();
        });
    }
}
