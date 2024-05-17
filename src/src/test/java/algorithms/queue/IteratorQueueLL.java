package algorithms.queue;

        import org.junit.Test;
        import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
        import java.util.Iterator;
        import java.util.LinkedList;
        import java.util.NoSuchElementException;

        import static org.junit.Assert.*;


public class IteratorQueueLL{
@Test
public void hasNext(){
    LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("Object1");
        queue.enqueue("Object2");
        queue.enqueue("Object3");
        assertTrue(queue.iterator().hasNext());

        Iterator iter=queue.iterator();
        while(iter.hasNext()){
        iter.next();
        }
        assertFalse(iter.hasNext());
        }
@Test
public void next(){
    LinkedListQueue<String> queue = new LinkedListQueue<>();

        assertThrows(NoSuchElementException.class,()->{queue.iterator().next();});
        queue.enqueue("object1");
        queue.enqueue("object2");
        queue.enqueue("object3");

        Iterator iter=queue.iterator();
        assertThat(iter.next()).isEqualTo("object1");
        assertThat(iter.next()).isEqualTo("object2");
        assertThat(iter.next()).isEqualTo("object3");
        assertThrows(NoSuchElementException.class,()->{iter.next();});

        }
        }