package org.example;

import java.util.NoSuchElementException;

public class Ejercicio3_20 <E>{

    int notEmpty;
    private Node<E> head;
    private Node<E> tail;

    public Ejercicio3_20(){
        head=null;
        tail=null;
        notEmpty=0;
    }
    public  void enqueue(E element){
        Node<E> newTail= new Node<>(element);
        if(notEmpty==0){
            head=newTail; //única vez que asigno valor a head
            tail=newTail;

        }
        else{
            tail.next=newTail; //primero lo enlazo a la siguiente posición
            tail=newTail;// ahora muevo el puntero tail
        }
        notEmpty+=1;

    }
    public int size() {
        return notEmpty;
    }
    public E dequeue(){
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
    public void delete(int k){
        if(k>size() || notEmpty==0) {
            throw new IndexOutOfBoundsException("Out of bounds");
            //otra excepción no such...
        }

        else if(k<=size()){
            int count=0;
            for(Node<E> current = head; current != null; current = current.next){ //si current.next!=null no entra a tail
                if(count == k-1){
                    //Node<E> toDelete =current;
                    System.out.println(current.next.element); // Imprime el elemento que será eliminado.
                    current.next = current.next.next; //acá hago el delete
                    //return toDelete; // Sale del bucle después de eliminar el nodo.
                    break;
                }

                else{
                    count++;
                }
            }
        }

        }
    private class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    }

