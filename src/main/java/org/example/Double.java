package org.example;
//Write a code fragment that prints true if the double variables x and y are both
//strictly between 0 and 1 and false otherwise.

public class Double {
    double x;
    double y;

    public Double(double x, double y){
        this.x=x;
        this.y=y;
    }
    public boolean isStrictly(){
        if(0<x && x<1 && 0<y && y<1){
            return true;
        }
        else{
            return false;
        }
    }

    }

