package org.example;

import java.util.NoSuchElementException;

public class Ejercicio3_29 <E>{

    private class Node<E> {
        E item;
        Node<E> next;
        public Node(E item){
            this.item=item;
            this.next=null;
        }
    }

    Node<E> last;
    int size=0;

    public Ejercicio3_29(){
        this.last=null;
    }

    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            last = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode; //para que el last se siempre el último que agrego, si fuera first se quedaría quieto
            size++;
        }
    }
        public E dequeue() {
        if(isEmpty()){
           throw new NoSuchElementException("Empty");
        }
            Node<E> toDelete=last.next; //por se queue
        if(size==1){
            last=null;
        }
        else{

           last.next=toDelete.next; //last.next.next

        }
            return toDelete.item;
        }

        public boolean isEmpty() {
            return size==0;
        }

//el iterador es lo mismo, cuidado donde lo incializo, cómo lo recorro
}


