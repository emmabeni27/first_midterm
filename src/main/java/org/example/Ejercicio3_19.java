package org.example;
import java.util.NoSuchElementException;


public class Ejercicio3_19<E> {
    private Node<E> linkedListStack;
    int notEmpty;

    public Ejercicio3_19(){
    linkedListStack=null;
    notEmpty = 0;
    }
        public void push( E element) {
            notEmpty+=1;
            Node<E> topOfStack = new Node<E>(element);
            topOfStack.next=linkedListStack; //la recorre para atrás, asigno nuevo segundo
            linkedListStack = topOfStack; //mi nuevo primero es el último elemento que inserté en el stack. Englobo
            //todo lo que va a ser mi próximo segundo
        }

        public E removeLast() {
            if (!isEmpty()) {
                final Node<E> toDelete = linkedListStack;
                linkedListStack=linkedListStack.next; //mi nuevo top es lo que era el segundo elemento
                notEmpty--;
                return (E) toDelete.element;
            }
            else{
                throw new NoSuchElementException("Failure: empty stack");
            }
        }


    private class Node<E> {
        private E element;
        private Node<E> next; //contiene el contenido de sí mimo y el nodo siguiente

        public Node(E element) {
            this.element = element;
            this.next = null; //no tengo nada que siga!
        }
    }
    public boolean isEmpty(){
        return notEmpty==0;
    }
    }
