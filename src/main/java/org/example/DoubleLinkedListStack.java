package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoubleLinkedListStack<E>{


        private Node<E> linkedListStack;
        private Node<E> tail; //node por se puntero a nodo

        private int notEmpty=0;

        public DoubleLinkedListStack(){ //constructor no parametrizado (con input)
            linkedListStack = null; //no puedo poner E en los diamantes?
            tail=null;
            //recién paso primer elemento al momento de primer push
        }

        // es una estructura dinámica, sin tamaño inicial

        //@Override
        public void push(E element) {
            Node<E> topOfStack = new Node<>(element);
            linkedListStack.previous=topOfStack;
            topOfStack.next=linkedListStack; //la recorre para atrás, asigno nuevo segundo
            if(isEmpty()){
                tail= topOfStack; //punteros a los nodos (cajitas), no a la variable suelta
            }
            notEmpty+=1;
            linkedListStack = topOfStack; //mi nuevo primero es el último elemento que inserté en el stack. Englobo
            //todo lo que va a ser mi próximo segundo
        }

        //@Override
        public E pop() {
            if (!isEmpty()) {
                final Node<E> toDelete = linkedListStack;

                linkedListStack=linkedListStack.next; //mi nuevo top es lo que era el segundo elemento
                if(linkedListStack!=null) {
                    linkedListStack.previous = null;
                }
                else{
                    tail=null;
                }
                notEmpty--;
                return (E) toDelete.element;
            }
            else{
                throw new NoSuchElementException("Failure: empty stack");
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




        public Iterator<E> iterator() {
            return new LinkedListIterator();
        }
        public Iterator<E> iteratorR() {
        return new LinkedListIteratorR();
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

        //si es iterable, implementa interfaz iterable. Subclase que implmenta iterator (que retorna instancia de iterator)
        private class LinkedListIterator implements Iterator<E>{ //como tiene que recorrer esta implementación
            private DoubleLinkedListStack.Node currentTopOfStack = linkedListStack; //es el top of stack! sirve para no perder stack al recorrerlo
            //además siempre devolvería lo mismo
            @Override
            public boolean hasNext() {
                return currentTopOfStack!=null;
            }//nunca se da el caso de "silla vacía"
            @Override
            public E next(){
                if(hasNext()){
                    E currentInformation= (E) currentTopOfStack.element;
                    currentTopOfStack=currentTopOfStack.next; //para que almacene otro valor y no quede fijo.
                    return currentInformation;
                }
                else{
                    throw new NoSuchElementException("Failure: empty stack");
                }
            }
        }
    private class LinkedListIteratorR implements Iterator<E>{ //como tiene que recorrer esta implementación
        private DoubleLinkedListStack.Node currentTopOfStack = tail; //es el top of stack! sirve para no perder stack al recorrerlo
        //además siempre devolvería lo mismo
        @Override
        public boolean hasNext() {
            return currentTopOfStack!=null;
        }//nunca se da el caso de "silla vacía"
        @Override
        public E next(){
            if(hasNext()){
                E currentInformation= (E) currentTopOfStack.element;
                currentTopOfStack=currentTopOfStack.previous; //para que almacene otro valor y no quede fijo.
                return currentInformation;
            }
            else{
                throw new NoSuchElementException("Failure: empty stack");
            }
        }
    }




    }

