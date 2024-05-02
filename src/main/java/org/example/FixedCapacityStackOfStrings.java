package org.example;

public class FixedCapacityStackOfStrings {

    private String[] a;
    private int N;
    private int cap;

    public FixedCapacityStackOfStrings(int cap) {
        this.cap=cap;
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }

    public boolean isFull(){
        return a.length==N; //usar length para longitud!!!! y reducir el if
    }
    public String peek(){
        return a[N-1];
    }
}