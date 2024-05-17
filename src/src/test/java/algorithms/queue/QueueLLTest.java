package algorithms.queue;
import org.junit.Test;


import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;


public class QueueLLTest{
@Test
public void enqueue(){
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("MoonRiver");
        queue.enqueue("Chandelier");
        assertThat(queue.size()).isEqualTo(2);
        }
@Test
public void dequeue(){
    LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("MoonRiver");
        queue.enqueue("Chandelier");
        queue.enqueue("Fernando");
        queue.enqueue("Waterloo");
        assertThat(queue.size()).isEqualTo(4);
        queue.dequeue();
        assertThat(queue.size()).isEqualTo(3);
        assertThat(queue.dequeue()).isEqualTo("Chandelier");
        assertFalse(queue.isEmpty());

        }

@Test
public void underflow(){
    LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("MoonRiver");
        queue.dequeue();
        assertThrows(NoSuchElementException.class,queue::dequeue);
        }

@Test
public void isEmptyFalse(){
    LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("UncantoaGalicia");
        assertFalse(queue.isEmpty());
        }

@Test
public void isEmptyTrue(){
    LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertTrue(queue.isEmpty());
        }

@Test
public void size(){
    LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertThat(queue.size()).isEqualTo(4);
        }
        }
