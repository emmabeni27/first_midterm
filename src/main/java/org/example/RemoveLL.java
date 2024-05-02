package org.example;


public class RemoveLL{
private Node head;
private Node tail;

    private class Node<E> {
        private E element;
        private Node<E> next; //contiene el contenido de sí mimo y el nodo siguiente

        public Node(E element) {
            this.element = element;
            this.next = null; //no tengo nada que siga!
        }   //todas sublcases con mimo tipo e genérico
    }
}
