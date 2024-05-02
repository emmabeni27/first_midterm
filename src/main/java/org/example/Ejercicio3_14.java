package org.example;

public class Ejercicio3_14 {
    private String[] myStack;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    public int capacity;

    public Ejercicio3_14(int capacity) {
        this.capacity = capacity;
        myStack = new String[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int newcapacity) {
        String[] newarrayqueue = new String[newcapacity];

        for (int i = 0; i < size; i++)

            newarrayqueue[i] = myStack[(head + i) % capacity]; //asigno los nuevos elementos
        capacity =newcapacity;
        myStack =newarrayqueue;//ahora la piso
        head =0; // una vez que ya hice el resize reinicio el head a 0
        tail =size;// tail d
    }



    public void enqueue(String item){
        if(size==myStack.length){
            resize(myStack.length*2);
        }
        myStack[tail]=item;
        tail++;
        size++;
    }

    public void dequeue(){
        if(size==0){
            throw new IllegalArgumentException("Underflow");
        }
        myStack[tail-1]=null;
        tail--;
        size--;
        if(size<=capacity/4){
            resize(myStack.length/2);
        }
    }

}
