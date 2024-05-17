package algorithms.stack;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class IteratorTests {
    private static final int DEFAULT_SIZE =20;

    @Test
    public void iteratorTest() {
        final Stack<Integer> stack = new ArrayStack<>(DEFAULT_SIZE);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        Iterator<Integer> iterator = stack.iterator();
        for (int i = 9; i >= 0; i--) {
            assertTrue(iterator.hasNext());
            assertEquals(i, (int) iterator.next());
        }
        assertFalse(iterator.hasNext());
    }
    @Test
    public void hasNext(){ //se fija si hay un elemento siguiente (si el espacio que sigue está OCUPADO
        Stack<String> stack= new ArrayStack<>(DEFAULT_SIZE);
        //caso pila vacía
        assertFalse(stack.iterator().hasNext()); //hasNext no es un método de
        // Stack, por eso no lo puedo aplicar directo.
        // Para aplicarlos primero tengo que instanciar el iteradr del stack
        stack.push("object1");
        stack.push("object2");
        stack.push("object3");
        // caso pila llena, parada fuera, para arrancar a recorrer
        assertTrue(stack.iterator().hasNext()); //primero instancia de arraystackiterator

        Iterator iter = stack.iterator(); //iter es instancia de iterador de mi arraystack, la instancia es la flechit que apunta
        //guardo iterador porque quiero que dure para recorrer, no sólo usarlo en una línea
        while (iter.hasNext()){
            iter.next();
        }
        //caso pila llena, parada en 3 (último)
        assertFalse(iter.hasNext()); //iter pq parado al fin_al
    }
    @Test
    public void next(){
        Stack parametrizedStack= new ArrayStack<>(DEFAULT_SIZE);

        //caso pila vacia
        assertThrows(NoSuchElementException.class,()->{parametrizedStack.iterator().next();});
        parametrizedStack.push("object1");
        parametrizedStack.push("object2");
        parametrizedStack.push("object3");
        // caso pila llena, parada fuera, para arrancar a recorrer
        Iterator iter= parametrizedStack.iterator();
        assertThat(iter.next()).isEqualTo("object3");
        assertThat(iter.next()).isEqualTo("object2");
        assertThat(iter.next()).isEqualTo("object1"); // si no almaceno no guarda el avance!!
        assertThrows(NoSuchElementException.class,()->{iter.next();});// chequear que el next del iter (con posición almacenada, tire excepción



    }


}
