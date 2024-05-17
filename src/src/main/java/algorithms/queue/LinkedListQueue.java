package algorithms.queue;

import algorithms.stack.LinkedListStack;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {
    private int notEmpty=0;
    private Node<E> head;
    private Node<E> tail;
    public LinkedListQueue(){

        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueue(@NotNull E element){

        Node<E> newTail= new Node<>(element);
        if(isEmpty()){
            head=newTail; //única vez que asigno valor a head
            tail=newTail;

        }
        else{
            tail.next=newTail; //primero lo enlazo a la siguiente posición
            tail=newTail;// ahora muevo el puntero tail
        }
        notEmpty+=1;
    }

    @Override
    public @NotNull E dequeue() {

        if(notEmpty!=0){
            final Node<E> toDelete = head;
            head=head.next;// al quedar el primer elemento sin puntero ya lo pierdo

            if(head==null){ //completamente vacía
                tail=null;
            }

            notEmpty--;
            return (E) toDelete.element;

        }
        else{
            throw new NoSuchElementException("Failure: empty queue");
        }

    }

    @Override
    public boolean isEmpty() {
        return notEmpty==0;
    }

    @Override
    public int size() {
        return notEmpty;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }
    private class Node<E> {
        private E element;
        private Node<E> next; //contiene el contenido de sí mimo y el nodo siguiente

        public Node(E element) {
            this.element = element;
            this.next = null; //no tengo nada que siga!
        }   //todas sublcases con mimo tipo e genérico
    }
    private class LinkedListQueueIterator implements Iterator<E>{
        private LinkedListQueue.Node currentFirst = head; //es el top of stack! sirve para no perder stack al recorrerlo
        //además siempre devolvería lo mismo
        @Override
        public boolean hasNext() {
            return currentFirst!=null;
        }
        @Override
        public E next(){
            if(hasNext()){
                E currentInformation= (E) currentFirst.element; //si uso head pierdo referencia a lista grande-->recurrir a puntero auxiliar!!

                currentFirst=currentFirst.next; //para que almacene otro valor y no quede fijo.
                return currentInformation;
            }
            else{
                throw new NoSuchElementException("Failure: empty stack");
            }
        }
    }


}
