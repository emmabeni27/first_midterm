package algorithms.queue;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class IteratorTestsQueue {
    private static final int DEFAULT_SIZE =20;
    @Test
    public void hasNext(){ //se fija si hay un elemento siguiente (si el espacio que sigue está OCUPADO
        ArrayQueue ParametrizedQueue= new ArrayQueue<>(DEFAULT_SIZE);
        //caso pila vacía
        assertFalse(ParametrizedQueue.iterator().hasNext()); //hasNext no es un método de
        // Stack, por eso no lo puedo aplicar directo.
        // Para aplicarlos primero tengo que instanciar el iteradr del stack
        ParametrizedQueue.enqueue("object1");
        ParametrizedQueue.enqueue("object2");
        ParametrizedQueue.enqueue("object3");
        // caso pila llena, parada fuera, para arrancar a recorrer
        assertTrue(ParametrizedQueue.iterator().hasNext()); //primero instancia de arraystackiterator

        Iterator iter = ParametrizedQueue.iterator(); //iter es instancia de iterador de mi arraystack, la instancia es la flechit que apunta
        //guardo iterador porque quiero que dure para recorrer, no sólo usarlo en una línea
        while (iter.hasNext()){
            iter.next();
        }
        //caso pila llena, parada en 3 (último)
        assertFalse(iter.hasNext()); //iter pq parado al final
    }
    @Test
    public void next(){
        ArrayQueue notParametrizedStack = new ArrayQueue<>();
        ArrayQueue ParametrizedQueue= new ArrayQueue<>(DEFAULT_SIZE);

        //caso pila vacía
        assertThrows(NoSuchElementException.class,()->{ParametrizedQueue.iterator().next();});
        ParametrizedQueue.enqueue("object1");
        ParametrizedQueue.enqueue("object2");
        ParametrizedQueue.enqueue("object3");
        // caso pila llena, parada fuera, para arrancar a recorrer
        Iterator iter= ParametrizedQueue.iterator();
        assertThat(iter.next()).isEqualTo("object1");
        assertThat(iter.next()).isEqualTo("object2");
        assertThat(iter.next()).isEqualTo("object3");
        assertThrows(NoSuchElementException.class,()->{iter.next();});



    }


}