package org.example;
import java.util.Iterator;
import java.util.Queue;
import java.util.NoSuchElementException;


public class DoubleLinkedListQueue<E> {

        private int notEmpty=0;
        private Node<E> head;
        private Node<E> tail;

        public DoubleLinkedListQueue(){

            this.head = null;
            this.tail = null;
        }

        //@Override
        public void enqueue(E element){

            Node<E> newTail= new Node<>(element);
            if(isEmpty()){
                head=newTail; //única vez que asigno valor a head
                tail=newTail;


            }
            else{
                tail.next=newTail; //primero lo enlazo a la siguiente posición
                newTail.previous=tail;
                tail=newTail;// ahora muevo el puntero tail

            }
            notEmpty+=1;
        }

        //@Override
        public E dequeue() {

            if(notEmpty!=0){
                final Node<E> toDelete = head;
                head=head.next;// al quedar el primer elemento sin puntero ya lo pierdo
                head.previous=null;

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

        //@Override
        public boolean isEmpty() {
            return notEmpty==0;
        }

        //@Override
        public int size() {
            return notEmpty;
        }


        //@Override
        public Iterator<E> iterator() {
            return new DoubleLinkedListQueueIterator();
        }

        public Iterator<E> iteratorR() {
        return new DoubleLinkedListQueueIteratorR();
    }
        private class Node<E> {
            private E element;
            private Node<E> next; //contiene el contenido de sí mimo y el nodo siguiente
            private Node<E> previous;

            public Node(E element) {
                this.element = element;
                this.next = null; //no tengo nada que siga!
                this.previous=null;
            }   //todas sublcases con mimo tipo e genérico
        }

        private class DoubleLinkedListQueueIterator implements Iterator<E>{
            private DoubleLinkedListQueue.Node currentFirst = head; //es el top of stack! sirve para no perder stack al recorrerlo
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

    private class DoubleLinkedListQueueIteratorR implements Iterator<E>{
        private DoubleLinkedListQueue.Node currentFirst = tail; //es el top of stack! sirve para no perder stack al recorrerlo
        //además siempre devolvería lo mismo
        @Override
        public boolean hasNext() {
            return currentFirst!=null;
        }
        @Override
        public E next(){
            if(hasNext()){
                E currentInformation= (E) currentFirst.element; //si uso head pierdo referencia a lista grande-->recurrir a puntero auxiliar!!

                currentFirst=currentFirst.previous; //para que almacene otro valor y no quede fijo.
                return currentInformation;
            }
            else{
                throw new NoSuchElementException("Failure: empty stack");
            }
        }
    }

    }


