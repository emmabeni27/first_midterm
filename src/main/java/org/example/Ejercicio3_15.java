package org.example;

import java.util.Queue;

public class Ejercicio3_15 {
    //no necesito constructor pq no tengo que inicializar objetos
    public void printItems(Queue<String> myQueue, int k) {
        int count = 0;
        for (String item : myQueue) {
            if (count == k-1) {
                System.out.println(item);
                return;
            } else {
                count++;
            }
        }
    }

}
