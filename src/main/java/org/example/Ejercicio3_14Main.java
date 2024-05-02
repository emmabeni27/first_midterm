package org.example;

public class Ejercicio3_14Main {
    public static void main(String[] args) {
        Ejercicio3_14 myQueue = new Ejercicio3_14(3); //inicializo la queue
        myQueue.enqueue("Hola");
        myQueue.enqueue("Hallo");
        myQueue.enqueue("hello");
        myQueue.enqueue("SALUT");
        myQueue.enqueue("Privat!");
        System.out.println(myQueue.capacity); //si capacity es privado no lo puedo usar en pvsm
    }
}
