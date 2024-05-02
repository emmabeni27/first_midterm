package org.example;


public class Ejercicio3_20main {
    public static void main(String[] args) {
        Ejercicio3_20<String> linkedList =new Ejercicio3_20();
        linkedList.enqueue("Hallo Wlet!");
        linkedList.enqueue("Tschüss");
        linkedList.enqueue("Keine Maschine");
        linkedList.delete(0);
    }
}
