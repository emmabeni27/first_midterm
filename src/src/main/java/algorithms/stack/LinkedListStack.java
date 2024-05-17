package algorithms.stack;

import algorithms.tree.Node;
import org.jetbrains.annotations.NotNull;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E> {

    //implemento interfaz stack o la clase que yo creé
    private Node<E> linkedListStack; //puntero al tope del stack
    //con esto genero primer nodo y por tanto todoa la linked list
    private int notEmpty=0; //sería el size de los códigos anteriores

    //se está inicializando como linked list?

    public LinkedListStack(){ //constructor no parametrizado (con input)
        linkedListStack = null; //no puedo poner E en los diamantes?
        //recién paso primer elemento al momento de primer push
    }

    // es una estructura dinámica, sin tamaño inicial

    @Override
    public void push(@NotNull E element) {
        notEmpty+=1;
        Node<E> topOfStack = new Node<>(element);
        topOfStack.next=linkedListStack; //la recorre para atrás, asigno nuevo segundo
        linkedListStack = topOfStack; //mi nuevo primero es el último elemento que inserté en el stack. Englobo
        //todo lo que va a ser mi próximo segundo
    }

    @Override
    public E pop() {
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
    public Iterator <E> iterator() {
        return new LinkedListIterator();
    }

    private class Node<E> {
        private E element;
        private Node<E> next; //contiene el contenido de sí mimo y el nodo siguiente

        public Node(E element) {
            this.element = element;
            this.next = null; //no tengo nada que siga!
        }   //todas sublcases con mimo tipo e genérico
    }
    //si es iterable, implementa interfaz iterable. Subclase que implmenta iterator (que retorna instancia de iterator)
    private class LinkedListIterator implements Iterator<E>{ //como tiene que recorrer esta implementación
        private LinkedListStack.Node currentTopOfStack = linkedListStack; //es el top of stack! sirve para no perder stack al recorrerlo
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




}
