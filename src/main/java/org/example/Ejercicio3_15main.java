package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ejercicio3_15main {
    public static void main(String[] args) {
        Queue<String> myQueue = new ArrayDeque<>();//necesita clase precisa
        myQueue.add("Hola");
        myQueue.add("Mundo");
        myQueue.add("Adiós");
        myQueue.add("What a wonderful world");
        Ejercicio3_15 ejercicio = new Ejercicio3_15();
        ejercicio.printItems(myQueue, 2);
    }
}