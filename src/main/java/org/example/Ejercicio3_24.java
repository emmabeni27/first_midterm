package org.example;

import org.junit.Test;
//NO HABILITA TIPADO GENÉRICO!!!!!
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Ejercicio3_24<E> {
    int size;
    Node<E> head = null;
    Node<E> tail = null;

    private class Node<E> {
        E item;
        Node<E> next;
    }

    Node<E> myLL = new Node<>();

    public void removeAfter(Node<E> node) {

        for (Node<E> current = head; current.next != null; current = current.next) { //no tengo en cuenta el último por consignaaaaa!!!!!

            if (current.item.equals(node.item)) { //quiero ver si el contendio del nodo es igual, comparo dos instancias de una misma clase. Miro atributo por atributo que tenga mismo contenido (son 2 objetos de la clase Node)
                //2 instancias iguales si todos los atributos tienen el mismo valor y el mismo tipo
                //si son de la misma clase, los atributos son del mismo tipo
                current.next = current.next.next;
                break;
            }

        }

    }

    public void insertAfter(Node<E> firstNode, Node<E> secondNode) {
        if (firstNode == null || secondNode == null) {
            return; //retorna void
        }
        for (Node<E> current = head; current != null; current = current.next) { //hasta current pq no hay condiciones sobre el siguiente
            if (current.item.equals(firstNode.item)) {
                secondNode.next = current.next; //usar el current que ya está en ll, no nodo de referenci que me pasa el usuario
                current.next = secondNode;
            }
        }

    }

    //CORREGIR PARA TAIL???
    public void remove(Node<E> myLL, String key) { //con un nodo ya tengo toda una LL
        Node<E> current;
        for (current = head; current != null; current = current.next) {
            if (current.next != null) { //pq si no chequeo cuando ya estoy parada en el nodo que quiero borrar, y si no es double LL no puedo retroceder
                if (current.next.item.equals(key)) {
                    if (current.next.next == null) {
                        current.next = null;
                    } else {

                        current.next = current.next.next;
                    }


                }
            }
        }
    }

}


