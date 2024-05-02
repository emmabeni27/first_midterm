package org.example;

public class ResizingArrayQueueOfStrings {
    String[] myArray;
    int initialCapacity;
    int size=0;
    int head=0;
    int tail=0;

    public  ResizingArrayQueueOfStrings(int initialCapacity){
        this.initialCapacity=initialCapacity;
        myArray= new String[initialCapacity];
    }

    public void resize(int newCapacity){

    }
    public void enqueue(String message){
        myArray[tail]=message;
        size++;
        tail++;
    }

}
