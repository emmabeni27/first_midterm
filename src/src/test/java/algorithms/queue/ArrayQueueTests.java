package algorithms.queue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

import algorithms.queue.ArrayQueue;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ArrayQueueTests {

    @Test
    public void enqueue(){
        ArrayQueue notParametrizedQueue = new ArrayQueue<>();
        ArrayQueue ParametrizedQueue =new ArrayQueue<>(20);
        ParametrizedQueue.enqueue("Never gonna give you up");
        ParametrizedQueue.enqueue("Never gonna let you down");
        ParametrizedQueue.enqueue("2");
        notParametrizedQueue.enqueue("2.32");
        assertThat(ParametrizedQueue.size()).isEqualTo(3);
        assertThat(notParametrizedQueue.size()).isEqualTo(1);
    }
    @Test
    public void longEnqueue(){ //llama al resize
        ArrayQueue <String> notParametrizedQueue = new ArrayQueue<>();
        ArrayQueue ParametrizedQueue =new ArrayQueue<String>(20);
        ParametrizedQueue.enqueue("Never gonna give you up");
        ParametrizedQueue.enqueue("Never gonna let you down");
        ParametrizedQueue.enqueue("2");
        ParametrizedQueue.enqueue("2.3");
        ParametrizedQueue.enqueue("Never gonna give you up");
        ParametrizedQueue.enqueue("Never gonna let you down");
        ParametrizedQueue.enqueue("2");
        ParametrizedQueue.enqueue("2.3");
        ParametrizedQueue.enqueue("Never gonna give you up");
        ParametrizedQueue.enqueue("Never gonna let you down");
        ParametrizedQueue.enqueue("2");
        ParametrizedQueue.enqueue("2.3");
        ParametrizedQueue.enqueue("Never gonna give you up");
        ParametrizedQueue.enqueue("Never gonna let you down");
        ParametrizedQueue.enqueue("2");
        ParametrizedQueue.enqueue("dos");
        ParametrizedQueue.enqueue("Tadeo");
        assertThat(ParametrizedQueue.size()).isEqualTo(17);
    }
    @Test
    public void dequeueUnderflow() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        assertThrows(NoSuchElementException.class, queue::dequeue); //lo mismo que la flechita
    }
    @Test
    public void verifiedDequeue(){
        ArrayQueue<String> queue = new ArrayQueue<>(3);
        queue.enqueue("Lo que el viento se llevó");
        queue.enqueue("Hola");
        assertThat(queue.dequeue()).isEqualTo("Lo que el viento se llevó");
        assertFalse(queue.isEmpty());
        assertThat(queue.dequeue()).isEqualTo("Hola");
        assertTrue(queue.isEmpty());
    } //stack o queue almacena un único tipo de datos
    @Test
    public void verifiedEnqueue(){
        ArrayQueue notParametrizedQueue = new ArrayQueue<>();
        notParametrizedQueue.enqueue("Lo que el viento se llevó");
        assertFalse(notParametrizedQueue.isEmpty());
    }
    @Test
    public void isEmptyFalse(){
        ArrayQueue notParametrizedQueue = new ArrayQueue<>();
        ArrayQueue ParametrizedQueue =new ArrayQueue<>(20);
        notParametrizedQueue.enqueue("Twelve Red Herrings");
        assertFalse(notParametrizedQueue.isEmpty());
    }
    @Test
    public void isEmptyTrue(){

        ArrayQueue notParametrizedQueue = new ArrayQueue<>();
        ArrayQueue ParametrizedQueue =new ArrayQueue<>(20);
        assertTrue(notParametrizedQueue.isEmpty());
    }

    @Test
    public void size1(){
        ArrayQueue notParametrizedQueue = new ArrayQueue<>();
        ArrayQueue ParametrizedQueue =new ArrayQueue<>(20);
        ParametrizedQueue.enqueue("hola");
        ParametrizedQueue.enqueue("mundo");
        ParametrizedQueue.enqueue("!");
        assertThat(ParametrizedQueue.size()).isEqualTo(3);
    }
    @Test
    public void size2(){
        ArrayQueue notParametrizedQueue = new ArrayQueue<>();
        ArrayQueue ParametrizedQueue =new ArrayQueue<>(20);
        ParametrizedQueue.enqueue("hola");
        ParametrizedQueue.enqueue("mundo");
        ParametrizedQueue.enqueue("!");
        ParametrizedQueue.dequeue();
        assertThat(ParametrizedQueue.size()).isEqualTo(2);
    }
    //no puedo mezclar string e integer dentro de una queue, debo especificar el tipo y respetarlo!!!!!!!
    @Test
    public void resize(){
        final int DEFAULT_SIZE = 20;
        ArrayQueue<String> queue= new ArrayQueue<>(DEFAULT_SIZE);
        for(int i=0; i<DEFAULT_SIZE; i++){
            queue.enqueue("element"+i);
        }
        assertThat(queue.size()).isEqualTo(DEFAULT_SIZE);//paréntesis en size pq es método
        assertThat(queue.getCurrentCapacity()).isEqualTo(DEFAULT_SIZE);
        queue.enqueue("element 21");
        assertThat(queue.getCurrentCapacity()).isEqualTo(DEFAULT_SIZE*2);
        int elementsToPop = queue.size()-queue.getCurrentCapacity()/4;
        for(int i=1; i<elementsToPop; i++){
            queue.dequeue();
        }
        assertThat(queue.getCurrentCapacity()).isEqualTo(DEFAULT_SIZE*2);
        queue.dequeue();
        assertThat(queue.getCurrentCapacity()).isEqualTo(DEFAULT_SIZE); //20/2 para 40/2 sería defs*=2

    }

}

