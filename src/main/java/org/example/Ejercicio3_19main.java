package org.example;
//implementar stack con linked list
public class Ejercicio3_19main {
    public static void main(String[] args) {
        Ejercicio3_19<String> linkedList= new Ejercicio3_19<>();
        linkedList.push("first");
        linkedList.push("second");
        linkedList.push("third");
        linkedList.push("fourth");
        System.out.println(linkedList.removeLast());
    }

}
